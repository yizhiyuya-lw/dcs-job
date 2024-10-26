package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lw
 * @create 2024-09-25-21:50
 */
@Data
@TableName("job_summary")
public class JobSummary extends CreateUpdateDt {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String namespaceId;

    private String groupName;

    /**
     * 任务信息id
     */
    private Long businessId;

    /**
     * 统计时间
     */
    private LocalDateTime triggerAt;

    private Integer successNum;

    private Integer failNum;

    private String failReason;

    private Integer stopNum;

    private String stopReason;

    private Integer cancelNum;

    private String cancelReason;

    /**
     * 任务类型 JOB任务  workflow任务
     */
    private Integer systemTaskType;

}
