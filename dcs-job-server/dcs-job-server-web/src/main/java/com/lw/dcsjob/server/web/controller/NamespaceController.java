package com.lw.dcsjob.server.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lw.dcsjob.server.web.annotation.LoginRequired;
import com.lw.dcsjob.template.datasource.persistence.mapper.NamespaceMapper;
import com.lw.dcsjob.template.datasource.persistence.po.Namespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lw
 * @create 2024-09-25-22:39
 */
@RestController
@RequestMapping("/namespace")
public class NamespaceController {

    @Autowired
    private NamespaceMapper namespaceMapper;

    @RequestMapping("/add")
    public Namespace save() {
        Namespace namespace = new Namespace();
        namespace.setName("ceshi");
        namespace.setUniqueId("dasfasdfasfasfa");
        int insert = namespaceMapper.insert(namespace);
        return namespace;
    }

    @RequestMapping("/getAll")
    @LoginRequired
    public Object getAll() {
        return namespaceMapper.selectList(new LambdaQueryWrapper<Namespace>().eq(Namespace::getDeleted, 0));
    }
}
