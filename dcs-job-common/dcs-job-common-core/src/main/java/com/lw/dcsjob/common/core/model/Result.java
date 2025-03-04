package com.lw.dcsjob.common.core.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author lw
 * @create 2024-10-29-20:52
 */
@Data
@Accessors(chain = true)
public class Result<T> {

    protected int status = 1;

    protected String message;

    protected T data;

    public Result() {}

    public Result(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
