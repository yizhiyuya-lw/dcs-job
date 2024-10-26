package com.lw.dcsjob.template.datasource.handler;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpStatus;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.lw.dcsjob.template.datasource.exception.DcsJobDatasourceException;
import com.lw.dcsjob.template.datasource.persistence.po.CreateDt;
import com.lw.dcsjob.template.datasource.persistence.po.CreateUpdateDt;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import java.time.LocalDateTime;

/**
 * @author lw
 * @create 2024-09-24-22:30
 */
@Slf4j
public class InjectionMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof CreateDt baseEntity) {
                LocalDateTime current = ObjectUtil.isNotNull(baseEntity.getCreateDt()) ?
                        baseEntity.getCreateDt() : LocalDateTime.now();
                baseEntity.setCreateDt(current);
            }
            if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof CreateUpdateDt baseEntity) {
                LocalDateTime current = ObjectUtil.isNotNull(baseEntity.getCreateDt()) ?
                        baseEntity.getCreateDt() : LocalDateTime.now();
                baseEntity.setUpdateDt(current);
            }
        } catch (Exception e) {
            throw new DcsJobDatasourceException("自动注入异常 => " + e.getMessage(), HttpStatus.HTTP_UNAUTHORIZED);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof CreateUpdateDt baseEntity) {
                LocalDateTime current = LocalDateTime.now();
                baseEntity.setUpdateDt(current);
            }
        } catch (Exception e) {
            throw new DcsJobDatasourceException("自动注入异常 => " + e.getMessage(), HttpStatus.HTTP_UNAUTHORIZED);
        }
    }
}
