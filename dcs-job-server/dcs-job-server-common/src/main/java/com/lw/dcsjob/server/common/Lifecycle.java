package com.lw.dcsjob.server.common;

/**
 * 组件生命周期
 * @author lw
 * @create 2025-03-04-21:14
 */
public interface Lifecycle {

    /**
     * 启动组件
     */
    void start();

    /**
     * 关闭组件
     */
    void close();
}
