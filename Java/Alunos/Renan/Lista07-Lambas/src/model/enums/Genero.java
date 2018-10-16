package model.enums;

public enum Genero{
    MASCULINO("Masculino"), FEMININO("Feminino"), MISTO("Misto"), AMBOS("Ambos"), INDEFINIDO("Indefinido");

    String nome;

    Genero(String nome) {
	this.nome = nome;
    }

    public String getNome() {
	return this.nome;
    }

}
