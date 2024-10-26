package com.lw.dcsjob.template.datasource.access;

/**
 * @author lw
 * @create 2024-09-25-21:26
 */
public interface Access<T> {

    boolean supports(String operationType);
}
