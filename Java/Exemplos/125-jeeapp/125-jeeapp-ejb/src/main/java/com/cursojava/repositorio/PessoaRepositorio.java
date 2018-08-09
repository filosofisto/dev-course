package com.cursojava.repositorio;

import com.cursojava.dominio.Pessoa;

import java.util.List;

/**
 * Created by Renan on 08/08/2018.
 */
public interface PessoaRepositorio extends Repository<Pessoa, Long> {

    /**
     * Lista de pessoas ordenado por nome.
     *
     * @return
     */
    List<Pessoa> listar();

    /**
     * Lista de pessoas paginado.
     *
     * @param first
     * @param pageSize
     * @return
     */
    List<Pessoa> listar(int first, int pageSize);
}
