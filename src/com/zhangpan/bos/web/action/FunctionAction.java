package com.zhangpan.bos.web.action;

import com.zhangpan.bos.domain.Function;
import com.zhangpan.bos.service.IFunctionService;
import com.zhangpan.bos.web.action.base.BaseAction;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class FunctionAction extends BaseAction<Function> {

    Logger logger = Logger.getLogger(FunctionAction.class);

    @Autowired
    private IFunctionService functionService;

    public void pageQuery() throws IOException {

        System.out.println("当前页码:"+page);

        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);

        pageBean.setDetachedCriteria(detachedCriteria);
        functionService.pageQuery(pageBean);
        responseJson(pageBean,new String[]{"roles","function","functions","detachedCriteria","currentPage","pageSize"});

    }


    public void listJson() throws IOException {

       List<Function> functions = functionService.findAll();

       responseJson(functions,new String[]{"function","functions","roles"});
    }

}
