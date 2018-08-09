package com.cursojava.servico.bean;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.cursojava.dominio.Pessoa;
import com.cursojava.repositorio.PessoaRepositorio;
import com.cursojava.servico.PessoaServico;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PessoaServicoBean implements PessoaServico, Serializable {

    @Inject
    private Logger log;

    @Inject
    private PessoaRepositorio pessoaRepositorio;

    @Override
    public void incluir(Pessoa pessoa) {
        log.info("Incluindo nova pessoa");
       pessoaRepositorio.insert(pessoa);
        log.info("Aeroporto incluido com sucesso");
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        log.info("Atualizando pessoa " + pessoa.getId());
        pessoaRepositorio.update(pessoa);
        log.info("Pessoa atualizado com sucesso");
    }

    @Override
    public void remover(Pessoa pessoa) {
        log.info("Removendo pessoa " + pessoa.getId());
        pessoaRepositorio.remove(pessoa);
        log.info("Pessoa removido com sucesso");
    }

    @Override
    public Pessoa obter(Long id) {
        log.info("Obtendo pessoa " + id);
        return pessoaRepositorio.find(id);
    }

    @Override
    public List<Pessoa> listar() {
        return pessoaRepositorio.listar();
    }

    @Override
    public List<Pessoa> listar(int first, int pageSize) {
        return pessoaRepositorio.listar(first, pageSize);
    }

    @Override
    public long count() {
        return pessoaRepositorio.count();
    }
}
