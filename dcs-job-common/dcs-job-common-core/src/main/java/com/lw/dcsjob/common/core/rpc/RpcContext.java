package com.lw.dcsjob.common.core.rpc;

import com.lw.dcsjob.common.core.enums.StatusEnum;
import com.lw.dcsjob.common.core.exception.DcsJobRemotingTimeOutException;
import com.lw.dcsjob.common.core.model.NettyResult;
import com.lw.dcsjob.common.core.model.Result;
import com.lw.dcsjob.common.log.DcsJobLog;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * @author lw
 * @create 2024-10-29-21:18
 */
@Slf4j
public class RpcContext {

    private RpcContext() {}

    private static final HashedWheelTimer WHEEL_TIMER;

    static {
        WHEEL_TIMER = new HashedWheelTimer(new CustomizableThreadFactory("dcs-job-rpc-tomeout-"), 1,
                TimeUnit.SECONDS, 1024);
    }

    private static final ConcurrentMap<Long, DcsJobFuture> COMPLETABLE_FUTURE = new ConcurrentHashMap<>();

    public static void invoke(Long requestId, NettyResult nettyResult, boolean timeout) {
        try {
            Optional.ofNullable(COMPLETABLE_FUTURE.remove(requestId))
                    .ifPresent(future -> {
                        if (timeout) {
                            future.completeExceptionally(new DcsJobRemotingTimeOutException("request to remote interface timed out."));
                        } else {
                            future.complete(nettyResult);
                        }
                    });
        } catch (Exception e) {
            DcsJobLog.LOCAL.error("回调处理失败 requestId:[{}]", requestId, e);
        }
    }

    public static <R extends Result<Object>> void setFuture(DcsJobFuture<R> future) {
        if (Objects.nonNull(future)) {
            COMPLETABLE_FUTURE.put(future.getRequestId(), future);
        }

        //放入时间轮
        WHEEL_TIMER.newTimeout(new TimeoutCheckTask(future.getRequestId()), future.getTimeout(), future.getUnit());
    }

    public static class TimeoutCheckTask implements TimerTask {
        private final Long requestId;

        public TimeoutCheckTask(Long requestId) {
            this.requestId = requestId;
        }

        @Override
        public void run(Timeout timeout) throws Exception {
            invoke(requestId, new NettyResult(StatusEnum.NO.getStatus(), "request to remote interfact timed out.", null, requestId), true);
        }
    }
}
