package com.lw.dcsjob.server.model.dto;

import com.lw.dcsjob.common.core.constant.SystemConstants;
import lombok.Data;

import java.util.List;

/**
 * @author lw
 * @create 2024-09-26-21:31
 */
@Data
public class ConfigDTO {

    private List<Scene> sceneList;

    private List<Notify> notifyList;

    private Integer version;

    @Data
    public static class Scene {
        private String sceneName;

        private long ddl = SystemConstants.DEFAULT_DDL;
    }

    @Data
    public static class Notify {

        private List<Recipient> recipients;

        private Integer notifyThreshold;

        private Integer retryNotifyScene;

        private Integer jobNotifyScene;

        @Data
        public static class Recipient {

            private Integer notifyType;

            private String notifyAttribute;
        }
    }
}
