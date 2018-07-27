package control;

import java.sql.Timestamp;
import java.util.Random;

import static java.lang.System.out;

import model.Conta;
import model.Pessoa;

public class Teste {

	public static void main(String[] args) {
		Conta c = gerarContaAleatoria();
		out.println("\n\t\t Transações realizadas na conta \n" + c.mostrarTransacoes());
		out.println(c.toString());

	}

	private static Conta gerarContaAleatoria() {
		Conta c = new Conta();
		Random r = new Random();
		c.setNumero(r.nextLong());
		c.setDono(gerarPessoaAleatoria());
		int count = r.nextInt(1000) + 1;

		while (count > 0) {
			switch (r.nextInt(3)) {
			case 0:
				c.deposita(r.nextDouble() * r.nextInt(count) + 1);
				break;
			case 1:
				c.retira(r.nextDouble() * r.nextInt(count) + 1);
				break;
			case 2:
				c.transfere(r.nextDouble() * r.nextInt(count) + 1, new Conta());
				break;
			default:

			}
			count--;
		}
		return c;
	}

	private static Pessoa gerarPessoaAleatoria() {
		Pessoa p = new Pessoa();

		Random r = new Random();
		switch (r.nextInt(3)) {
		case 0:
			p.setNome("Fulano");
			break;
		case 1:
			p.setNome("Ciclano");
			break;
		case 2:
			p.setNome("Deltrano");
			break;
		default:
			p.setNome("Ninguem");
		}

		p.setCpf(r.nextInt(100000000)+100000);
		p.setRg(r.nextInt(1000000000)+100000 + "-" + r.nextInt(10));

		p.setNascimento(new Timestamp(r.nextLong()));

		return p;
	}

}
