package com.lw.dcsjob.common.core.exception;

import org.slf4j.helpers.MessageFormatter;

import java.text.MessageFormat;

/**
 * 基础异常类
 * @author lw
 * @create 2024-09-24-21:02
 */
public class BaseDcsJobException extends RuntimeException {
    public BaseDcsJobException() {
    }

    public BaseDcsJobException(String message) {
        super(message);
    }

    public BaseDcsJobException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseDcsJobException(Throwable cause) {
        super(cause);
    }

    public BaseDcsJobException(String message, Object... arguments) {
        this(message, getArguments(arguments), getThrowable(arguments));
    }

    public BaseDcsJobException(String message, Object[] arguments, Throwable cause) {
        super(MessageFormatter.arrayFormat(message, arguments).getMessage(), cause);
    }

    public BaseDcsJobException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BaseDcsJobException(String message, Object argument) {
        super(MessageFormatter.format(message, argument).getMessage());
    }

    public static Object[] getArguments(Object... arguments) {
        Object argument = arguments[arguments.length - 1];
        if (argument instanceof Throwable) {
            Object[] dest = new Object[arguments.length - 1];
            System.arraycopy(arguments, 0, dest, 0, arguments.length - 1);
            return dest;
        }
        return arguments;
    }

    public static Throwable getThrowable(Object... arguments) {
        return arguments.length == getArguments(arguments).length ? null : (Throwable) arguments[arguments.length - 1];
    }
}
