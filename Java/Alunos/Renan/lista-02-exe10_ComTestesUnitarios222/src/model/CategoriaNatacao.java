package model;

public enum CategoriaNatacao {
	INFANTIL_A("Infantil A"), INFANTIL_B("Infantil B"), JUVENIL_A("Juvenil A"), JUVENIL_B("Juvenil B"), ADULTO("Adulto");

	String nome;
	
	private CategoriaNatacao(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
}
