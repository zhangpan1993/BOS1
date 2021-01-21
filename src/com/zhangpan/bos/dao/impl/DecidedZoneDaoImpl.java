package com.zhangpan.bos.dao.impl;

import com.zhangpan.bos.dao.IDecidedZoneDao;
import com.zhangpan.bos.dao.base.BaseDaoImpl;
import com.zhangpan.bos.domain.DecidedZone;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Region;
import com.zhangpan.bos.domain.Staff;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DecidedZoneDaoImpl extends BaseDaoImpl<DecidedZone> implements IDecidedZoneDao{



    @Override
    public void pageQuery(PageBean<DecidedZone> pb) {

        int currentPage = pb.getCurrentPage();
        int pageSize = pb.getPageSize();

        //查询的封闭对象
        DetachedCriteria criteria = pb.getDetachedCriteria();

        System.out.println("--------------------= " + pb.getDetachedCriteria() );

        criteria.setProjection(Projections.rowCount());

        List<Long> list = this.hibernateTemplate.findByCriteria(criteria);

        Long total = list.get(0);
        pb.setTotal(total.intValue());
        criteria.setProjection(null);

        List<DecidedZone> decidedZones = this.hibernateTemplate.findByCriteria(criteria,(currentPage-1)*pageSize,pageSize);

        pb.setRows(decidedZones);
    }



}
