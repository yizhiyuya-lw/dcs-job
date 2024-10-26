package com.lw.dcsjob.common.log.level;

/**
 * @author lw
 * @create 2024-09-27-21:37
 */
public interface WarnLog {

    boolean isWarnEnabled();

    void warn(Boolean remote, Throwable t);

    void warn(Boolean remote, String format, Object... arguments);

    void warn(Boolean remote, String fqcn, String format, Object... arguments);

    void warn(Boolean remote, String msg);

    void warn(Boolean remote, String msg, Throwable t);
}
