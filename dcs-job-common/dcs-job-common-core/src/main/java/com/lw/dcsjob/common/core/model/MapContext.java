package com.lw.dcsjob.common.core.model;

import lombok.Data;

import java.util.List;

/**
 * @author lw
 * @create 2024-10-29-21:17
 */
@Data
public class MapContext {

    /**
     * Map集合列表
     */
    private List<Object> taskList;

    private String taskName;

    private Long jobId;

    private Long taskBatchId;

    private Long taskId;
}
