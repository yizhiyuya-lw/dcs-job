package com.lw.dcsjob.common.core.exception;

import lombok.Data;

/**
 * @author lw
 * @create 2025-03-05-20:40
 */
@Data
public abstract class AbstractError {

    public static final AbstractError SUCCESS = new AbstractError("操作成功", "success") {};

    public static final AbstractError ERROR = new AbstractError("操作失败", "error") {};

    public static final AbstractError PARAM_INCORRECT = new AbstractError("参数异常", "param incorrect") {};

    private final String zhMsg;

    private final String enMsg;

    protected AbstractError(String zhMsg, String enMsg) {
        this.zhMsg = zhMsg;
        this.enMsg = enMsg;
    }

    public static String getMsg(AbstractError abstractError) {
        return abstractError.zhMsg;
    }

    @Override
    public String toString() {
        return this.zhMsg;
    }
}
