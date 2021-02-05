package com.zhangpan.bos.service.impl;

import com.zhangpan.bos.dao.IRoleDao;
import com.zhangpan.bos.domain.Role;
import com.zhangpan.bos.service.IRoleService;
import com.zhangpan.bos.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() {

        return roleDao.findall();
    }

    @Override
    public void save(Role entity) {

        roleDao.save(entity);
    }
}
