package com.lw.dcsjob.common.log;

import com.lw.dcsjob.common.log.factory.GlobalLogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author lw
 * @create 2024-09-27-20:32
 */
@Configuration
@ComponentScan("com.lw.dcsjob.common.log.*")
public class CommonLogConfigure {

    @Autowired
    public void setEnvironment(Environment environment) {
        GlobalLogFactory.setEnvironment(environment);
    }
}
