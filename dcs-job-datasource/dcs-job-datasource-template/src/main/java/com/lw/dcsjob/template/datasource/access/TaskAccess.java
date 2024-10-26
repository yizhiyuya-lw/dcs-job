package com.lw.dcsjob.template.datasource.access;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;

import java.util.List;

/**
 * 获取重试数据通道
 * @author lw
 * @create 2024-09-26-21:19
 */
public interface TaskAccess<T> extends Access<T> {

    List<T> list(String groupName, String namespaceId, LambdaQueryWrapper<T> query);

    T one(String groupName, String namespaceId, LambdaQueryWrapper<T> query);

    int update(String groupName, String namespaceId, T t, LambdaUpdateWrapper<T> query);

    int updateById(String groupName, String namespaceId, T t);

    int delete(String groupName, String namespaceId, LambdaQueryWrapper<T> query);

    int insert(String groupName, String namespaceId, T t);

    int insertBatch(String groupName, String namespaceId, List<T> list);

    PageDTO<T> listPage(String groupName, String namespaceId, PageDTO<T> iPage, LambdaQueryWrapper<T> query);

    long count(String groupName, String namespaceId, LambdaQueryWrapper<T> query);
}
