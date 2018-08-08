package com.cursojava.servico;

import com.cursojava.dominio.Pessoa;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PessoaServico {

    void incluir(Pessoa pessoa);

    void atualizar(Pessoa pessoa);

    void remover(Pessoa pessoa);

    Pessoa obter(Long id);

    List<Pessoa> listar();

    List<Pessoa> listar(int first, int pageSize);

    long count();
}
