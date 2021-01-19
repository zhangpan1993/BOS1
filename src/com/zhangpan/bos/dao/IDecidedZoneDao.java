package com.zhangpan.bos.dao;

import com.zhangpan.bos.dao.base.IBaseDao;
import com.zhangpan.bos.domain.DecidedZone;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Staff;

public interface IDecidedZoneDao extends IBaseDao<DecidedZone> {

    public void pageQuery(PageBean<DecidedZone> pb);

}

