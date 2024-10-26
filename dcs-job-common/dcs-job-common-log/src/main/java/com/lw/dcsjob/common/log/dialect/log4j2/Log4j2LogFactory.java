package com.lw.dcsjob.common.log.dialect.log4j2;

import com.lw.dcsjob.common.log.dialect.Log;
import com.lw.dcsjob.common.log.factory.LogFactory;

/**
 * @author lw
 * @create 2024-09-27-22:36
 */
public class Log4j2LogFactory extends LogFactory {

    public Log4j2LogFactory() {
        super("Log4j2");
        checkLogExist(org.apache.logging.log4j.LogManager.class);
    }

    @Override
    public Log createLog(String name) {
        return new Log4j2Log(name);
    }

    @Override
    public Log createLog(Class<?> clazz) {
        return new Log4j2Log(clazz);
    }
}
