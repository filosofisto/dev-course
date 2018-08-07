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

			Console.exibir(true, "Inserção de registros");

			transaction.begin();

			Console.exibir("Pessoa");

			Pessoa p = new Pessoa();
			p.setNome(Console.ler("Nome"));

			Console.exibir("Endereço");

			Endereco e = new Endereco();
			e.setRua(Console.ler("Rua"));
			e.setCidade(Console.ler("Cidade"));
			e.setEstado(Console.ler("Estado"));
			e.setCep(Console.ler("CEP"));

			entityManager.persist(e);

			p.setEndereco(e);

			Console.exibir("Veiculo");

			Veiculo v = new Veiculo();
			v.setPlaca(Console.ler("Placa"));
			v.setModelo(Console.ler("Modelo"));
			v.setFabricante(Console.ler("Fabricante"));
			v.setAno(Integer.parseInt(Console.ler("Ano")));

			entityManager.persist(v);

			p.setVeiculo(v);

			entityManager.persist(p);

			Console.exibir(true, "Informações a serem inseridas no banco", p.toString());

			transaction.commit();

		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		try {
			Console.exibir(true, "Procura: Pessoa");
			transaction.begin();
			Pessoa p = entityManager.find(Pessoa.class, new Long(1));
			entityManager.remove(p);
			transaction.commit();

			Console.exibir("Pessoa encontrada: ", p.toString());
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	protected static class Console {
		private static Scanner in;

		private static void prepararScanner() {
			if (in == null) {
				in = new Scanner(System.in);
			}
		}

		private static void exibir(boolean confirmacao, String... mensagens) {
			out.println();
			for (String m : mensagens) {
				out.println("\t " + m);
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

		private static String ler(String mensagem) {
			out.print("\t"+mensagem + ":\t");
			return in.nextLine();
		}

		private static String[] ler(String... enunciados) {
			String[] valores = new String[enunciados.length];
			for (int i = 0; i < enunciados.length; i++) {
				valores[i] = ler(enunciados[i]);
			}
			return valores;
		}
	}

}
