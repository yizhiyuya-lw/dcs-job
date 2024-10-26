package com.lw.dcsjob.common.log.dto;

import java.io.Serializable;

/**
 * @author lw
 * @create 2024-09-27-21:22
 */
public class TaskLogFieldDTO implements Serializable {

    private String name;

    private String value;

    public TaskLogFieldDTO() {
    }

    public TaskLogFieldDTO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
