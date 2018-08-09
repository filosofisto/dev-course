package com.cursojava.repositorio;

import com.cursojava.dominio.Pessoa;

import java.util.List;

/**
 * Created by Eduardo on 19/07/2015.
 */
public interface PessoaRepositorio extends Repository<Pessoa, Long> {

    /**
     * Lista de aeroportos ordenado por nome.
     *
     * @return
     */
    List<Pessoa> listar();

    /**
     * Lista de aeroportos paginado.
     *
     * @param first
     * @param pageSize
     * @return
     */
    List<Pessoa> listar(int first, int pageSize);
}
