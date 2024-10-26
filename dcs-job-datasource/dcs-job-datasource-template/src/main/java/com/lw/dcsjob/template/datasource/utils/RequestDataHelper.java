package com.lw.dcsjob.template.datasource.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lw.dcsjob.common.core.context.DcsJobSpringContext;
import com.lw.dcsjob.template.datasource.exception.DcsJobDatasourceException;
import com.lw.dcsjob.template.datasource.persistence.mapper.GroupConfigMapper;
import com.lw.dcsjob.template.datasource.persistence.po.GroupConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * 组分区处理类
 * @author lw
 * @create 2024-09-24-22:41
 */
public class RequestDataHelper {

    private static final ThreadLocal<Map<String, Object>> REQUEST_DATA = new ThreadLocal<>();
    private static final String PARTITION = "group-partition";

    public static void setRequestData(Map<String, Object> requestData) {
        REQUEST_DATA.set(requestData);
    }

    /**
     * 设置分区
     * @param partition
     */
    public static void setPartition(int partition) {
        Map<String, Object> map = new HashMap<>();
        map.put(PARTITION, partition);
        RequestDataHelper.setRequestData(map);
    }

    public static void setPartition(String groupName, String namespaceId) {
        if (StrUtil.isBlank(groupName) && StrUtil.isNotBlank(namespaceId)) {
            throw new DcsJobDatasourceException("组名称不能为空");
        }
        GroupConfigMapper groupConfigMapper = DcsJobSpringContext.getBeanByType(GroupConfigMapper.class);
        GroupConfig groupConfig = groupConfigMapper.selectOne(
                new LambdaQueryWrapper<GroupConfig>()
                        .select(GroupConfig::getGroupPartition)
                        .eq(GroupConfig::getNamespaceId, namespaceId)
                        .eq(GroupConfig::getGroupName, groupName));
        if (ObjectUtil.isNull(groupConfig)) {
            throw new DcsJobDatasourceException("groupName: [{}]不存在", groupName);
        }
        setPartition(groupConfig.getGroupPartition());
    }

    public static <T> T getRequestData(String param) {
        Map<String, Object> requestData = getRequestData();
        if (CollUtil.isEmpty(requestData)) {
            return null;
        }
        return (T) requestData.get(param);
    }

    public static Map<String, Object> getRequestData() {
        return REQUEST_DATA.get();
    }

    public static Integer getPartition() {
        Map<String, Object> requestData = getRequestData();
        if (CollUtil.isEmpty(requestData)) {
            return null;
        }
        return (Integer) requestData.get(PARTITION);
    }

    public static void remove() {
        REQUEST_DATA.remove();
    }
}
