package com.zhangpan.bos.web.filter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zhangpan.bos.domain.User;
import org.apache.struts2.ServletActionContext;

public class BOSLoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        User loginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
        if (loginUser == null){

            return "login";
        }

        System.out.println("拦截中。。。"+actionInvocation);

        return actionInvocation.invoke();

    }
}
