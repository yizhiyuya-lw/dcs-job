package com.lw.dcsjob.template.datasource.persistence.dataobject;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author lw
 * @create 2024-09-26-20:11
 */
@Data
public class DashboardCardResponseDO {

    private JobTask jobTask;

    private RetryTask retryTask;

    @Data
    public static class JobTask {
        private Integer successNum;

        private Integer failNum;

        private Integer cancelNum;

        private Integer stopNum;

        private Integer totalNum;

        private BigDecimal successRate;
    }

    @Data
    public static class RetryTask {
        private Long totalNum;

        private Long runningNum;

        private Long finishNum;

        private Long maxCountNum;

        private Long suspendNum;

        private LocalDateTime triggerAt;
    }
}
