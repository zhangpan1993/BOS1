package com.zhangpan.bos.dao;

import com.zhangpan.bos.dao.base.IBaseDao;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Region;

import java.util.List;

public interface IRegionDao extends IBaseDao<Region> {

    public void saveAll(List<Region> regions);

    public void pageQuery(PageBean<Region> pb);
}
