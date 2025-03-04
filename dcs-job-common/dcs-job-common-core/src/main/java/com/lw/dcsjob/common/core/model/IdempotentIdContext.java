package com.lw.dcsjob.common.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 幂等id上下文
 * @author lw
 * @create 2024-10-29-20:55
 */
@Data
@AllArgsConstructor
public class IdempotentIdContext {

    /**
     * 场景名称
     */
    private String scene;

    /**
     * 执行器名称
     */
    private String targetClassName;

    /**
     * 参数列表
     */
    private Object[] args;

    /**
     * 执行的方法名称
     */
    private String methodName;
}
