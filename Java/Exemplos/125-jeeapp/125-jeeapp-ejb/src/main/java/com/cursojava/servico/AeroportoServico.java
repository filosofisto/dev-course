package com.cursojava.servico;

import com.cursojava.dominio.Aeroporto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AeroportoServico {

    void incluir(Aeroporto aeroporto);

    void atualizar(Aeroporto aeroporto);

    void remover(Aeroporto aeroporto);

    Aeroporto editar(Long id);

    List<Aeroporto> listar();
}
