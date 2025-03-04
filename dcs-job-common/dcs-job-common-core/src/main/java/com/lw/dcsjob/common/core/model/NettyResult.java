package com.lw.dcsjob.common.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author lw
 * @create 2024-10-29-21:08
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class NettyResult extends Result<Object> {

    private long reqId;

    public NettyResult(int status, String message, Object data, long reqId) {
        super(status, message, data);
        this.reqId = reqId;
    }

    public NettyResult() {}

    public NettyResult(Object data, long reqId) {
        super(data);
        this.reqId = reqId;
    }
}
