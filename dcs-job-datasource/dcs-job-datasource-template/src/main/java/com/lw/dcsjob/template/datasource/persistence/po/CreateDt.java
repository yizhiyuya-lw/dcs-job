package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lw
 * @create 2024-09-24-22:32
 */
@Data
public class CreateDt implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDt;
}
