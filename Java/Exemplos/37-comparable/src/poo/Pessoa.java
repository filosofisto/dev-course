package poo;

public class Pessoa implements Comparable<Pessoa> {

	private String nome;
	
	private String cpf;

	public Pessoa(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
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

	@Override
	public int compareTo(Pessoa o) {
		return getNome().compareTo(o.getNome());
	}
	
	
}
