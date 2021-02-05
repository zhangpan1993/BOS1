package com.zhangpan.bos.web.action;

import com.zhangpan.bos.domain.Role;
import com.zhangpan.bos.service.IRoleService;
import com.zhangpan.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class RoleAction extends BaseAction<Role> {

    @Autowired
    private IRoleService roleService;


    public void jsonlist() throws IOException {

        List<Role> list = roleService.findAll();
        responseJson(list,new String[]{"users","functions"});
    }


    public String add(){

        roleService.save(getModel());
        return SUCCESS;
    }
}
