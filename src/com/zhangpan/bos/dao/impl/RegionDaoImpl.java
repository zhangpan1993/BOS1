package com.zhangpan.bos.dao.impl;

import com.zhangpan.bos.dao.IRegionDao;
import com.zhangpan.bos.dao.base.BaseDaoImpl;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Region;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements IRegionDao {


    @Override
    public void saveAll(List<Region> regions) {

        this.hibernateTemplate.saveOrUpdateAll(regions);
    }

    @Override
    public void pageQuery(PageBean<Region> pb) {

        int currentPage = pb.getCurrentPage();
        int pageSize = pb.getPageSize();

        //查询的封闭对象
        DetachedCriteria criteria = pb.getDetachedCriteria();
        criteria.setProjection(Projections.rowCount());
        List<Long> list = this.hibernateTemplate.findByCriteria(criteria);

        Long total = list.get(0);
        pb.setTotal(total.intValue());
        criteria.setProjection(null);

        List<Region> regions = this.hibernateTemplate.findByCriteria(criteria,(currentPage-1)*pageSize,pageSize);
        pb.setRows(regions);
    }
}
