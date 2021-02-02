package com.zhangpan.bos.service;

import com.zhangpan.bos.domain.Function;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.service.base.IBaseService;

public interface IFunctionService extends IBaseService<Function> {

    public void pageQuery(PageBean<Function> pageBean);
}
