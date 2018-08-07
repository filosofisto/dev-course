import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import curso.jpa.entity.Endereco;
import curso.jpa.entity.Pessoa;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("jpa-01");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			
			Pessoa p = new Pessoa();
			p.setNome("Jose da Silva");
			
			Endereco e = new Endereco();
			e.setRua("Araucaria");
			e.setCidade("Brasilia");
			e.setEstado("DF");
			e.setCep("88000000");
			
			entityManager.persist(e);
			
			p.setEndereco(e);
			
			entityManager.persist(p);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		try {
			transaction.begin();
			
			//Endereco orfao
			/*Pessoa p = entityManager.find(Pessoa.class, new Long(1));
			p.setEndereco(null);*/
			Pessoa p = new Pessoa();
			p.setId(1L);
			p.setNome("Jose da Silva");
			p.setEndereco(null);

			//entityManager.merge(p);

			Endereco outroEnd = new Endereco();
			outroEnd.setRua("Rua das Gaivotas");
			outroEnd.setCep("81665544");
			outroEnd.setCidade("Sao Paulo");
			outroEnd.setEstado("SP");
			outroEnd.setComplemento("Ed Harpia Ap 1234");

			entityManager.persist(outroEnd);

			p.setEndereco(outroEnd);
			entityManager.merge(p);

			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
