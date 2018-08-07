package control;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static java.lang.System.out;

import model.jpa.entity.Endereco;
import model.jpa.entity.Pessoa;
import model.jpa.entity.Veiculo;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-01");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			
			Saida.exibir(true, "Inserção: Pessoa, Endereço e Veiculo.");
			
			transaction.begin();

			
			
			Pessoa p = new Pessoa();
			p.setNome("Fulano Dital");

			Endereco e = new Endereco();
			e.setRua("Avenida do Ciclano");
			e.setCidade("São Paulo");
			e.setEstado("SP");
			e.setCep("88000000");

			entityManager.persist(e);

			p.setEndereco(e);

			Veiculo v = new Veiculo();
			v.setPlaca("S093-V341");
			v.setModelo("Fusca");
			v.setFabricante("Volkswagen");
			v.setAno(2020);

			entityManager.persist(v);

			p.setVeiculo(v);

			entityManager.persist(p);

			transaction.commit();
			
			Saida.exibir("Registros inseridos no banco: ", p.toString());
			
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		try {
			Saida.exibir(true, "Procura: Pessoa");
			transaction.begin();
			Pessoa p = entityManager.find(Pessoa.class, new Long(1));
			entityManager.remove(p);
			transaction.commit();
			
			Saida.exibir("Pessoa encontrada: ", p.toString());
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	protected static class Saida {
		private static Scanner in;

		private static void prepararScanner() {
			if (in == null) {
				in = new Scanner(System.in);
			}
		}

		private static void exibir(boolean confirmacao, String... mensagens) {
			out.println();
			for (String m : mensagens) {
				out.println("\t "+m);
			}

			if (confirmacao) {
				out.println("\t Pressione [ENTER] para continuar.");
				prepararScanner();
				in.nextLine();
			}
		}

		private static void exibir(String... mensagens) {
			exibir(false, mensagens);
		}

	}

}
