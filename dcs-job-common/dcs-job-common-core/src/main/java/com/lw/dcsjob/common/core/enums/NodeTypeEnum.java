package com.lw.dcsjob.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lw
 * @create 2024-10-29-20:49
 */
@AllArgsConstructor
@Getter
public enum NodeTypeEnum {

    /**
     * 客户端
     */
    CLIENT(1),
    /**
     * 服务端
     */
    SERVER(2)
    ;
    private final Integer type;
}
