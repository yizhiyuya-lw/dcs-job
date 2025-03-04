package com.lw.dcsjob.common.core.model;

import com.lw.dcsjob.common.core.util.JsonUtils;
import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lw
 * @create 2024-10-29-21:01
 */
@Data
public class DcsJobRequest {

    private static final AtomicLong REQUEST_ID = new AtomicLong(0);

    private long reqId;

    private Object[] args;

    public DcsJobRequest() {
    }

    public DcsJobRequest(Object... args) {
        this.args = args;
        this.reqId = newId();
    }

    private static long newId() {
        return REQUEST_ID.getAndIncrement();
    }

    @Override
    public String toString() {
        return JsonUtils.toJsonString(this);
    }
}
