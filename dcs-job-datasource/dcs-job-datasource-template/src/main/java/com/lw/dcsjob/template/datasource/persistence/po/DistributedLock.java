package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lw
 * @create 2024-09-25-21:32
 */
@Data
@TableName("distributed_lock")
public class DistributedLock extends CreateUpdateDt {

    /**
     * 锁名称
     */
    @TableId(value = "name")
    private String name;

    /**
     * 锁定时长
     */
    private LocalDateTime lockUntil;

    /**
     * 锁定时间
     */
    private LocalDateTime lockedAt;

    /**
     * 锁定者
     */
    private String lockedBy;
}
