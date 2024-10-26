package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 调度任务
 * @author lw
 * @create 2024-09-25-21:58
 */
@Data
@TableName("job_task_batch")
public class JobTaskBatch extends CreateUpdateDt {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String namespaceId;

    private String groupName;

    private Long jobId;

    /**
     * 工作流批次id
     */
    private Long workflowTaskBatchId;

    /**
     * 工作流节点id
     */
    private Long workflowNodeId;

    /**
     * 工作流父节点id
     */
    private Long parentWorkflowNodeId;

    /**
     * 任务批次状态
     */
    private Integer taskBatchStatus;

    /**
     * 任务执行时间
     */
    private Long executionAt;

    /**
     * 任务类型  job  workflow
     */
    private Integer systemTaskType;

    /**
     * 操作原因
     */
    private Integer operationReason;

    private Integer deleted;
}
