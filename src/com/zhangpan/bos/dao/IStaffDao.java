package com.zhangpan.bos.dao;

import com.zhangpan.bos.dao.base.IBaseDao;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Staff;

import java.util.List;

public interface IStaffDao extends IBaseDao<Staff> {

    public void pageQuery(PageBean<Staff> pb);


    public List<Staff> findListNotDelete();
}
