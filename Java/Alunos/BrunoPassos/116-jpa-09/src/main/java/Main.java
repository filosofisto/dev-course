import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import curso.jpa.entity.Diretor;
import curso.jpa.entity.Funcionario;
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
			
			entityManager.persist(p);
			
			Funcionario f = new Funcionario();
			f.setNome("Joao Trabalhador");
			f.setSalario(10000.0);
			
			entityManager.persist(f);
			
			Diretor diretor = new Diretor();
			diretor.setNome("Ronaldinho Gaucho");
			diretor.setAuxilioMoradia(15000.00);
			diretor.setSalario(250000.00);
			
			entityManager.persist(diretor);
			
			Query query = entityManager.createQuery("select p from Pessoa p");
			System.out.println("Pessoas: " + query.getResultList().size());
			
			Query queryF = entityManager.createQuery("select f from Funcionario f");
			System.out.println("Funcionario: " + queryF.getResultList().size());
			
			Query queryD = entityManager.createQuery("select d from Diretor d");
			System.out.println("Diretor: " + queryD.getResultList().size());
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
