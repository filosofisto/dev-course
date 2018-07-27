package control;

import static java.lang.System.out;

import java.util.Random;

import model.Diretor;
import model.Funcionario;
import model.Gerente;
import model.Pessoa;

public class Teste {

	public static void main(String[] args) {
		out.println(
				"2. Modele uma estrutura de objetos capaz de representar Pessoas, Funcionarios, Gerentes e Diretores."
						+ "\n Considere as informações: \r\n" + "•	Uma pessoa possui nome e idade\r\n"
						+ "•	Um funcionário é uma pessoa, mas representa uma pessoa que trabalha, portanto possui um número de matrícula e um salário base\r\n"
						+ "•	O cálculo do salário de um funcionário é o salário base mais 1% por cada ano trabalhado, por exemplo, se ele tem 5 anos de empresa então seu salário final será o salário base mais 5%\r\n"
						+ "•	Um gerente é um funcionário, porém devido a sua responsabilidade adicional pelo cargo de gerência seu salário é calculado da mesma forma que de um funcionário qualquer, porém adicionando-se mais R$ 2.500,00\r\n"
						+ "•	Um diretor é também um funcionário, possuindo o mesmo cálculo de salário de um gerente, mais um auxílio moradia no valor de R$ 3.500,00\r\n"
						+ "");

		Pessoa p;
		Funcionario f;
		Gerente g;
		Diretor d;

		try {
			p = new Pessoa(getNextArg(args), Integer.parseInt(getNextArg(args)));
		} catch (Exception e) {
			Random r = new Random();
			p = new Pessoa("Pessoa", r.nextInt(125));
		}

		try {
			f = new Funcionario(getNextArg(args), Integer.parseInt(getNextArg(args)),
					Integer.parseInt(getNextArg(args)), Double.parseDouble(getNextArg(args)),
					Integer.parseInt(getNextArg(args)));
		} catch (Exception e) {
			Random r = new Random();
			f = new Funcionario("Funcionário", r.nextInt(125), r.nextInt(100000000), r.nextDouble() + r.nextInt(5000),
					r.nextInt(25) + 1);
		}

		try {
			g = new Gerente(getNextArg(args), Integer.parseInt(getNextArg(args)), Integer.parseInt(getNextArg(args)),
					Double.parseDouble(getNextArg(args)), Integer.parseInt(getNextArg(args)));
		} catch (Exception e) {
			Random r = new Random();
			g = new Gerente("Gerente", r.nextInt(125), r.nextInt(100000000), r.nextDouble() + r.nextInt(5000),
					r.nextInt(25) + 1);
		}

		try {
			d = new Diretor(getNextArg(args), Integer.parseInt(getNextArg(args)), Integer.parseInt(getNextArg(args)),
					Double.parseDouble(getNextArg(args)), Integer.parseInt(getNextArg(args)));
		} catch (Exception e) {
			Random r = new Random();
			d = new Diretor("Diretor", r.nextInt(125), r.nextInt(100000000), r.nextDouble() + r.nextInt(5000),
					r.nextInt(25) + 1);
		}

		out.println(p.toString());
		out.println(f.toString());
		out.println("\t Salário Calculado:\t" + f.calcularSalario() + "\n");
		out.println(g.toString());
		out.println("\t Salário Calculado:\t" + g.calcularSalario() + "\n");
		out.println(d.toString());
		out.println("\t Salário Calculado:\t" + d.calcularSalario() + "\n");

	}

	private static int args_index = 0;

	private static String getNextArg(String[] args) {
		return args[args_index++];

	}

}
