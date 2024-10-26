package com.lw.dcsjob.template.datasource.enums;

import com.baomidou.mybatisplus.annotation.DbType;
import com.lw.dcsjob.template.datasource.exception.DcsJobDatasourceException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lw
 * @create 2024-09-24-21:30
 */
@AllArgsConstructor
@Getter
public enum DbTypeEnum {

    MYSQL("mysql", "MySql数据库", DbType.MYSQL);

    private final String db;
    private final String desc;
    private final DbType mpDbType;

    public static DbTypeEnum modeOf(String db) {
        for (DbTypeEnum value : DbTypeEnum.values()) {
            if (db.contains(value.getDb())) {
                return value;
            }
        }
        throw new DcsJobDatasourceException("暂不支持此数据库 [{}]", db);
    }
}
