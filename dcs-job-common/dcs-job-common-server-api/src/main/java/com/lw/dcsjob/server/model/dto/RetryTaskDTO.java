package com.lw.dcsjob.server.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 重试上报DTO
 * @author lw
 * @create 2024-10-29-21:47
 */
@Data
public class RetryTaskDTO implements Serializable {

    private String groupName;

    private String sceneName;

    /**
     * 业务唯一id
     */
    private String idempotentId;

    /**
     * 执行器名称
     */
    private String executorName;

    /**
     * 业务唯一编号
     */
    private String bizNo;

    /**
     * 客户端上报参数
     */
    private String argsStr;

    /**
     * 额外扩展参数
     */
    private String extAttrs;
}
