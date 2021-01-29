package com.zhangpan.bos.web.realm;

import com.zhangpan.bos.dao.IUserDao;
import com.zhangpan.bos.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class BOSRealm extends AuthorizingRealm {

    @Autowired
    private IUserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        User user = userDao.findByUsername(username);
        if (user == null){

            //用户不存在
        }else{

            String pwd = user.getPassword();
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,pwd,this.getClass().getSimpleName());
            return info;
        }

        System.out.println("AuthenticationInfo--->doGetAuthenticationInfo");

        return null;
    }


}
