package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lw
 * @create 2024-09-25-22:07
 */
@Data
@TableName("notify_recipient")
public class NotifyRecipient extends CreateUpdateDt {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String namespaceId;

    private String recipientName;

    private Integer notifyType;

    private String notifyAttribute;

    private String description;
}
