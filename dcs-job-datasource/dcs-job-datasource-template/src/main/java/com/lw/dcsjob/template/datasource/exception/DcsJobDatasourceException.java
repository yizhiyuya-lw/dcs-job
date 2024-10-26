package com.lw.dcsjob.template.datasource.exception;

import com.lw.dcsjob.common.core.exception.BaseDcsJobException;

/**
 * 数据源模块异常类
 * @author lw
 * @create 2024-09-24-21:33
 */
public class DcsJobDatasourceException extends BaseDcsJobException {

    public DcsJobDatasourceException(String message) {
        super(message);
    }

    public DcsJobDatasourceException(String message, Object... arguments) {
        super(message, arguments);
    }
}
