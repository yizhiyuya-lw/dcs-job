package com.lw.dcsjob.common.core.exception;

/**
 * @author lw
 * @create 2024-10-29-21:32
 */
public class DcsJobRemotingTimeOutException extends BaseDcsJobException {
    public DcsJobRemotingTimeOutException(String message) {
        super(message);
    }

    public DcsJobRemotingTimeOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public DcsJobRemotingTimeOutException(Throwable cause) {
        super(cause);
    }

    public DcsJobRemotingTimeOutException(String message, Object... arguments) {
        super(message, arguments);
    }

    public DcsJobRemotingTimeOutException(String message, Object[] arguments, Throwable cause) {
        super(message, arguments, cause);
    }

    public DcsJobRemotingTimeOutException(String message, Object argument, Throwable cause) {
        super(message, argument, cause);
    }

    public DcsJobRemotingTimeOutException(String message, Object argument) {
        super(message, argument);
    }
}
