package com.zhangpan.bos.dao.impl;

import com.zhangpan.bos.dao.ISubareaDao;
import com.zhangpan.bos.dao.base.BaseDaoImpl;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Subarea;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubareaDaoImpl extends BaseDaoImpl<Subarea> implements ISubareaDao {

    @Override
    public void pageQuery(PageBean<Subarea> pb) {


        int currentPage = pb.getCurrentPage();
        int pageSize = pb.getPageSize();

        //查询的封闭对象
        DetachedCriteria criteria = pb.getDetachedCriteria();
        criteria.setProjection(Projections.rowCount());

        List<Long> list = this.hibernateTemplate.findByCriteria(criteria);

        Long total = list.get(0);
        pb.setTotal(total.intValue());
        criteria.setProjection(null);

        List<Subarea> subareas = this.hibernateTemplate.findByCriteria(criteria,(currentPage-1)*pageSize,pageSize);
        pb.setRows(subareas);
    }

    @Override
    public List<Subarea> findListByDetachedCriteria(DetachedCriteria dc) {

        return this.hibernateTemplate.findByCriteria(dc);
    }


}
