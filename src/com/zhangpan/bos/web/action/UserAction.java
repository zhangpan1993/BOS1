package com.zhangpan.bos.web.action;


import com.zhangpan.bos.domain.User;
import com.zhangpan.bos.service.IUserService;
import com.zhangpan.bos.web.action.base.BaseAction;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAction extends BaseAction<User> {

    @Autowired
    public IUserService userService;


    public String login(){
        String username = getModel().getUsername();
        String password = getModel().getPassword();

        System.out.println("username->"+username+"   password->"+password);

        HttpServletRequest request = ServletActionContext.getRequest();
        String serverCheckCode = (String)request.getSession().getAttribute("key");
        String clientCheckCode = request.getParameter("checkcode");

        if(serverCheckCode.equalsIgnoreCase(clientCheckCode)){

            User user = userService.login(username,password);

            if (user != null){

                request.getSession().setAttribute("loginUser",user);

                return "home";
            }else{

                addActionError("用户名或密码不正确");
            }
        }
        return "loginfailure";
    }


    public void editPassword() throws IOException {

        String newPwd = getModel().getPassword();
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();


        User loginUser = (User)request.getSession().getAttribute("loginUser");

        String UserId = loginUser.getId();

        Integer num = userService.modifyPassword(UserId,newPwd);

        System.out.println("UserId->"+UserId+"PASSWD->"+newPwd);

        if (num>0){


            //返回json格式处理
            response.setHeader("content-type","text/json;charset=utf-8");
            response.getWriter().print("{\"success\":\"1\"}");


        }

    }

    public String logout(){

        ServletActionContext.getRequest().getSession().invalidate();

        return login();
    }





}
