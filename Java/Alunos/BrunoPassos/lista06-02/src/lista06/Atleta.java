package lista06;

/*
 * 1.	Dado a classe Atleta que contém as seguintes informações: CPF, Nome, Modalidade e Número de Medalhas, 
 * como armazenar objetos deste tipo sem haver repetição de elementos?
 */

public class Atleta {

	private String nome;
	private String cpf;
	private String modalidade;
	private int numeroMedalhas;

	public Atleta(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public int getNumeroMedalhas() {
		return numeroMedalhas;
	}

	public void setNumeroMedalhas(int numeroMedalhas) {
		this.numeroMedalhas = numeroMedalhas;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", cpf=" + cpf;
	}


}
