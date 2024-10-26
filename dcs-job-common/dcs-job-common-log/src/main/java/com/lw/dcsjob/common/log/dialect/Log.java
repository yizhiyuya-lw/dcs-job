package com.lw.dcsjob.common.log.dialect;

import com.lw.dcsjob.common.log.factory.LogFactory;
import com.lw.dcsjob.common.log.lang.LogCaller;
import com.lw.dcsjob.common.log.level.*;

/**
 * 日志统一接口
 * @author lw
 * @create 2024-09-27-21:38
 */
public interface Log extends TraceLog, DebugLog, InfoLog, WarnLog, ErrorLog {

    /**
     * 获取日志对象的Name
     * @return
     */
    String getName();

    /**
     * 是否开启指定日志
     * @param level
     * @return
     */
    boolean isEnabled(Level level);

    /**
     * 打印指定级别的日志
     * @param level
     * @param remote
     * @param format
     * @param args
     */
    void log(Level level, Boolean remote, String format, Object... args);

    /**
     * 打印指定级别的日志
     * @param level
     * @param remote
     * @param fqcn
     * @param format
     * @param args
     */
    void log(Level level, Boolean remote, String fqcn, String format, Object... args);

    static Log get(Class<?> clazz) {
        return LogFactory.get(clazz);
    }

    static Log get(String name) {
        return LogFactory.get(name);
    }

    static Log get() {
        return LogFactory.get(LogCaller.getCallerCaller());
    }
}
