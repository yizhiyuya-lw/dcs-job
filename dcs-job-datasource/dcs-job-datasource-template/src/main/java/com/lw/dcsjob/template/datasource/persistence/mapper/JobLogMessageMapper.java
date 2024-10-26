package com.lw.dcsjob.template.datasource.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lw.dcsjob.template.datasource.persistence.po.JobLogMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:05
 */
@Mapper
public interface JobLogMessageMapper extends BaseMapper<JobLogMessage> {

    int insertBatch(@Param("list") List<JobLogMessage> list);
}
