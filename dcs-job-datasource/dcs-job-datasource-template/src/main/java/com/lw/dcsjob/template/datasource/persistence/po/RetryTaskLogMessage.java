package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lw
 * @create 2024-09-25-22:21
 */
@Data
@TableName("retry_task_log_message")
public class RetryTaskLogMessage extends CreateDt {

    /**
     * 主键
     */
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
     * 同组下id唯一
     */
    private String uniqueId;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 日志数量
     */
    private Integer logNum;

    /**
     * 真实上报时间
     */
    private Long realTime;
}
