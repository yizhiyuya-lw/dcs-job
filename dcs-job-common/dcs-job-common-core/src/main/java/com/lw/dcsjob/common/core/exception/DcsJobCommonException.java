package com.lw.dcsjob.common.core.exception;

/**
 * @author lw
 * @create 2024-10-29-20:32
 */
public class DcsJobCommonException extends BaseDcsJobException {

    public DcsJobCommonException(String message) {
        super(message);
    }

    public DcsJobCommonException(String message, Object... arguments) {
        super(message, arguments);
    }

    public DcsJobCommonException(String message, Object[] arguments, Throwable cause) {
        super(message, arguments, cause);
    }

    public DcsJobCommonException(String message, Object argument, Throwable cause) {
        super(message, argument, cause);
    }

    public DcsJobCommonException(String message, Object argument) {
        super(message, argument);
    }
}
