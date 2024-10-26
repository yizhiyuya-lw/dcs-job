package com.lw.dcsjob.template.datasource.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.lw.dcsjob.template.datasource.persistence.dataobject.WorkflowBatchResponseDO;
import com.lw.dcsjob.template.datasource.persistence.po.JobTaskBatch;
import com.lw.dcsjob.template.datasource.persistence.po.WorkflowTaskBatch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:59
 */
@Mapper
public interface WorkflowTaskBatchMapper extends BaseMapper<WorkflowTaskBatch> {

    List<WorkflowBatchResponseDO> selectWorkflowBatchPageList(PageDTO<JobTaskBatch> pageDTO, @Param("ew") Wrapper<WorkflowTaskBatch> wrapper);

    List<WorkflowBatchResponseDO> selectWorkflowBatchList(@Param("ew") Wrapper<WorkflowTaskBatch> wrapper);
}
