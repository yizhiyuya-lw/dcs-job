package com.lw.dcsjob.common.log.level;

/**
 * @author lw
 * @create 2024-09-27-21:36
 */
public interface TraceLog {

    boolean isTraceEnabled();

    void trace(Boolean remote, Throwable t);

    void trace(Boolean remote, String format, Object... arguments);

    void trace(Boolean remote, String fqcn, String format, Object... arguments);

    void trace(Boolean remote, String msg);

    void trace(Boolean remote, String msg, Throwable t);
}
