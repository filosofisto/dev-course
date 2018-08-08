package com.cursojava.repositorio.jpa;

import com.cursojava.dominio.Banco;
import com.cursojava.repositorio.BancoRepositorio;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Eduardo on 19/07/2015.
 */
public class BancoRepositorioJPA
        extends RepositoryJPA<Banco, Long>
        implements BancoRepositorio {


    @Inject
    protected EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Banco> listar() {
        return entityManager.createNamedQuery("Banco.Listar", Banco.class)
                .getResultList();
    }

    @Override
    public List<Banco> listar(int first, int pageSize) {
        return entityManager.createNamedQuery("Banco.Listar", Banco.class)
                .setFirstResult(first)
                .setMaxResults(pageSize)
                .getResultList();
    }
}
