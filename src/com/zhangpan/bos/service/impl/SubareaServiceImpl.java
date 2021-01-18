package com.zhangpan.bos.service.impl;

import com.zhangpan.bos.dao.ISubareaDao;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Subarea;
import com.zhangpan.bos.service.ISubareaService;
import com.zhangpan.bos.service.base.BaseServiceImpl;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class SubareaServiceImpl extends BaseServiceImpl<Subarea> implements ISubareaService {

    @Autowired
    private ISubareaDao subareaDao;

    @Override
    public void save(Subarea entity) {

        subareaDao.save(entity);

    }

    @Override
    public void delete(Subarea entity) {

    }

    @Override
    public void update(Subarea entity) {

    }

    @Override
    public Subarea find(Serializable id) {
        return null;
    }

    @Override
    public List<Subarea> findAll() {
        return subareaDao.findall();
    }

    @Override
    public void pageQuery(PageBean<Subarea> pb) {

        subareaDao.pageQuery(pb);
    }

    @Override
    public List<Subarea> findListNoAssociation() {

        DetachedCriteria dc = DetachedCriteria.forClass(Subarea.class);
        dc.add(Restrictions.isNull("decidedZone"));
        return subareaDao.findListByDetachedCriteria(dc);
    }


}
