package com.lw.dcsjob.template.datasource.access.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.lw.dcsjob.template.datasource.enums.DbTypeEnum;
import com.lw.dcsjob.template.datasource.enums.OperationTypeEnum;
import com.lw.dcsjob.template.datasource.persistence.po.GroupConfig;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-22:18
 */
@Component
public class GroupConfigAccess extends AbstractConfigAccess<GroupConfig> {

    @Override
    public boolean supports(String operationType) {
        DbTypeEnum dbType = getDbType();
        return OperationTypeEnum.GROUP.name().equals(operationType)
                && ALLOW_DB.contains(dbType.getDb());
    }

    @Override
    public List<GroupConfig> list(LambdaQueryWrapper<GroupConfig> query) {
        return groupConfigMapper.selectList(query);
    }

    @Override
    public int update(GroupConfig groupConfig, LambdaUpdateWrapper<GroupConfig> query) {
        return groupConfigMapper.update(groupConfig, query);
    }

    @Override
    public int updateById(GroupConfig groupConfig) {
        return groupConfigMapper.updateById(groupConfig);
    }

    @Override
    public int delete(LambdaQueryWrapper<GroupConfig> query) {
        return groupConfigMapper.delete(query);
    }

    @Override
    public int insert(GroupConfig groupConfig) {
        return groupConfigMapper.insert(groupConfig);
    }

    @Override
    public GroupConfig one(LambdaQueryWrapper<GroupConfig> query) {
        return groupConfigMapper.selectOne(query);
    }

    @Override
    public PageDTO<GroupConfig> listPage(PageDTO<GroupConfig> iPage, LambdaQueryWrapper<GroupConfig> query) {
        return groupConfigMapper.selectPage(iPage, query);
    }

    @Override
    public long count(LambdaQueryWrapper<GroupConfig> query) {
        return groupConfigMapper.selectCount(query);
    }

}
