package com.lw.dcsjob.template.datasource.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lw.dcsjob.template.datasource.persistence.dataobject.DashboardCardResponseDO;
import com.lw.dcsjob.template.datasource.persistence.dataobject.DashboardLineResponseDO;
import com.lw.dcsjob.template.datasource.persistence.dataobject.DashboardRetryLineResponseDO.Rank;
import com.lw.dcsjob.template.datasource.persistence.dataobject.DashboardRetryLineResponseDO.Task;
import com.lw.dcsjob.template.datasource.persistence.po.Job;
import com.lw.dcsjob.template.datasource.persistence.po.JobSummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:07
 */
@Mapper
public interface JobSummaryMapper extends BaseMapper<JobSummary> {

    int insertBatch(@Param("list") List<JobSummary> list);

    int updateBatch(@Param("list") List<JobSummary> list);

    IPage<Task> selectJobTaskList(@Param("ew") Wrapper<Job> wrapper, Page<Object> page);

    long selectJobTaskListCount(@Param("ew") Wrapper<Job> wrapper);

    IPage<Task> selectWorkflowTaskList(@Param("ew") Wrapper<Job> wrapper, Page<Object> page);

    long selectWorkflowTaskListCount(@Param("ew") Wrapper<Job> wrapper);

    List<DashboardLineResponseDO> selectJobLineList(@Param("dateFormat") String dateFormat, @Param("ew") Wrapper<JobSummary> wrapper);

    List<Rank> selectDashboardRankList(@Param("systemTaskType") Integer systemTaskType, @Param("ew") Wrapper<JobSummary> wrapper);

    DashboardCardResponseDO.JobTask selectJobTask(@Param("ew") Wrapper<JobSummary> wrapper);
}
