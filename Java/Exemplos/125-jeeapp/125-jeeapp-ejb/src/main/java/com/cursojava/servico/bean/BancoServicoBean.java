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

import com.cursojava.dominio.Banco;
import com.cursojava.repositorio.BancoRepositorio;
import com.cursojava.servico.BancoServico;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class BancoServicoBean implements BancoServico {

    /*@Inject
    private Logger log;*/

    @Inject
    private BancoRepositorio bancoRepositorio;

    @Override
    public void incluir(Banco banco) {
        bancoRepositorio.insert(banco);
    }

    @Override
    public void atualizar(Banco banco) {
        bancoRepositorio.update(banco);
    }

    @Override
    public void remover(Banco banco) {
        bancoRepositorio.remove(banco);
    }

    @Override
    public Banco editar(Long id) {
        return bancoRepositorio.find(id);
    }

    @Override
    public List<Banco> listar() {
        return bancoRepositorio.listar();
    }
}
