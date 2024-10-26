package com.lw.dcsjob.template.datasource.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lw.dcsjob.template.datasource.persistence.po.Workflow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:58
 */
@Mapper
public interface WorkflowMapper extends BaseMapper<Workflow> {

    int updateBatchNextTriggerAtById(@Param("list") List<Workflow> list);
}
