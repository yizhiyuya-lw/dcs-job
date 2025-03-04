package com.lw.dcsjob.server.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lw
 * @create 2024-10-29-21:49
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RetryLogTaskDTO extends LogTaskDTO {

    private String uniqueId;

    private String clientInfo;
}
