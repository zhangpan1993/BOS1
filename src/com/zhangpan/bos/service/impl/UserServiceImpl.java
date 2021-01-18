package com.zhangpan.bos.service.impl;

import com.zhangpan.bos.dao.IUserDao;
import com.zhangpan.bos.domain.User;
import com.zhangpan.bos.service.IUserService;
import com.zhangpan.bos.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Autowired
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public User find(Serializable id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByTel(String tel) {
        return null;
    }

    @Override
    public User login(String username, String password) {

        return userDao.find(username,password);
    }

    @Override
    public Integer modifyPassword(String userId, String newPwd) {

        return userDao.ModifyPassword(userId,newPwd);
    }
}
