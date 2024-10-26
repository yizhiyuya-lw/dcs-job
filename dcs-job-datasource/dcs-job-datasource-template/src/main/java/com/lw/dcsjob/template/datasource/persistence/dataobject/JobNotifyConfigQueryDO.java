package com.lw.dcsjob.template.datasource.persistence.dataobject;

import lombok.Data;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:26
 */
@Data
public class JobNotifyConfigQueryDO {

    private List<String> groupNames;

    private Long jobId;

    private String namespaceId;
}
