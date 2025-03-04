package com.lw.dcsjob.server.model.dto;

import com.lw.dcsjob.common.log.dto.TaskLogFieldDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 日志上报DTO
 * @author lw
 * @create 2024-10-29-21:41
 */
@Data
public class LogTaskDTO implements Serializable {

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 命名空间
     */
    private String namespaceId;

    /**
     * 组名称
     */
    private String groupName;

    /**
     * 任务信息id
     */
    @Deprecated
    private Long jobId;

    /**
     * 任务实例id
     */
    @Deprecated
    private Long taskBatchId;

    /**
     * 调度任务id
     */
    @Deprecated
    private Long taskId;

    /**
     * 上报时间
     */
    private Long realTime;

    /**
     * 日志模型集合
     */
    private List<TaskLogFieldDTO> fieldList;
}
