package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lw
 * @create 2024-09-25-21:44
 */
@Data
@TableName("job_log_message")
public class JobLogMessage extends CreateDt {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 命名空间
     */
    private String namespaceId;

    /**
     * 组名称
     */
    private String groupName;

    /**
     * 任务实例id
     */
    private Long jobId;

    /**
     * 调度任务id
     */
    private Long taskId;

    /**
     * 日志数量
     */
    private Integer logNum;

    /**
     * 调度信息
     */
    private String message;

    /**
     * 真实上报时间
     */
    private Long realTime;
}
