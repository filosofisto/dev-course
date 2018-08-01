package model;

public class Atleta extends Pessoa {

	protected Modalidade modalidade;
	protected int medalhas_de_ouro;
	protected int medalhas_de_prata;
	protected int medalhas_de_bronze;

	public Atleta() {
	}

	public Atleta(String nome, String cpf, Modalidade modalidade, int medalhas_de_ouro, int medalhas_de_prata,
			int medalhas_de_bronze) {
		super(nome, cpf);
		this.modalidade = modalidade;
		this.medalhas_de_ouro = medalhas_de_ouro;
		this.medalhas_de_prata = medalhas_de_prata;
		this.medalhas_de_bronze = medalhas_de_bronze;
	}

	public Atleta(String nome, String cpf, Modalidade modalidade) {
		super(nome, cpf);
		this.modalidade = modalidade;
	}

	public Atleta(String nome, String cpf) {
		super(nome, cpf);
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public int getMedalhas_de_ouro() {
		return medalhas_de_ouro;
	}

	public void setMedalhas_de_ouro(int medalhas_de_ouro) {
		this.medalhas_de_ouro = medalhas_de_ouro;
	}

	public int getMedalhas_de_prata() {
		return medalhas_de_prata;
	}

	public void setMedalhas_de_prata(int medalhas_de_prata) {
		this.medalhas_de_prata = medalhas_de_prata;
	}

	public int getMedalhas_de_bronze() {
		return medalhas_de_bronze;
	}

	public void setMedalhas_de_bronze(int medalhas_de_bronze) {
		this.medalhas_de_bronze = medalhas_de_bronze;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+ " Atleta [modalidade=" + modalidade + ", medalhas_de_ouro=" + medalhas_de_ouro + ", medalhas_de_prata="
				+ medalhas_de_prata + ", medalhas_de_bronze=" + medalhas_de_bronze + "]";
	}

	@Override
	public int compareTo(Pessoa o) {
		
		return this.nome.compareTo(o.getNome());
	}
	
	

}
