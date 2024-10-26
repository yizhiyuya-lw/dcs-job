package com.lw.dcsjob.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lw
 * @create 2024-09-26-22:04
 */
@AllArgsConstructor
@Getter
public enum StatusEnum {

    NO(0),
    YES(1);

    private final Integer status;
}
