package com.lw.dcsjob.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lw
 * @create 2024-10-29-20:39
 */
@AllArgsConstructor
@Getter
public enum JobArgsTypeEnum {

    TEXT(1, "文本"),
    JSON(2, "JSON")
    ;

    private final Integer argsType;
    private final String desc;
}
