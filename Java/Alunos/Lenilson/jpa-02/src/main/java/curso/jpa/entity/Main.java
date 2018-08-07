package curso.jpa.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("jpa-01");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			
			Pais p = new Pais();
			p.setNome("Brasil");
			
			Estado est = new Estado();
			est.setNome("Sao Paulo");
			
			Cidade c1 = new Cidade();
			c1.setNome("Santos");
			
			Cidade c2 = new Cidade();
			c2.setNome("Campinas");
			
			est.getCidades().add(c1);
			est.getCidades().add(c2);
			
			p.getEstados().add(est);
			
			//entityManager.persist(c1);
			//entityManager.persist(c2);
			//entityManager.persist(est);
			entityManager.persist(p);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		/*try {
			transaction.begin();
			
			//Endereco orfao
			Pessoa p = entityManager.find(Pessoa.class, new Long(1));
			p.setEndereco(null);
			p.getTelefones().clear();
			entityManager.remove(p);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}*/
	}
}
