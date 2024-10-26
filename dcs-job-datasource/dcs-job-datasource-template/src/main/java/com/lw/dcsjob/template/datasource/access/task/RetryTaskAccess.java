package com.lw.dcsjob.template.datasource.access.task;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.lw.dcsjob.template.datasource.enums.DbTypeEnum;
import com.lw.dcsjob.template.datasource.enums.OperationTypeEnum;
import com.lw.dcsjob.template.datasource.persistence.mapper.RetryTaskMapper;
import com.lw.dcsjob.template.datasource.persistence.po.RetryTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-21:48
 */
@Component
public class RetryTaskAccess extends AbstractTaskAccess<RetryTask> {

    @Autowired
    private RetryTaskMapper retryTaskMapper;

    @Override
    public boolean supports(String operationType) {
        DbTypeEnum dbType = getDbType();
        return OperationTypeEnum.RETRY_TASK.name().equals(operationType)
                && ALLOW_DB.contains(dbType.getDb());
    }

    @Override
    protected int doUpdate(RetryTask retryTask, LambdaUpdateWrapper<RetryTask> query) {
        return retryTaskMapper.update(retryTask, query);
    }

    @Override
    protected int doInsertBatch(List<RetryTask> list) {
        return retryTaskMapper.insertBatch(list);
    }

    @Override
    protected RetryTask doOne(LambdaQueryWrapper<RetryTask> query) {
        return retryTaskMapper.selectOne(query);
    }

    @Override
    protected PageDTO<RetryTask> doListPage(PageDTO<RetryTask> iPage, LambdaQueryWrapper<RetryTask> query) {
        return retryTaskMapper.selectPage(iPage, query);
    }

    @Override
    protected long doCount(LambdaQueryWrapper<RetryTask> query) {
        return retryTaskMapper.selectCount(query);
    }

    @Override
    protected int doInsert(RetryTask retryTask) {
        return retryTaskMapper.insert(retryTask);
    }

    @Override
    protected int doDelete(LambdaQueryWrapper<RetryTask> query) {
        return retryTaskMapper.delete(query);
    }

    @Override
    protected int doUpdateById(RetryTask retryTask) {
        return retryTaskMapper.updateById(retryTask);
    }

    @Override
    protected List<RetryTask> doList(LambdaQueryWrapper<RetryTask> query) {
        return retryTaskMapper.selectList(query);
    }
}
