package com.zhangpan.bos.dao;

import com.zhangpan.bos.dao.base.IBaseDao;
import com.zhangpan.bos.domain.Function;
import com.zhangpan.bos.domain.PageBean;

public interface IFunctionDao extends IBaseDao<Function> {


    public void pageQuery(PageBean<Function> pageBean);

}
