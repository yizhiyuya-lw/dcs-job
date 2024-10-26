package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lw
 * @create 2024-09-25-22:03
 */
@Data
@TableName("notify_config")
public class NotifyConfig extends CreateUpdateDt {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String namespaceId;

    private String groupName;

    /**
     * 业务id  scene_name 或者jobid或者workflowid
     */
    private String businessId;

    /**
     * 任务类型
     */
    private Integer systemTaskType;

    private Integer notifyStatus;

    private String recipientIds;

    private Integer notifyThreshold;

    private Integer notifyScene;

    private Integer rateLimiterStatus;

    private Integer rateLimiterThreshold;

    private String description;
}
