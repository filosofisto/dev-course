package junit01;

public class Nadador {
	private String nome;
	private int idade;
	
	public Nadador(String nome, int idade) {
		setNome(nome);
		setIdade(idade);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String categoria () throws Exception {
		if (idade < 5) {
			throw new Exception("Inexistente");
		} else if (idade <= 7) {
			return "Infantil A";
		} else if (idade <= 10) {
			return "Infantil B";
		} else if (idade <= 13) {
			return "Juvenil A";
		} else if (idade <= 17) {
			return "Juvenil B";
		} else {
			return "Adulto";
		}
	}
}
