package com.zhangpan.bos.dao.impl;

import com.zhangpan.bos.dao.INoticebillDao;
import com.zhangpan.bos.dao.base.BaseDaoImpl;
import com.zhangpan.bos.domain.Noticebill;
import com.zhangpan.bos.service.base.BaseServiceImpl;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


@Repository
public class NoticebillDaoImpl extends BaseDaoImpl<Noticebill> implements INoticebillDao {
    @Override
    public List<Noticebill> findall() {
        return null;
    }

    @Override
    public Noticebill findById(Serializable id) {
        return null;
    }

    @Override
    public void execteUpdate(String hql, Object... objs) {

    }
}
