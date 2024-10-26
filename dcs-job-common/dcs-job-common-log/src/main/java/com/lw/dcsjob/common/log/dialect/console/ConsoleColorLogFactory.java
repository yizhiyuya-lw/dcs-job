package com.lw.dcsjob.common.log.dialect.console;

import com.lw.dcsjob.common.log.dialect.Log;
import com.lw.dcsjob.common.log.factory.LogFactory;

/**
 * @author lw
 * @create 2024-09-27-22:30
 */
public class ConsoleColorLogFactory extends LogFactory {

    public ConsoleColorLogFactory() {
        super("Console Color Logging");
    }

    @Override
    public Log createLog(String name) {
        return new ConsoleColorLog(name);
    }

    @Override
    public Log createLog(Class<?> clazz) {
        return new ConsoleColorLog(clazz);
    }
}
