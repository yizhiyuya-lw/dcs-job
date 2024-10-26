package com.lw.dcsjob.template.datasource.persistence.dataobject;

import lombok.Data;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:30
 */
@Data
public class WorkflowBatchQueryDO {

    private List<String> groupNames;

    private Integer bastBatchStatus;

    private String workflowName;

    private Long workflowId;

    private String namespaceId;
}
