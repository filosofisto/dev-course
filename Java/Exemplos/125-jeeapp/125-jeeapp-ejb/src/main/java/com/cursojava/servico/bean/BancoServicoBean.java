package com.cursojava.servico.bean;

import com.cursojava.dominio.Banco;
import com.cursojava.repositorio.BancoRepositorio;
import com.cursojava.servico.BancoServico;

import javax.ejb.*;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class BancoServicoBean implements BancoServico, Serializable {

    @Inject
    private Logger log;

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
    public Banco obter(Long id) {
        return bancoRepositorio.find(id);
    }

    @Override
    public List<Banco> listar() {
        return bancoRepositorio.listar();
    }

    @Override
    public List<Banco> listar(int first, int pageSize) {
        return bancoRepositorio.listar(first, pageSize);
    }

    @Override
    public Long count() {
        return bancoRepositorio.count();
    }
}
