package com.zhangpan.bos.service.impl;

import com.zhangpan.bos.dao.IRegionDao;
import com.zhangpan.bos.domain.PageBean;
import com.zhangpan.bos.domain.Region;
import com.zhangpan.bos.service.IRegionService;
import com.zhangpan.bos.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class RegionServiceImpl extends BaseServiceImpl<Region> implements IRegionService {

    @Autowired
    private IRegionDao regionDao;



    @Override
    public void save(Region entity) {

        regionDao.save(entity);
    }

    @Override
    public void delete(Region entity) {

    }

    @Override
    public void update(Region entity) {

    }

    @Override
    public Region find(Serializable id) {
        return null;
    }

    @Override
    public List<Region> findAll() {

        return regionDao.findall();
    }

    @Override
    public void saveAll(List<Region> regions) {

        regionDao.saveAll(regions);
    }

    @Override
    public void pageQuery(PageBean pb) {

        regionDao.pageQuery(pb);
    }
}
