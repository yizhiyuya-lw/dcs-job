package com.lw.dcsjob.template.datasource.persistence.dataobject;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lw
 * @create 2024-09-26-20:31
 */
@Data
public class WorkflowBatchResponseDO {

    private Long id;

    private String namespaceId;

    private String groupName;

    private Long workflowId;

    private String workflowName;

    private Integer taskBatchStatus;

    private Integer operationReason;

    private Long executionAt;

    private LocalDateTime createDt;
}
