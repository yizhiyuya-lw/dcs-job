package com.lw.dcsjob.template.datasource.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lw.dcsjob.template.datasource.persistence.po.RetryDeadLetter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:51
 */
@Mapper
public interface RetryDeadLetterMapper extends BaseMapper<RetryDeadLetter> {

    int insertBatch(@Param("list") List<RetryDeadLetter> list);
}
