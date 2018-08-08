package com.cursojava.repositorio;

import com.cursojava.dominio.Banco;

import java.util.List;

/**
 * Created by Eduardo on 19/07/2015.
 */
public interface BancoRepositorio extends Repository<Banco, Long> {

    /**
     * Lista de bancos ordenado por nome.
     *
     * @return
     */
    List<Banco> listar();

    /**
     * Lista de bancos ordenado por nome e paginado.
     *
     * @param first
     * @param pageSize
     * @return
     */
    List<Banco> listar(int first, int pageSize);
}
