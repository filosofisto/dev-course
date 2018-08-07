package com.cursojava;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-01");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			Pais pais = new Pais();
			pais.setNomePais("Brasil");

			Estado estado = new Estado();
			estado.setNomeEstado("Rondonia");

			Cidade cidade = new Cidade();
			cidade.setNomeCidade("Ouro Preto do Oeste");
			
			estado.getCidades().add(cidade);
			pais.getEstados().add(estado);		
			
			
			entityManager.persist(cidade);
			entityManager.persist(estado);
			entityManager.persist(pais);

			transaction.commit();

		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
