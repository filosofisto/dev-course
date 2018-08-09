package com.cursojava.repositorio.jpa;

import com.cursojava.dominio.Aeroporto;
import com.cursojava.dominio.Pessoa;
import com.cursojava.repositorio.AeroportoRepositorio;
import com.cursojava.repositorio.PessoaRepositorio;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Renan on 08/08/2018.
 */
public class PessoaRepositorioJPA
        extends RepositoryJPA<Pessoa, Long>
        implements PessoaRepositorio {

    @Inject
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Pessoa> listar() {
        return entityManager.createNamedQuery("Aeroporto.Listar")
                .getResultList();
    }

    @Override
    public List<Pessoa> listar(int first, int pageSize) {
        return entityManager.createNamedQuery("Aeroporto.Listar")
                .setFirstResult(first)
                .setMaxResults(pageSize)
                .getResultList();
    }


}
