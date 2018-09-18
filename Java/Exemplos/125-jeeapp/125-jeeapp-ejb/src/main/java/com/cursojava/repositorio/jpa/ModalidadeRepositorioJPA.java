package com.cursojava.repositorio.jpa;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.cursojava.dominio.Modalidade;
import com.cursojava.repositorio.ModalidadeRepositorio;

public class ModalidadeRepositorioJPA 
		extends RepositoryJPA<Modalidade, Long> 
		implements ModalidadeRepositorio{

	@Inject
    private EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public List<Modalidade> listar() {
		return entityManager.createNamedQuery("Modalidade.Listar")
                .getResultList();
	}

	@Override
	public List<Modalidade> listar(int first, int pageSize) {
		return entityManager.createNamedQuery("Modalidade.Listar")
                .setFirstResult(first)
                .setMaxResults(pageSize)
                .getResultList();
	}


}
