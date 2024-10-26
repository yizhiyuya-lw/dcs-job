package com.lw.dcsjob.template.datasource.persistence.dataobject;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lw
 * @create 2024-09-26-20:22
 */
@Data
public class JobBatchResponseDO {

    private Long id;

    private String namespaceId;

    private String groupName;

    private String jobName;

    private Long jobId;

    private Integer taskBatchStatus;

    private LocalDateTime createDt;

    private LocalDateTime updateDt;

    private Long executionAt;

    private Integer operationReason;

    private Integer executorType;

    private String executorInfo;

    private Integer taskType;

    private Integer blockStrategy;

    private Integer triggerType;

    private String argsStr;
}
