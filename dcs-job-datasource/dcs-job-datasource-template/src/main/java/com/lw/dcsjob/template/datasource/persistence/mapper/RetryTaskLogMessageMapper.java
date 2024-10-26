package com.lw.dcsjob.template.datasource.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lw.dcsjob.template.datasource.persistence.po.RetryTaskLogMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:53
 */
@Mapper
public interface RetryTaskLogMessageMapper extends BaseMapper<RetryTaskLogMessage> {

    int insertBatch(@Param("list") List<RetryTaskLogMessage> list);

    int updateBatch(@Param("list") List<RetryTaskLogMessage> list);
}
