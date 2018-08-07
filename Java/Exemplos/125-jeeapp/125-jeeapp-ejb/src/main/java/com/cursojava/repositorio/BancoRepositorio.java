package com.cursojava.repositorio;

import com.cursojava.dominio.Banco;

import java.util.List;

/**
 * Created by Eduardo on 19/07/2015.
 */
public interface BancoRepositorio extends Repository<Banco, Long> {

    List<Banco> listar();

}
