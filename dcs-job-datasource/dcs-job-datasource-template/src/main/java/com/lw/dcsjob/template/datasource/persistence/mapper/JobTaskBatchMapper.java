package com.lw.dcsjob.template.datasource.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lw.dcsjob.template.datasource.persistence.dataobject.JobBatchResponseDO;
import com.lw.dcsjob.template.datasource.persistence.dataobject.JobBatchSummaryResponseDO;
import com.lw.dcsjob.template.datasource.persistence.po.JobTaskBatch;
import com.lw.dcsjob.template.datasource.persistence.po.WorkflowTaskBatch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:41
 */
@Mapper
public interface JobTaskBatchMapper extends BaseMapper<JobTaskBatch> {

    List<JobBatchResponseDO> selectJobBatchPageList(IPage<JobTaskBatch> iPage, @Param("ew") Wrapper<JobTaskBatch> wrapper);

    List<JobBatchResponseDO> selectJobBatchListByIds(@Param("ew") Wrapper<JobTaskBatch> wrapper);

    List<JobBatchSummaryResponseDO> selectJobBatchSummaryList(@Param("ew") Wrapper<JobTaskBatch> wrapper);

    List<JobBatchSummaryResponseDO> selectWorkflowTaskBatchSummaryList(@Param("ew") Wrapper<WorkflowTaskBatch> wrapper);
}
