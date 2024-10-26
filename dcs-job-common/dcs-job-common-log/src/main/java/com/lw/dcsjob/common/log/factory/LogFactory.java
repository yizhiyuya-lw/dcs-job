package com.lw.dcsjob.common.log.factory;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.caller.CallerUtil;
import cn.hutool.core.map.SafeConcurrentHashMap;
import cn.hutool.core.util.ServiceLoaderUtil;
import com.lw.dcsjob.common.log.dialect.Log;
import com.lw.dcsjob.common.log.dialect.console.ConsoleLogFactory;
import com.lw.dcsjob.common.log.dialect.jdk.JdkLogFactory;

import java.net.URL;
import java.util.Map;

/**
 * 日志工厂类
 * @author lw
 * @create 2024-09-27-21:39
 */
public abstract class LogFactory {

    /**
     * 日志框架名，用于打印当前所用日志框架
     */
    protected String name;

    /**
     * 日志对象缓存
     */
    private final Map<Object, Log> logCache;

    public LogFactory(String name) {
        this.name = name;
        this.logCache = new SafeConcurrentHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public Log getLog(String name) {
        return logCache.computeIfAbsent(name, o -> createLog((String) o));
    }

    public Log getLog(Class<?> clazz) {
        return logCache.computeIfAbsent(clazz, o -> createLog((Class<?>) o));
    }

    public abstract Log createLog(String name);

    public abstract Log createLog(Class<?> clazz);

    /**
     * 检查日志是否存在
     * @param logClass
     */
    protected void checkLogExist(Class<?> logClass) {

    }

    public static LogFactory getCurrentLogFactory() {
        return GlobalLogFactory.get();
    }

    public static LogFactory setCurrentLogFactory(Class<? extends LogFactory> logFactoryClass) {
        return GlobalLogFactory.set(logFactoryClass);
    }

    public static LogFactory setCurrentLogFactory(LogFactory logFactory) {
        return GlobalLogFactory.set(logFactory);
    }

    public static Log get(String name) {
        return getCurrentLogFactory().getLog(name);
    }

    public static Log get(Class<?> clazz) {
        return getCurrentLogFactory().getLog(clazz);
    }

    public static Log get() {
        return get(CallerUtil.getCallerCaller());
    }

    public static LogFactory create() {
        final LogFactory factory = doCreate();
        factory.getLog(LogFactory.class);
        return factory;
    }

    private static LogFactory doCreate() {
        LogFactory logFactory = ServiceLoaderUtil.loadFirstAvailable(LogFactory.class);
        if (null != logFactory) {
            return logFactory;
        }

        URL url = ResourceUtil.getResource("logging.properties");
        return (null != url) ? new JdkLogFactory() : new ConsoleLogFactory();
    }

    public static Throwable extractThrowable(Object... args) {
        if (null == args || args.length == 0) {
            return null;
        }
        final Object lastEntry = args[args.length - 1];
        if (lastEntry instanceof Throwable) {
            return (Throwable) lastEntry;
        }
        return null;
    }
}
