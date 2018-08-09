package com.cursojava.repositorio;

import java.util.List;

import com.cursojava.dominio.Modalidade;

public interface ModalidadeRepositorio extends Repository<Modalidade, Long>{
	/**
     * Lista de modalidades ordenadas por nome.
     *
     * @return
     */
    List<Modalidade> listar();

    /**
     * Lista de modalidades paginada.
     *
     * @param first
     * @param pageSize
     * @return
     */
    List<Modalidade> listar(int first, int pageSize);
}
