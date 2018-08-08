package com.cursojava.repositorio.jpa;

import com.cursojava.dominio.Aeroporto;
import com.cursojava.repositorio.AeroportoRepositorio;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Eduardo on 19/07/2015.
 */
public class AeroportoRepositorioJPA
        extends RepositoryBaseJPA<Aeroporto, Long>
        implements AeroportoRepositorio {

    @Inject
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Aeroporto> listar() {
        return entityManager.createNamedQuery("Aeroporto.Listar")
                .getResultList();
    }

    @Override
    public List<Aeroporto> listar(int first, int pageSize) {
        return entityManager.createNamedQuery("Aeroporto.Listar")
                .setFirstResult(first)
                .setMaxResults(pageSize)
                .getResultList();
    }


}
