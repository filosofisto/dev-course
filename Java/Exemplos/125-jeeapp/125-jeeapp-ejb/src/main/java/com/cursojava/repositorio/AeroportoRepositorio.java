package com.cursojava.repositorio;

import com.cursojava.dominio.Aeroporto;

import java.util.List;

/**
 * Created by Eduardo on 19/07/2015.
 */
public interface AeroportoRepositorio extends Repository<Aeroporto, Long> {

    /**
     * Lista de aeroportos ordenado por nome.
     *
     * @return
     */
    List<Aeroporto> listar();
}
