package com.lw.dcsjob.template.datasource.access.task;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.lw.dcsjob.template.datasource.access.TaskAccess;
import com.lw.dcsjob.template.datasource.enums.DbTypeEnum;
import com.lw.dcsjob.template.datasource.utils.DbUtils;
import com.lw.dcsjob.template.datasource.utils.RequestDataHelper;

import java.util.Arrays;
import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-21:40
 */
public abstract class AbstractTaskAccess<T> implements TaskAccess<T> {

    protected static final List<String> ALLOW_DB = Arrays.asList(DbTypeEnum.MYSQL.getDb());

    protected DbTypeEnum getDbType() {
        return DbUtils.getDbType();
    }

    /**
     * 设置分区
     * @param groupName
     * @param namespaceId
     */
    public void setPartition(String groupName, String namespaceId) {
        RequestDataHelper.setPartition(groupName, namespaceId);
    }

    @Override
    public List<T> list(String groupName, String namespaceId, LambdaQueryWrapper<T> query) {
        setPartition(groupName, namespaceId);
        return doList(query);
    }

    @Override
    public int update(String groupName, String namespaceId, T t, LambdaUpdateWrapper<T> query) {
        setPartition(groupName, namespaceId);
        return doUpdate(t, query);
    }

    protected abstract int doUpdate(T t, LambdaUpdateWrapper<T> query);

    @Override
    public int updateById(String groupName, String namespaceId, T t) {
        setPartition(groupName, namespaceId);
        return doUpdateById(t);
    }

    @Override
    public int delete(String groupName, String namespaceId, LambdaQueryWrapper<T> query) {
        setPartition(groupName, namespaceId);
        return doDelete(query);
    }

    @Override
    public int insert(String groupName, String namespaceId, T t) {
        setPartition(groupName, namespaceId);
        return doInsert(t);
    }

    @Override
    public int insertBatch(String groupName, String namespaceId, List<T> list) {
        setPartition(groupName, namespaceId);
        return doInsertBatch(list);
    }

    protected abstract int doInsertBatch(List<T> list);

    @Override
    public PageDTO<T> listPage(String groupName, String namespaceId, final PageDTO<T> iPage, final LambdaQueryWrapper<T> query) {
        setPartition(groupName, namespaceId);
        return doListPage(iPage, query);
    }

    @Override
    public T one(String groupName, String namespaceId, LambdaQueryWrapper<T> query) {
        setPartition(groupName, namespaceId);
        return doOne(query);
    }

    protected abstract T doOne(LambdaQueryWrapper<T> query);

    protected abstract PageDTO<T> doListPage(final PageDTO<T> iPage, final LambdaQueryWrapper<T> query);

    @Override
    public long count(String groupName, String namespaceId, final LambdaQueryWrapper<T> query) {
        setPartition(groupName, namespaceId);
        return doCount(query);
    }

    protected abstract long doCount(final LambdaQueryWrapper<T> query);

    protected abstract int doInsert(T t);

    protected abstract int doDelete(LambdaQueryWrapper<T> query);

    protected abstract int doUpdateById(T t);

    protected abstract List<T> doList(LambdaQueryWrapper<T> query);
}
