package lista06;

public class Atleta implements Comparable<Atleta> {

	private String nome;
	private String cpf;
	private String modalidade;
	private int numeroMedalhas;

	public Atleta(String nome, String cpf, int numeroMedalhas) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.numeroMedalhas = numeroMedalhas;
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

	@Override
	public int compareTo(Atleta otherAtleta) {
		return getNome().toUpperCase().compareTo(otherAtleta.getNome().toUpperCase());
	}

}
