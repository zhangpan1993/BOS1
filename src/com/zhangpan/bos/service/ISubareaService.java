package com.zhangpan.bos.service;

import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Subarea;
import com.zhangpan.bos.service.base.IBaseService;

import java.util.List;

public interface ISubareaService extends IBaseService<Subarea> {

    public void pageQuery(PageBean<Subarea> pb);

    public List<Subarea> findListNoAssociation();
}
