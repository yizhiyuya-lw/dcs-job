package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lw
 * @create 2024-09-25-21:53
 */
@Data
@TableName("job_task")
public class JobTask extends CreateUpdateDt {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String namespaceId;

    private String groupName;

    private String taskName;

    private Long jobId;

    private Long taskBatchId;

    private Long parentId;

    private Integer taskStatus;

    /**
     * 重试次数
     */
    @TableField(value = "retry_count", update = "%s+1")
    private Integer retryCount;

    private String resultMessage;

    private String clientInfo;

    /**
     * 执行方法参数
     */
    private String argsStr;

    /**
     * 参数类型  text、json
     */
    private Integer argsType;

    /**
     * 叶子节点
     */
    private Integer leaf;

    /**
     * 动态分片使用
     * 1 map  2 reduce  3 mergeReduce
     */
    private Integer mrStage;

    /**
     * 冗余工作流上下文
     */
    private String wfContext;

    /**
     * 扩展字段
     */
    private String extAttrs;
}
