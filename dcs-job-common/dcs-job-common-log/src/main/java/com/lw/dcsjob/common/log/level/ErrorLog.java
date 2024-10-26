package com.lw.dcsjob.common.log.level;

/**
 * @author lw
 * @create 2024-09-27-21:35
 */
public interface ErrorLog {

    boolean isErrorEnabled();

    void error(Boolean remote, Throwable t);

    void error(Boolean remote, String format, Object... arguments);

    void error(Boolean remote, String fqcn, String format, Object... arguments);

    void error(Boolean remote, String msg);

    void error(Boolean remote, String msg, Throwable t);
}
