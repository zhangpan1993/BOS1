package com.zhangpan.bos.service;

import com.zhangpan.bos.domain.Role;
import com.zhangpan.bos.service.base.IBaseService;

import java.util.List;

public interface IRoleService extends IBaseService<Role> {


    @Override
    public List<Role> findAll();
}
