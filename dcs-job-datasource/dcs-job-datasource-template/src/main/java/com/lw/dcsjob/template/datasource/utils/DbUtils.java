package com.lw.dcsjob.template.datasource.utils;

import com.lw.dcsjob.common.core.context.DcsJobSpringContext;
import com.lw.dcsjob.template.datasource.enums.DbTypeEnum;
import org.springframework.core.env.Environment;

/**
 * 数据库工具
 * @author lw
 * @create 2024-09-24-21:49
 */
public class DbUtils {

    public static DbTypeEnum getDbType() {
        Environment environment = DcsJobSpringContext.getBean(Environment.class);
        String url = environment.getProperty("spring.datasource.url");
        return DbTypeEnum.modeOf(url);
    }
}
