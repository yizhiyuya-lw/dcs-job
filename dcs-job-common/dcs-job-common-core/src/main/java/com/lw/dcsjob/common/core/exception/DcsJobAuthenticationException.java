package com.lw.dcsjob.common.core.exception;

import lombok.Getter;

/**
 * @author lw
 * @create 2025-03-05-20:35
 */
@Getter
public class DcsJobAuthenticationException extends BaseDcsJobException {
    private final Integer errorCode = 5001;

    public DcsJobAuthenticationException(final String message) {
        super(message);
    }

    public DcsJobAuthenticationException(String message, Object... arguments) {
        super(message, arguments);
    }

    public DcsJobAuthenticationException(String message, Object[] arguments, Throwable cause) {
        super(message, arguments, cause);
    }

    public DcsJobAuthenticationException(String message, Object argument, Throwable cause) {
        super(message, argument, cause);
    }

    public DcsJobAuthenticationException(String message, Object argument) {
        super(message, argument);
    }
}
