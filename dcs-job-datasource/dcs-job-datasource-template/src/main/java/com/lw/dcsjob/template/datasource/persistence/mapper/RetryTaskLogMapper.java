package com.lw.dcsjob.template.datasource.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lw.dcsjob.template.datasource.persistence.dataobject.DashboardRetryResponseDO;
import com.lw.dcsjob.template.datasource.persistence.po.RetryTaskLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:53
 */
@Mapper
public interface RetryTaskLogMapper extends BaseMapper<RetryTaskLog> {

    int insertBatch(@Param("list") List<RetryTaskLog> list);

    List<DashboardRetryResponseDO> selectRetryRetryTaskLogSummaryList(@Param("ew") Wrapper<RetryTaskLog> wrapper);
}
