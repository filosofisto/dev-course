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
    public List<Aeroporto> listar() {
        return entityManager.createNamedQuery("Aeroporto.Listar")
                .getResultList();
    }


}
