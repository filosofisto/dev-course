package control;

import static model.Console.exibir;
import static model.Console.ler;
import static model.Console.confirmar;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.entity.Cidade;
import model.entity.Estado;
import model.entity.Pais;

public class Main {

	protected static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-01");
	protected static EntityManager entityManager = factory.createEntityManager();
	protected static EntityTransaction transaction = entityManager.getTransaction();

	public static void main(String[] args) {
		exibir("Exercício JPA de 1 para N", "Um País tem vários Estados, e um Estado tem várias Cidades.");

		inserirGeografia();
		procurarPais();
	}

	private static void inserirGeografia() {
		try {
			transaction.begin();

			exibir("Inserção de Geografia");
			List<Pais> paises = preencherPaises();

			exibir(true, "Os seguintes dados serão inseridos no banco de dados: ", paises.toString());
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	private static void procurarPais() {
		try {
			transaction.begin();

			exibir("Pesquisa de País");
			Pais p = entityManager.find(Pais.class, new Long(Integer.parseInt(ler("ID do Páis:"))));

			exibir("Páis encontrado: ", p.toString());

			if (confirmar("Deseja excluir o país " + p.getNome() + "do mapa?")) {
				entityManager.remove(p);
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	private static List<Pais> preencherPaises() {
		List<Pais> paises = new ArrayList<Pais>();

		do {
			exibir((paises.size() + 1) + "º País");
			Pais p = new Pais();

			p.setNome(ler("Nome"));
			p.setEstados(preencherEstados(p));

			paises.add(p);

			entityManager.persist(p);

			exibir("O País " + p.getNome() + " foi adicionado a coleção ");

		} while (confirmar("Gostaria de inserir mais um País?"));

		return paises;
	}

	private static Set<Estado> preencherEstados(Pais pais) {
		Set<Estado> estados = new LinkedHashSet<Estado>();

		do {
			exibir((estados.size() + 1) + "º Estado");
			Estado e = new Estado();

			e.setPais(pais);
			e.setNome(ler("Nome"));
			e.setCidades(preencherCidades(e));
			estados.add(e);

			entityManager.persist(e);

			exibir("O Estado " + e.getNome() + " foi adicionado ao País " + pais.getNome() + ".");

		} while (confirmar("Gostaria de inserir mais um Estado ao País " + pais.getNome() + "?"));

		return estados;
	}

	private static Set<Cidade> preencherCidades(Estado estado) {
		Set<Cidade> cidades = new LinkedHashSet<Cidade>();

		do {
			exibir((cidades.size() + 1) + "º Cidade");
			Cidade c = new Cidade();

			c.setEstado(estado);
			c.setNome(ler("Nome"));
			c.setHabitantes(Integer.parseInt(ler("Quantidade de Habitantes")));
			cidades.add(c);

			entityManager.persist(c);

			exibir("A Cidade " + c.getNome() + " foi adicionada ao Estado " + estado.getNome() + ".");

		} while (confirmar("Gostaria de inserir mais uma Cidade ao Estado " + estado.getNome() + "?"));

		return cidades;
	}

}
