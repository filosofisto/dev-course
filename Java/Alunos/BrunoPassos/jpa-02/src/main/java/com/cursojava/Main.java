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
			entityManager.persist(pais);

			Estado estado = new Estado();
			estado.setNomeEstado("Rondonia");
			estado.setPais(pais);
			entityManager.persist(estado);

			Cidade cidade = new Cidade();
			cidade.setNomeCidade("Ouro Preto do Oeste");
			cidade.setEstado(estado);
			entityManager.persist(cidade);
				

			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
