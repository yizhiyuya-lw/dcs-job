package com.lw.dcsjob.template.datasource.access;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.lw.dcsjob.server.model.dto.ConfigDTO;
import com.lw.dcsjob.template.datasource.persistence.po.GroupConfig;
import com.lw.dcsjob.template.datasource.persistence.po.NotifyConfig;
import com.lw.dcsjob.template.datasource.persistence.po.RetrySceneConfig;

import java.util.List;
import java.util.Set;

/**
 * 获取配置通道
 * @author lw
 * @create 2024-09-26-21:25
 */
public interface ConfigAccess<T> extends Access<T> {

    GroupConfig getGroupConfigByGroupName(String groupName, String namespaceId);

    RetrySceneConfig getSceneConfigByGroupNameAndSceneName(String groupName, String sceneName, String namespaceId);

    List<NotifyConfig> getNotifyListConfigByGroupName(String shardingGroupId, String namespaceId);

    List<RetrySceneConfig> getSceneConfigByGroupName(String groupName);

    Set<String> getBlackList(String groupName, String namespaceId);

    List<GroupConfig> getAllConfigGroupList(String namespaceId);

    List<RetrySceneConfig> getAllConfigSceneList();

    Integer getConfigVersion(String groupName, final String namespaceId);

    ConfigDTO getConfigInfo(String groupName, final String namespaceId);

    List<T> list(LambdaQueryWrapper<T> query);

    int update(T t, LambdaUpdateWrapper<T> query);

    int updateById(T t);

    int delete(LambdaQueryWrapper<T> query);

    int insert(T t);

    T one(LambdaQueryWrapper<T> query);

    PageDTO<T> listPage(PageDTO<T> iPage, LambdaQueryWrapper<T> query);

    long count(LambdaQueryWrapper<T> query);
}
