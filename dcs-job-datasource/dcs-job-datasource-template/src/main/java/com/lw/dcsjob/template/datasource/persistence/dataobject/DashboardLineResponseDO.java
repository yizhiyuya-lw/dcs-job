package com.lw.dcsjob.template.datasource.persistence.dataobject;

import lombok.Data;

/**
 * @author lw
 * @create 2024-09-26-20:15
 */
@Data
public class DashboardLineResponseDO {

    private String createDt;

    private Long total;

    private Long successNum;

    private Long runningNum;

    private Long maxCountNum;

    private Long suspendNum;

    private Long fail;

    private Long totalNum;

    private Long failNum;

    private Long stop;

    private Long cancel;

    private Long success;
}
