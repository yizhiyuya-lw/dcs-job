package com.lw.dcsjob.common.log.factory;

import org.springframework.core.env.Environment;

import java.util.Objects;

/**
 * 全局日志工厂类
 * 用于减少日志工厂创建，减少日志库探测
 * @author lw
 * @create 2024-09-27-20:35
 */
public class GlobalLogFactory {

    private static volatile LogFactory currentLogFactory;
    private static final Object LOCK = new Object();

    private static Environment environment;

    public static void setEnvironment(final Environment environment) {
        GlobalLogFactory.environment = environment;
    }

    public static LogFactory get() {
        if (null == currentLogFactory) {
            synchronized (LOCK) {
                if (null == currentLogFactory) {
                    currentLogFactory = LogFactory.create();
                }
            }
        }
        return currentLogFactory;
    }

    public static LogFactory set(Class<? extends LogFactory> logFactoryClass) {
        try {
            return set(logFactoryClass.newInstance());
        } catch (Exception e) {
            throw new IllegalArgumentException("Can not instance LogFactory class!", e);
        }
    }

    public static LogFactory set(LogFactory logFactory) {
        logFactory.getLog(GlobalLogFactory.class).debug(false, "Custom Use [{}] Logger.", logFactory.name);
        currentLogFactory = logFactory;
        return currentLogFactory;
    }

    /**
     * 获取全局的日志开关
     * @return
     */
    public static Boolean logSwitch() {
        if (Objects.nonNull(environment)) {
            return environment.getProperty("dcs-job.log.status", Boolean.class);
        }
        return Boolean.TRUE;
    }
}
