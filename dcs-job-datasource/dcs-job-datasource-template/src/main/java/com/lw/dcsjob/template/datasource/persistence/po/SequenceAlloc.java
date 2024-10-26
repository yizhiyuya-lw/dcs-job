package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lw
 * @create 2024-09-25-22:25
 */
@Data
@TableName("sequence_alloc")
public class SequenceAlloc extends CreateUpdateDt {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 组名称
     */
    private String groupName;

    /**
     * 命名空间ID
     */
    private String namespaceId;

    /**
     * 最大id
     */
    private Long maxId;

    /**
     * 步长
     */
    private Integer step;

}
