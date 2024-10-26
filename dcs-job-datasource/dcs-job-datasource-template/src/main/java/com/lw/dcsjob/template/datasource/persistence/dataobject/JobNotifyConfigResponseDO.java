package com.lw.dcsjob.template.datasource.persistence.dataobject;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lw
 * @create 2024-09-26-20:27
 */
@Data
public class JobNotifyConfigResponseDO {

    private Long id;

    private String namespaceId;

    private String groupName;

    private Long jobId;

    private String jobName;

    private Integer notifyStatus;

    private Integer notifyType;

    private String notifyAttribute;

    private Integer notifyThreshold;

    private Integer notifyScene;

    private Integer rateLimiterStatus;

    private Integer rateLimiterThreshold;

    private String description;

    private LocalDateTime createDt;

    private LocalDateTime updateDt;
}
