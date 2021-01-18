package com.zhangpan.bos.dao.base;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoImpl<T> implements IBaseDao<T> {

    private Class<T> entityClass;


    @Autowired
    protected HibernateTemplate hibernateTemplate;

    public BaseDaoImpl(){

        //1.获得父类参数化类型
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();

        //2.获得父类参数化类型数组

        Type[] types = genericSuperclass.getActualTypeArguments();

        entityClass = (Class<T>) types[0];


    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void save(T entity) {

        this.hibernateTemplate.save(entity);

    }

    @Override
    public void delete(T entity) {

        this.hibernateTemplate.delete(entity);
    }

    @Override
    public void update(T entity) {

        this.hibernateTemplate.update(entity);
    }

    @Override
    public List<T> findall() {

        String hql = "From "+entityClass.getSimpleName();

        System.out.println("hql:"+hql);
        return this.hibernateTemplate.find(hql);
    }

    @Override
    public T findById(Serializable id) {

        return this.hibernateTemplate.get(entityClass,id);
    }

    @Override
    public void execteUpdate(String hql, Object... objs) {

        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
        Query query = session.createQuery(hql);

        for (int i=0;i<objs.length;i++){
            query.setParameter(i,objs[i]);
        }

        query.executeUpdate();
    }
}
