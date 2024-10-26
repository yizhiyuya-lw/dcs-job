package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lw
 * @create 2024-09-25-22:27
 */
@Data
@TableName("server_node")
public class ServerNode extends CreateUpdateDt {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String namespaceId;

    private String groupName;

    private String hostId;

    private String hostIp;

    private Integer hostPort;

    private LocalDateTime expireAt;

    private Integer nodeType;

    private String extAttrs;
}
