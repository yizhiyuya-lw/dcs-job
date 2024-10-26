package com.lw.dcsjob.common.log.dialect.log4j;

import com.lw.dcsjob.common.log.dialect.Log;
import com.lw.dcsjob.common.log.factory.LogFactory;

/**
 * @author lw
 * @create 2024-09-27-22:35
 */
public class Log4jLogFactory extends LogFactory {

    public Log4jLogFactory() {
        super("Log4j");
        checkLogExist(org.apache.log4j.Logger.class);
    }

    @Override
    public Log createLog(String name) {
        return new Log4jLog(name);
    }

    @Override
    public Log createLog(Class<?> clazz) {
        return new Log4jLog(clazz);
    }
}
