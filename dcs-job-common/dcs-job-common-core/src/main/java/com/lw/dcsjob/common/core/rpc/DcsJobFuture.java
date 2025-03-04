package com.lw.dcsjob.common.core.rpc;

import com.lw.dcsjob.common.core.model.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lw
 * @create 2024-10-29-21:19
 */
@AllArgsConstructor
@Getter
public class DcsJobFuture<R extends Result<Object>> extends CompletableFuture<R> {

    private final Long requestId;
    private final long timeout;
    private final TimeUnit unit;

    public static <R extends Result<Object>> DcsJobFuture<R> newFuture(Long requestId, long timeout, TimeUnit unit) {
        return new DcsJobFuture<>(requestId, timeout, unit);
    }
}
