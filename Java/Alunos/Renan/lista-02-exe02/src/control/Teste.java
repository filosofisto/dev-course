package control;

import static java.lang.System.out;

public class Teste {

	public static void main(String[] args) {
		out.println("2. Modele uma estrutura de objetos capaz de representar Pessoas, Funcionarios, Gerentes e Diretores."
				+ "\n Considere as informações: \r\n" + 
				"•	Uma pessoa possui nome e idade\r\n" + 
				"•	Um funcionário é uma pessoa, mas representa uma pessoa que trabalha, portanto possui um número de matrícula e um salário base\r\n" + 
				"•	O cálculo do salário de um funcionário é o salário base mais 1% por cada ano trabalhado, por exemplo, se ele tem 5 anos de empresa então seu salário final será o salário base mais 5%\r\n" + 
				"•	Um gerente é um funcionário, porém devido a sua responsabilidade adicional pelo cargo de gerência seu salário é calculado da mesma forma que de um funcionário qualquer, porém adicionando-se mais R$ 2.500,00\r\n" + 
				"•	Um diretor é também um funcionário, possuindo o mesmo cálculo de salário de um gerente, mais um auxílio moradia no valor de R$ 3.500,00\r\n" + 
				"");

	}

	
	private static int args_index = 0;

	private static String getNextArg(String[] args) {
		return args[args_index++];

	}

	
}
