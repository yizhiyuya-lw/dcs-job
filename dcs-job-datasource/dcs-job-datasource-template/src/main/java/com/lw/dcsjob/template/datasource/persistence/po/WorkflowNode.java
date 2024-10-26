package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lw
 * @create 2024-09-25-22:31
 */
@Data
@TableName("workflow_node")
public class WorkflowNode extends CreateUpdateDt {

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
     * 节点名称
     */
    private String nodeName;

    /**
     * 组名称
     */
    private String groupName;

    private Long jobId;

    private Long workflowId;

    /**
     * 节点类型
     * 1 任务节点  2 条件节点  3 回调节点
     */
    private Integer nodeType;

    private String nodeInfo;

    private Integer failStrategy;

    private Integer priorityLevel;

    private Integer workflowNodeStatus;

    private Integer version;

    private String extAttrs;

    private Integer deleted;
}
