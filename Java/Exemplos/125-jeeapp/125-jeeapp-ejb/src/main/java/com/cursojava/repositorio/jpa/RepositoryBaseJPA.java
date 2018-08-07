package com.cursojava.repositorio.jpa;

import com.cursojava.repositorio.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Eduardo on 19/07/2015.
 */
public abstract class RepositoryBaseJPA<T,K> implements Repository<T,K> {

    private Class<T> entityClass;

    private Class<K> keyClass;

    @Inject
    protected EntityManager entityManager;

    @Override
    public void insert(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public T find(K key) {
        return entityManager.find(entityClass(), key);
    }

    @Override
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public void removeByKey(K key) {
        T entity = find(key);
        entityManager.remove(entity);
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
