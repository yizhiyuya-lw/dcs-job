package com.lw.dcsjob.template.datasource.persistence.dataobject;

import lombok.Data;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:20
 */
@Data
public class JobBatchQueryDO {

    private List<String> groupNames;

    private Integer taskBatchStatus;

    private String jobName;

    private Long jobId;

    private String namespaceId;
}
