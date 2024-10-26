package com.lw.dcsjob.template.datasource.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lw.dcsjob.template.datasource.persistence.po.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:06
 */
@Mapper
public interface JobMapper extends BaseMapper<Job> {

    int updateBatchNextTriggerAtById(@Param("list") List<Job> list);
}
