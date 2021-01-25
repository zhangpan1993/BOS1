package com.zhangpan.bos.service;

import com.zhangpan.bos.domain.Noticebill;
import com.zhangpan.bos.service.base.IBaseService;

public interface INoticebillService extends IBaseService<Noticebill> {

    public void save(Noticebill entity,String decidedzoneId);
}
