package com.lw.dcsjob.common.log.lang;

import java.util.Objects;

/**
 * @author lw
 * @create 2024-09-27-22:14
 */
public class LogCaller {

    private static final Caller INSTANCE;

    static {
        INSTANCE = tryCreateCaller();
    }

    public static Class<?> getCallerCaller() {
        return INSTANCE.getCallerCaller();
    }

    private static Caller tryCreateCaller() {
        Caller caller;
        try {
            caller = new StackWalkerCaller();
            if (Objects.nonNull(caller.getCallerCaller())) {
                return caller;
            }
        } catch (Throwable e) {
            //do nothing
        }
        caller = new StackTraceCaller();
        return caller;
    }
}
