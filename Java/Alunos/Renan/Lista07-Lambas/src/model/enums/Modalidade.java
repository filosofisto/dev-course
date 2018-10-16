package model.enums;

public enum Modalidade implements Comparable<Modalidade> {
    CORRIDA("Corrida"), FUTEBOL("Futebol"), NATACAO("Natação"), SALTO("Salto"), XADREZ("Xadrez");

    String nome;

    Modalidade(String nome) {
	this.nome = nome;
    }

    public String getNome() {
	return this.nome;
    }

    public static Modalidade getModalidade(String texto) {

	if (texto.contains(Modalidade.CORRIDA.getNome()))
	    return Modalidade.CORRIDA;

	if (texto.contains(Modalidade.FUTEBOL.getNome()))
	    return Modalidade.FUTEBOL;

	if (texto.contains(Modalidade.NATACAO.getNome()))
	    return Modalidade.NATACAO;

	if (texto.contains(Modalidade.SALTO.getNome()))
	    return Modalidade.SALTO;

	if (texto.contains(Modalidade.XADREZ.getNome()))
	    return Modalidade.XADREZ;

	return null;

    }

}
