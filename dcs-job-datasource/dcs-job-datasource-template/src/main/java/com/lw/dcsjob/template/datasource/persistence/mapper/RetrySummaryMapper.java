package com.lw.dcsjob.template.datasource.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lw.dcsjob.template.datasource.persistence.dataobject.DashboardCardResponseDO;
import com.lw.dcsjob.template.datasource.persistence.dataobject.DashboardLineResponseDO;
import com.lw.dcsjob.template.datasource.persistence.dataobject.DashboardRetryLineResponseDO;
import com.lw.dcsjob.template.datasource.persistence.po.RetrySceneConfig;
import com.lw.dcsjob.template.datasource.persistence.po.RetrySummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:52
 */
@Mapper
public interface RetrySummaryMapper extends BaseMapper<RetrySummary> {

    int insertBatch(@Param("list") List<RetrySummary> list);

    int updateBatch(@Param("list") List<RetrySummary> list);

    DashboardCardResponseDO.RetryTask selectRetryTask(@Param("ew") Wrapper<RetrySummary> wrapper);

    List<DashboardCardResponseDO.RetryTask> selectRetryTaskBarList(@Param("ew") Wrapper<RetrySummary> wrapper);

    IPage<DashboardRetryLineResponseDO.Task> selectRetryTaskList(@Param("ew") Wrapper<RetrySceneConfig> wrapper, Page<Object> page);

    long selectRetryTaskListCount(@Param("ew") Wrapper<RetrySceneConfig> wrapper);

    List<DashboardLineResponseDO> selectRetryLineList(@Param("dateFormat") String dateFormat, @Param("ew") Wrapper<RetrySummary> wrapper);

    List<DashboardRetryLineResponseDO.Rank> selectDashboardRankList(@Param("ew") Wrapper<RetrySummary> wrapper);
}
