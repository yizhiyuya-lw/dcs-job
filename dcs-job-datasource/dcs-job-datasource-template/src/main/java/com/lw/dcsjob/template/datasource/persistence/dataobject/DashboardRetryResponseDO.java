package com.lw.dcsjob.template.datasource.persistence.dataobject;

import lombok.Data;

/**
 * @author lw
 * @create 2024-09-26-20:19
 */
@Data
public class DashboardRetryResponseDO {

    private String namespaceId;

    private String groupName;

    private String sceneName;

    private Integer runningNum;

    private Integer finishNum;

    private Integer maxCountNum;

    private Integer suspendNum;
}
