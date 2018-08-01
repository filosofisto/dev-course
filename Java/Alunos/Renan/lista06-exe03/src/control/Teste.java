package control;

import static java.lang.System.out;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import model.Atleta;
import model.Modalidade;

public class Teste {

	public static void main(String[] args) {
		Set<Atleta> atletas = new TreeSet<Atleta>();

		Random r = new Random();

		int n = r.nextInt(10) + 10;

		do {

			String nome = null;

			switch (r.nextInt(4)) { // Sorteio de 0 a 3
			case 0:
				nome = "Fulano";
				break;
			case 1:
				nome = "Beltrano";
				break;
			case 2:
				nome = "Ciclano";
				break;
			case 3:
				nome = "Deltrano";
				break;
			}

			String cpf = String.valueOf(r.nextInt(n));

			Modalidade modalidade = null;

			switch (r.nextInt(9)) {
			case 0:
				modalidade = Modalidade.ARREMECOS_E_LANCAMENTOS;
				break;
			case 1:
				modalidade = Modalidade.CORRIDA_COM_OBSTACULOS;
				break;
			case 2:
				modalidade = Modalidade.CORRIDA_DE_FUNDO;
				break;
			case 3:
				modalidade = Modalidade.CORRIDA_DE_MEIO_FUNDO;
				break;
			case 4:
				modalidade = Modalidade.CORRIDA_DE_PISTA;
				break;
			case 5:
				modalidade = Modalidade.MARATONA;
				break;
			case 6:
				modalidade = Modalidade.REVEZAMENTO;
				break;
			case 7:
				modalidade = Modalidade.SALTOS_EM_ALTURA;
				break;
			case 8:
				modalidade = Modalidade.SALTOS_EM_DISTANCIA;
				break;
			}

			int[] medalhas = new int[] { r.nextInt(n), r.nextInt(n), r.nextInt(n) };
			Atleta atleta = new Atleta(nome, cpf, modalidade, medalhas[0], medalhas[1], medalhas[2]);

			out.println(atleta.toString());
			atletas.add(atleta);

			System.gc();

			n--;
		} while (n > 0);

		out.println("\n Atletas adicionados ao Set: ");

		for (Atleta atleta : atletas) {
			try {
				out.println(atleta.toString());
			} catch (NullPointerException e) {
				out.println("null");
			}
		}

		out.println("\n Atletas no set: " + atletas.size());
		out.println("\n O critério para diferenciar uma Atleta do outro é o documento de identidade (CPF).");

	}

}
