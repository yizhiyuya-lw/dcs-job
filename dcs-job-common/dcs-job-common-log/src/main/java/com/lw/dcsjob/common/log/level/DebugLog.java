package com.lw.dcsjob.common.log.level;

/**
 * @author lw
 * @create 2024-09-27-21:32
 */
public interface DebugLog {

    boolean isDebugEnabled();

    void debug(Boolean remote, Throwable t);

    void debug(Boolean remote, String format, Object... args);

    /**
     *
     * @param remote
     * @param fqcn 完全限定类名 fully qualified class name
     * @param format
     * @param args
     */
    void debug(Boolean remote, String fqcn, String format, Object... args);

    void debug(Boolean remote, String msg);

    void debug(Boolean remote, String msg, Throwable t);
}
