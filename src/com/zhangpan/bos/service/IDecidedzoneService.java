package com.zhangpan.bos.service;

import com.zhangpan.bos.domain.DecidedZone;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.service.base.IBaseService;

public interface IDecidedzoneService extends IBaseService<DecidedZone> {

    public void save(DecidedZone model, String[] subareaid);

    public void pageQuery(PageBean pb);
}
