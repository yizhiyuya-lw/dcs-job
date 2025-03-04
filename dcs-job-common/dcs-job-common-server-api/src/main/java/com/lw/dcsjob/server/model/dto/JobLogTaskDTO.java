package com.lw.dcsjob.server.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lw
 * @create 2024-10-29-21:46
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class JobLogTaskDTO extends LogTaskDTO {

    /**
     * 任务信息id
     */
    private Long jobId;

    /**
     * 任务实例id
     */
    private Long taskBatchId;

    /**
     * 调度任务id
     */
    private Long taskId;
}
