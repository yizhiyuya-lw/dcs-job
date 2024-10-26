package com.lw.dcsjob.template.datasource.handler;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.lw.dcsjob.template.datasource.persistence.mapper.*;
import org.apache.ibatis.mapping.MappedStatement;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lw
 * @create 2024-09-24-22:01
 */
public class DcsJobMybatisConfiguration extends MybatisConfiguration {

    /**
     * 重复的ID不需要告警 配置列表
     * 此设计为了多数据源不同数据库包下面加载xml有重复的mybatis id 会告警报错
     */
    private static final Set<String> DUPLICATE_IDS = new HashSet<>();

    private static final String BATCH_INSERT_ID = "insertBatch";

    static {
        DUPLICATE_IDS.add(RetryDeadLetterMapper.class.getName() + "." + BATCH_INSERT_ID);
        DUPLICATE_IDS.add(ServerNodeMapper.class.getName() + "." + BATCH_INSERT_ID);
        DUPLICATE_IDS.add(JobTaskMapper.class.getName() + "." + BATCH_INSERT_ID);
        DUPLICATE_IDS.add(JobSummaryMapper.class.getName() + "." + BATCH_INSERT_ID);
        DUPLICATE_IDS.add(RetryTaskLogMapper.class.getName() + "." + BATCH_INSERT_ID);
        DUPLICATE_IDS.add(RetrySummaryMapper.class.getName() + "." + BATCH_INSERT_ID);
        DUPLICATE_IDS.add(RetryTaskLogMessageMapper.class.getName() + "." + BATCH_INSERT_ID);
        DUPLICATE_IDS.add(RetryTaskMapper.class.getName() + "." + BATCH_INSERT_ID);
        DUPLICATE_IDS.add(JobLogMessageMapper.class.getName() + "." + BATCH_INSERT_ID);
    }

    @Override
    public void addMappedStatement(MappedStatement ms) {
        if (mappedStatements.containsKey(ms.getId())) {
            if (!DUPLICATE_IDS.contains(ms.getId())) {
                super.addMappedStatement(ms);
            }
        } else {
            super.addMappedStatement(ms);
        }
    }
}
