package lista04;

public class Main {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario("Bruno", 21, 1122, 1200,10);// NOME, IDADE, MATRICULA, SALARIOBASE,ANOS EMPRESA
		Gerente gerente = new Gerente("Joao", 21, 1122, 2000, 10); // NOME, IDADE, MATRICULA, SALARIOBASE,ANOS EMPRESA
		Diretor diretor = new Diretor("Ricardo", 40, 3322, 5000, 10); // 5500 + 2500 + 3500;s

		
		System.out.println("GERENTE: " + gerente.calculaSalario());
		System.out.println("FUNCIONARIO: " + funcionario.calculaSalario());
		System.out.println("DIRETOR: " + diretor.calculaSalario());
		
		
		
	}
}
