package com.zhangpan.bos.service.base;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> {

    public void save(T entity);

    public void delete(T entity);

    public void update(T entity);

    public T find(Serializable id);

    public List<T> findAll();
}
