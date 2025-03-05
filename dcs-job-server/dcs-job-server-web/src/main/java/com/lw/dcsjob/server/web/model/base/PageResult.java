package com.lw.dcsjob.server.web.model.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.lw.dcsjob.common.core.model.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lw
 * @create 2025-03-04-21:29
 */
@Data
@AllArgsConstructor
public class PageResult<T> extends Result<T> {

    private long page;
    private long size;
    private long total;

    public PageResult() {
        super();
    }

    public PageResult(int status, String message, T data) {
        super(status, message, data);
    }

    public PageResult(PageDTO pageDTO, T data) {
        page = pageDTO.getCurrent();
        size = pageDTO.getSize();
        total = pageDTO.getTotal();
        super.setData(data);
    }
}
