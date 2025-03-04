package com.lw.dcsjob.common.core.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 任务执行上下文
 * @author lw
 * @create 2024-10-29-21:11
 */
@Data
public class JobContext {

    private Long jobId;

    private Long taskBatchId;

    private Long workflowTaskBatchId;

    private Long workflowNodeId;

    private Long taskId;

    private String namespaceId;

    private String groupName;

    private String executorInfo;

    private Integer taskType;

    private Integer parallelNum;

    private Integer shardingTotal;

    private Integer shardingIndex;

    private Integer executorTimeout;

    /**
     * 重试场景 auto、manual
     */
    private Integer retryScene;

    /**
     * 是否重试流量
     */
    private boolean isRetry;

    /**
     * Map集合列表
     */
    private List<Object> taskList;

    /**
     * Map名称
     */
    private String taskName;

    /**
     * 动态分片所处的阶段
     */
    private Integer mrStage;

    /**
     * 工作流全局上下文
     */
    private Map<String, Object> wfContext;

    /**
     * 新增或者改动的上下文
     */
    private Map<String, Object> changeWfContext;

    /**
     * 定时任务参数
     */
    private JobArgsHolder jobArgsHolder;
}
