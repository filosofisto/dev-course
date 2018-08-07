package com.cursojava.servico.bean;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.cursojava.dominio.Aeroporto;
import com.cursojava.repositorio.AeroportoRepositorio;
import com.cursojava.servico.AeroportoServico;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AeroportoServicoBean implements AeroportoServico {

    /*@Inject
    private Logger log;*/

    @Inject
    private AeroportoRepositorio aeroportoRepositorio;

    @Override
    public void incluir(Aeroporto aeroporto) {
        aeroportoRepositorio.insert(aeroporto);
    }

    @Override
    public void atualizar(Aeroporto aeroporto) {
        aeroportoRepositorio.update(aeroporto);
    }

    @Override
    public void remover(Aeroporto aeroporto) {
        aeroportoRepositorio.remove(aeroporto);
    }

    @Override
    public Aeroporto editar(Long id) {
        return aeroportoRepositorio.find(id);
    }

    @Override
    public List<Aeroporto> listar() {
        return aeroportoRepositorio.listar();
    }
}
