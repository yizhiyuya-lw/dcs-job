package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lw
 * @create 2024-09-25-22:28
 */
@Data
@TableName("workflow")
public class Workflow extends CreateUpdateDt {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 工作流名称
     */
    private String workflowName;

    /**
     * 命名空间id
     */
    private String namespaceId;

    /**
     * 组名称
     */
    private String groupName;

    private Integer triggerType;

    private Integer blockStrategy;

    private String triggerInterval;

    private Integer executorTimeout;

    private Integer workflowStatus;

    private Long nextTriggerAt;

    private String flowInfo;

    private Integer bucketIndex;

    private String description;

    private String wfContext;

    @TableField(value = "version", update = "%s+1")
    private Integer version;

    private String extAttrs;

    private Integer deleted;
}
