package com.lw.dcsjob.template.datasource.persistence.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lw
 * @create 2024-09-24-22:36
 */
@Data
public class CreateUpdateDt extends CreateDt {

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDt;
}
