package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 场景配置
 * @author lw
 * @create 2024-09-25-22:11
 */
@Data
@TableName("retry_scene_config")
public class RetrySceneConfig extends CreateUpdateDt {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String namespaceId;

    private String groupName;

    private String sceneName;

    private Integer sceneStatus;

    private Integer maxRetryCount;

    private Integer backOff;

    private String triggerInterval;

    private String description;

    private Long deadlineRequest;

    private Integer routeKey;

    private Integer executorTimeout;
}
