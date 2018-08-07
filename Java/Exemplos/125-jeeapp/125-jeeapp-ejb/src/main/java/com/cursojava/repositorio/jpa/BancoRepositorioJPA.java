package com.cursojava.repositorio.jpa;

import com.cursojava.dominio.Banco;
import com.cursojava.repositorio.BancoRepositorio;

import java.util.List;

/**
 * Created by Eduardo on 19/07/2015.
 */
public class BancoRepositorioJPA
        extends RepositoryBaseJPA<Banco, Long>
        implements BancoRepositorio {

    @Override
    public List<Banco> listar() {
        return entityManager.createNamedQuery("Banco.Listar", Banco.class)
                .getResultList();
    }
}
