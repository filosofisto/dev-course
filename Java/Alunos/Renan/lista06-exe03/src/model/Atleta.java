package model;

public class Atleta extends Pessoa {

	protected Modalidade modalidade;
	protected int medalhasDeOuro;
	protected int medalhasDePrata;
	protected int medalhasDeBronze;

	public Atleta() {
	}

	public Atleta(String nome, String cpf, Modalidade modalidade, int medalhasDeOuro, int medalhasDePrata,
				  int medalhasDeBronze) {
		super(nome, cpf);
		this.modalidade = modalidade;
		this.medalhasDeOuro = medalhasDeOuro;
		this.medalhasDePrata = medalhasDePrata;
		this.medalhasDeBronze = medalhasDeBronze;
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

	public int getMedalhasDeOuro() {
		return medalhasDeOuro;
	}

	public void setMedalhasDeOuro(int medalhasDeOuro) {
		this.medalhasDeOuro = medalhasDeOuro;
	}

	public int getMedalhasDePrata() {
		return medalhasDePrata;
	}

	public void setMedalhasDePrata(int medalhasDePrata) {
		this.medalhasDePrata = medalhasDePrata;
	}

	public int getMedalhasDeBronze() {
		return medalhasDeBronze;
	}

	public void setMedalhasDeBronze(int medalhasDeBronze) {
		this.medalhasDeBronze = medalhasDeBronze;
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
		return super.toString()+ " Atleta [modalidade=" + modalidade + ", medalhasDeOuro=" + medalhasDeOuro + ", medalhasDePrata="
				+ medalhasDePrata + ", medalhasDeBronze=" + medalhasDeBronze + "]";
	}


	
	

}
