package com.cursojava.servico;

import com.cursojava.dominio.Banco;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BancoServico {

    void incluir(Banco banco);

    void atualizar(Banco banco);

    void remover(Banco banco);

    Banco obter(Long id);

    List<Banco> listar();

    List<Banco> listar(int first, int pageSize);

    Long count();
}
