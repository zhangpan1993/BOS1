package com.zhangpan.bos.service.base;

import com.zhangpan.bos.domain.DecidedZone;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {


    public void save(T entity) {

    }

    public void delete(T entity) {

    }

    public void update(T entity) {

    }

    public T find(Serializable id) {
        return null;
    }

    public List<T> findAll() {
        return null;
    }
}
