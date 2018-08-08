package com.cursojava.servico.bean;

import com.cursojava.dominio.Aeroporto;
import com.cursojava.dominio.Pessoa;
import com.cursojava.repositorio.AeroportoRepositorio;
import com.cursojava.repositorio.PessoaRepositorio;
import com.cursojava.servico.AeroportoServico;
import com.cursojava.servico.PessoaServico;

import javax.ejb.*;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

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
        log.info("Incluindo novo aeroporto");
       pessoaRepositorio.insert(pessoa);
        log.info("Aeroporto incluido com sucesso");
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        log.info("Atualizando aeroporto " + pessoa.getId());
        pessoaRepositorio.update(pessoa);
        log.info("Aeroporto atualizado com sucesso");
    }

    @Override
    public void remover(Pessoa pessoa) {
        log.info("Removendo aeroporto " + pessoa.getId());
        pessoaRepositorio.remove(pessoa);
        log.info("Aeroporto removido com sucesso");
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
