package com.cursojava.servico;

import com.cursojava.dominio.Aeroporto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AeroportoServico {

    void incluir(Aeroporto aeroporto);

    void atualizar(Aeroporto aeroporto);

    void remover(Aeroporto aeroporto);

    Aeroporto obter(Long id);

    List<Aeroporto> listar();

    List<Aeroporto> listar(int first, int pageSize);

    long count();
}
