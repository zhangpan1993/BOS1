package com.zhangpan.bos.service.impl;

import com.zhangpan.bos.dao.IStaffDao;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Staff;
import com.zhangpan.bos.service.IStaffService;
import com.zhangpan.bos.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class StaffServiceImpl extends BaseServiceImpl<Staff> implements IStaffService {

    @Autowired
    private IStaffDao staffDao;

    @Override
    public void save(Staff entity) {

        staffDao.save(entity);

    }

    @Override
    public void delete(Staff entity) {

    }

    @Override
    public void update(Staff entity) {

        staffDao.update(entity);
    }

    @Override
    public Staff find(Serializable id) {
        return null;
    }

    @Override
    public List<Staff> findAll() {
        return null;
    }

    public void pageQuery(PageBean pb){

        staffDao.pageQuery(pb);
    }

    public void deleteBatch(String ids){

        String hql = "update Staff set deltag= ? where id = ?";
        String[] arr = ids.split(",");
        for(String id:arr){

            staffDao.execteUpdate(hql,"1",id);
        }

    }

    public Staff findById(String id){
        Staff  staff = staffDao.findById(id);

        return staff;
    }

    @Override
    public List<Staff> findListNotDelete() {
       return staffDao.findListNotDelete();
    }
}
