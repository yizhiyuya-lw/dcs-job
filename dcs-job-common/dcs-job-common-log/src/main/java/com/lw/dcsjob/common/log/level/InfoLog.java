package com.lw.dcsjob.common.log.level;

/**
 * @author lw
 * @create 2024-09-27-21:35
 */
public interface InfoLog {

    boolean isInfoEnabled();

    void info(Boolean remote, Throwable t);

    void info(Boolean remote, String format, Object... arguments);

    void info(Boolean remote, String fqcn, String format, Object... arguments);

    void info(Boolean remote, String msg);

    void info(Boolean remote, String msg, Throwable t);
}
