package com.zhangpan.bos.service;

import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Region;
import com.zhangpan.bos.service.base.IBaseService;

import java.util.List;

public interface IRegionService extends IBaseService<Region> {

    public void saveAll(List<Region> regions);

    public void pageQuery(PageBean pb);
}
