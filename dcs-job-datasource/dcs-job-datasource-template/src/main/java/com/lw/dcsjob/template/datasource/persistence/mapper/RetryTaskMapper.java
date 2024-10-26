package com.lw.dcsjob.template.datasource.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lw.dcsjob.template.datasource.persistence.po.RetryTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:54
 */
@Mapper
public interface RetryTaskMapper extends BaseMapper<RetryTask> {

    int insertBatch(@Param("list") List<RetryTask> list);

    int updateBatchNextTriggerAtById(@Param("partition") Integer partition, @Param("list") List<RetryTask> list);
}
