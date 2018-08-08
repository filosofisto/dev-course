package com.cursojava.repositorio.jpa;

import com.cursojava.repositorio.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Eduardo on 19/07/2015.
 */
public abstract class RepositoryBaseJPA<T,K> implements Repository<T,K> {

    private Class<T> entityClass;

    private Class<K> keyClass;

    protected abstract EntityManager getEntityManager();

    @Override
    public void insert(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public T find(K key) {
        return getEntityManager().find(entityClass(), key);
    }

    @Override
    public Long count() {
        Query query = getEntityManager().createQuery("select count(*) from " +entityClass().getSimpleName());
        return (Long) query.getSingleResult();
    }

    @Override
    public void remove(T entity) {
        getEntityManager().remove(entity);
    }

    @Override
    public void removeByKey(K key) {
        T entity = find(key);
        getEntityManager().remove(entity);
    }

    protected Class<T> entityClass() {
        if (entityClass == null) {
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
            } else {
                throw new IllegalArgumentException("Tipo nao parametrizado");
            }
        }

        return entityClass;
    }

    protected Class<K> keyClass() {
        if (keyClass == null) {
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                keyClass = (Class<K>) parameterizedType.getActualTypeArguments()[1];
            } else {
                throw new IllegalArgumentException("Tipo nao parametrizado");
            }
        }

        return keyClass;
    }
}
