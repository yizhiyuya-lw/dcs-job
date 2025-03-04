package com.lw.dcsjob.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lw
 * @create 2024-10-29-20:41
 */
@AllArgsConstructor
@Getter
public enum JobTaskStatusEnum {

    /**
     * 处理中
     */
    RUNNING(2),

    /**
     * 处理成功
     */
    SUCCESS(3),

    /**
     * 处理失败
     */
    FAIL(4),

    /**
     * 任务停止
     */
    STOP(5),

    /**
     * 取消
     */
    CANCEL(6),
    ;
    private final int status;

    public static final List<Integer> NOT_COMPLETE = Collections.singletonList(RUNNING.getStatus());

    public static final List<Integer> COMPLETED = Arrays.asList(SUCCESS.getStatus(), FAIL.getStatus(), STOP.getStatus());

    public static final List<Integer> NOT_SUCCESS = Arrays.asList(FAIL.getStatus(), STOP.status);
}
