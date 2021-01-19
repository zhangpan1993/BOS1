package com.zhangpan.bos.service.impl;

import com.zhangpan.bos.dao.IDecidedZoneDao;
import com.zhangpan.bos.dao.ISubareaDao;
import com.zhangpan.bos.domain.DecidedZone;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Subarea;
import com.zhangpan.bos.service.IDecidedzoneService;
import com.zhangpan.bos.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class DecidedzoneServiceImpl extends BaseServiceImpl<DecidedZone> implements IDecidedzoneService {

    @Autowired
    private IDecidedZoneDao decidedZoneDao;

    @Autowired
    private ISubareaDao subareaDao;

    @Override
    public void save(DecidedZone model, String[] subareaid) {
        decidedZoneDao.save(model);
        for (String id:subareaid){

            Subarea subarea = subareaDao.findById(id);
            subarea.setDecidedZone(model);
        }

    }

    @Override
    public void pageQuery(PageBean pb) {
        decidedZoneDao.pageQuery(pb);
    }


}
