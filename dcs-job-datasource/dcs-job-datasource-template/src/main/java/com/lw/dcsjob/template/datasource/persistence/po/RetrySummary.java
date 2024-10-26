package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * @author lw
 * @create 2024-09-25-22:14
 */
@Data
@TableName("retry_summary")
public class RetrySummary extends CreateUpdateDt {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String namespaceId;

    private String groupName;

    private LocalDateTime triggerAt;

    private String sceneName;

    private Integer runningNum;

    private Integer finishNum;

    private Integer maxCountNum;

    private Integer suspendNum;
}
