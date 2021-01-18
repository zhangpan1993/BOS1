package com.zhangpan.bos.dao.impl;

import com.zhangpan.bos.dao.IStaffDao;
import com.zhangpan.bos.dao.base.BaseDaoImpl;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Staff;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements IStaffDao {

    public void pageQuery(PageBean<Staff> pb){

        int currentPage = pb.getCurrentPage();
        int pageSize = pb.getPageSize();

        //查询的封闭对象
        DetachedCriteria criteria = pb.getDetachedCriteria();

        criteria.setProjection(Projections.rowCount());

        List<Long> list = this.hibernateTemplate.findByCriteria(criteria);

        Long total = list.get(0);
        pb.setTotal(total.intValue());

        criteria.setProjection(null);

        List<Staff> staffs = this.hibernateTemplate.findByCriteria(criteria,(currentPage-1)*pageSize,pageSize);

        pb.setRows(staffs);

    }

    @Override
    public List<Staff> findListNotDelete() {

        String hql = "From Staff where deltag =0";
        List<Staff> staffList = this.hibernateTemplate.find(hql);

        return staffList;
    }


}
