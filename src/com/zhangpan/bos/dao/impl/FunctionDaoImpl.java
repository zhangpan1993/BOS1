package com.zhangpan.bos.dao.impl;

import com.sun.corba.se.impl.oa.toa.TOA;
import com.zhangpan.bos.dao.IFunctionDao;
import com.zhangpan.bos.dao.base.BaseDaoImpl;
import com.zhangpan.bos.domain.Function;
import com.zhangpan.bos.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao {


    @Override
    public void pageQuery(PageBean<Function> pageBean) {

        int currentPage = pageBean.getCurrentPage();
        int pageSize = pageBean.getPageSize();

        DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long>  list = this.hibernateTemplate.findByCriteria(detachedCriteria);
        Long total = list.get(0);
        pageBean.setTotal(total.intValue());
        detachedCriteria.setProjection(null);
        List<Function> functions = this.hibernateTemplate.findByCriteria(detachedCriteria,(currentPage-1)*pageSize,pageSize);

        pageBean.setRows(functions);

    }

    @Override
    public void save(Function entity) {

    }

    @Override
    public void delete(Function entity) {

    }

    @Override
    public void update(Function entity) {

    }
}
