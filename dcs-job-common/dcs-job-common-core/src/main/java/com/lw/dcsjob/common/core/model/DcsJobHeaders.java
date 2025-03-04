package com.lw.dcsjob.common.core.model;

import com.lw.dcsjob.common.core.constant.SystemConstants;
import lombok.Data;

/**
 * dsc-job 请求头信息
 * @author lw
 * @create 2024-10-29-20:59
 */
@Data
public class DcsJobHeaders {

    /**
     * 是否重试流量
     */
    private boolean isRetry;

    /**
     * 重试下发的ID
     */
    private String retryId;

    /**
     * 调用链超时时间  单位ms
     */
    private long ddl = SystemConstants.DEFAULT_DDL;
}
