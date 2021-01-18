package com.zhangpan.bos.service;

import com.zhangpan.bos.domain.User;
import com.zhangpan.bos.service.base.IBaseService;

public interface IUserService extends IBaseService<User> {

    public User findByTel(String tel);

    public User login(String username, String password);

    public Integer modifyPassword(String userId, String newPwd);
}
