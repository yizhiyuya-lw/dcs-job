package com.lw.dcsjob.common.core.enums;

import com.lw.dcsjob.common.core.exception.DcsJobCommonException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lw
 * @create 2024-10-29-20:47
 */
@AllArgsConstructor
@Getter
public enum JobTaskTypeEnum {

    CLUSTER(1),
    BROADCAST(2),
    SHARDING(3),
    MAP(4),
    MAP_REDUCE(5)
    ;
    private final int type;

    public static JobTaskTypeEnum valueOf(int type) {
        for (JobTaskTypeEnum value : values()) {
            if (value.getType() == type) {
                return value;
            }
        }
        throw new DcsJobCommonException("未知类型");
    }
}
