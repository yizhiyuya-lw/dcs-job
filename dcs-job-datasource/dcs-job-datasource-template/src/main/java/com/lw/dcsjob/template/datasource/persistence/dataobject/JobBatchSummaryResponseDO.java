package com.lw.dcsjob.template.datasource.persistence.dataobject;

import lombok.Data;

/**
 * @author lw
 * @create 2024-09-26-20:24
 */
@Data
public class JobBatchSummaryResponseDO {

    private String namespaceId;

    private String groupName;

    private Long jobId;

    private int taskBatchStatus;

    private Long operationReason;

    private Integer operationReasonTotal;

    private Integer successNum;

    private Integer cancelNum;

    private Integer stopNum;

    private Integer failNum;
}
