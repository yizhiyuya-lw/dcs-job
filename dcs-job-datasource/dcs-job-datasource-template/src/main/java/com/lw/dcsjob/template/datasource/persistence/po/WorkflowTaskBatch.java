package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lw
 * @create 2024-09-25-22:33
 */
@Data
@TableName("workflow_task_batch")
public class WorkflowTaskBatch extends CreateUpdateDt {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 命名空间id
     */
    private String namespaceId;

    /**
     * 组名称
     */
    private String groupName;

    private Long workflowId;

    private Integer taskBatchStatus;

    private Integer operationReason;

    private Long executionAt;

    private String flowInfo;

    private String extAttrs;

    private Integer deleted;

    @TableField(value = "version", update = "%s+1")
    private Integer version;

    /**
     * 全局上下文
     */
    private String wfContext;
}
