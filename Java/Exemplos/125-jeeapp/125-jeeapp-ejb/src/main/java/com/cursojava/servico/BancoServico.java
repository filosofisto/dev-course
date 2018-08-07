package com.cursojava.servico;

import com.cursojava.dominio.Banco;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BancoServico {

    void incluir(Banco banco);

    void atualizar(Banco banco);

    void remover(Banco banco);

    Banco editar(Long id);

    List<Banco> listar();
}
