package com.lw.dcsjob.template.datasource.persistence.dataobject;

import lombok.Data;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:16
 */
@Data
public class DashboardRetryLineResponseDO {

    private List<Task> taskList;

    private List<Rank> rankList;

    private List<DashboardLineResponseDO> dashboardLineResponseDOList;

    @Data
    public static class Task {
        private String groupName;

        private Integer run;

        private Integer total;
    }

    @Data
    public static class Rank {
        private String name;

        private String total;
    }
}
