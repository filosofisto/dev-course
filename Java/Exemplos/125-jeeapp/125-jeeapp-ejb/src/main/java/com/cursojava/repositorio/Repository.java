package com.cursojava.repositorio;

/**
 * Created by Eduardo on 19/07/2015.
 */
public interface Repository<T, K> {

    void insert(T entity);

    void update(T entity);

    void remove(T entity);

    void removeByKey(K key);

    T find(K key);
}
