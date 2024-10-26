package com.lw.dcsjob.template.datasource.persistence.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lw.dcsjob.template.datasource.persistence.dataobject.ActivePodQuantityResponseDO;
import com.lw.dcsjob.template.datasource.persistence.po.ServerNode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-20:56
 */
@Mapper
public interface ServerNodeMapper extends BaseMapper<ServerNode> {

    int insertBatch(@Param("list") List<ServerNode> list);

    int updateBatchExpireAt(@Param("list") List<ServerNode> list);

    List<ActivePodQuantityResponseDO> selectActivePodCount(@Param("ew") Wrapper<ServerNode> wrapper);
}
