package com.lw.dcsjob.common.log;

import com.lw.dcsjob.common.log.strategy.Local;
import com.lw.dcsjob.common.log.strategy.Remote;

/**
 * @author lw
 * @create 2024-09-27-22:44
 */
public class DcsJobLog {

    private DcsJobLog() {}

    public static final Local LOCAL = new Local();

    public static final Remote REMOTE = new Remote();
}
