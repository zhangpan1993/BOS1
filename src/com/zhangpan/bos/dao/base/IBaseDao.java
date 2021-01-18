package com.zhangpan.bos.dao.base;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {

    public void save(T entity);

    public void delete(T entity);

    public void update(T entity);

    public List<T> findall();

    public T findById(Serializable id);

    public void execteUpdate(String hql, Object... objs);

}
