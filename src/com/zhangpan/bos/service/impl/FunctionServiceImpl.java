package com.zhangpan.bos.service.impl;

import com.zhangpan.bos.dao.IFunctionDao;
import com.zhangpan.bos.domain.Function;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.service.IFunctionService;
import com.zhangpan.bos.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FunctionServiceImpl extends BaseServiceImpl<Function> implements IFunctionService {

    @Autowired
    private IFunctionDao functionDao;


    @Override
    public void pageQuery(PageBean<Function> pageBean) {

        functionDao.pageQuery(pageBean);
    }
}
