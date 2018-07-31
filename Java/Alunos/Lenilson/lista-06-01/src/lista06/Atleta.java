package lista06;

public class Atleta {
	private String cpf;
	private String nome;
	private String modalidade;
	private int numMedalhas;
	
	public Atleta(String cpf, String nome, String modalidade, int numMedalhas) {
		setCpf(cpf);
		setNome(nome);
		setModalidade(modalidade);
		setNumMedalhas(numMedalhas);
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public int getNumMedalhas() {
		return numMedalhas;
	}
	public void setNumMedalhas(int numMedalhas) {
		this.numMedalhas = numMedalhas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Atleta: " + nome + "\n"
				+ "CPF: " + cpf + "\n"
				+ "Modalidade: " + modalidade + "\tNúmero de Medalhas: " + numMedalhas	+ "\n";
	}
	
	
}
