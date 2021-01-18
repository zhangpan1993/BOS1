package com.zhangpan.bos.service;

import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Staff;
import com.zhangpan.bos.service.base.IBaseService;

import java.util.List;

public interface IStaffService  extends IBaseService<Staff> {

    public void pageQuery(PageBean pb);
    public void deleteBatch(String ids);
    public Staff findById(String id);

    public List<Staff> findListNotDelete();

}
