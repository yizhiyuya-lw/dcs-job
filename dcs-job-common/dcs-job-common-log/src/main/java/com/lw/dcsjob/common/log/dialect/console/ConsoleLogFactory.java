package com.lw.dcsjob.common.log.dialect.console;

import com.lw.dcsjob.common.log.dialect.Log;
import com.lw.dcsjob.common.log.factory.LogFactory;

/**
 * @author lw
 * @create 2024-09-27-22:07
 */
public class ConsoleLogFactory extends LogFactory {

    public ConsoleLogFactory() {
        super("Console Logging");
    }

    @Override
    public Log createLog(String name) {
        return new ConsoleLog(name);
    }

    @Override
    public Log createLog(Class<?> clazz) {
        return new ConsoleLog(clazz);
    }
}
