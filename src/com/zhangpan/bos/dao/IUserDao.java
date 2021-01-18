package com.zhangpan.bos.dao;

import com.zhangpan.bos.dao.base.IBaseDao;
import com.zhangpan.bos.domain.User;

public interface IUserDao extends IBaseDao<User> {

    public User findByEmail(String email);

    public User find(String name, String password);

    public Integer ModifyPassword(String id, String password);

}
