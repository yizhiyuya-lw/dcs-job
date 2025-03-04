package com.lw.dcsjob.common.core.model;

import lombok.Data;

/**
 * 定时任务 job_task 的 args_str对应的参数模型
 * @author lw
 * @create 2024-10-29-20:57
 */
@Data
public class JobArgsHolder {

    /**
     * job表输入的参数
     */
    private Object jobParams;

    /**
     * 动态分片 map节点的结果
     */
    private Object maps;

    /**
     * 动态分片reduce执行的结果
     */
    private Object reduces;
}
