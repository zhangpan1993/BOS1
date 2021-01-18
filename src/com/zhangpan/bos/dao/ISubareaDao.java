package com.zhangpan.bos.dao;

import com.zhangpan.bos.dao.base.IBaseDao;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Subarea;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface ISubareaDao extends IBaseDao<Subarea> {
    public void pageQuery(PageBean<Subarea> pb);

    public List<Subarea> findListByDetachedCriteria(DetachedCriteria dc);
}
