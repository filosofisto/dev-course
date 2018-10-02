package model.entity;

import java.io.Serializable;
import java.util.Arrays;

import model.enums.Genero;
import model.enums.Modalidade;

public class Atleta extends Pessoa implements Comparable<Atleta>, Serializable {

    private static final long serialVersionUID = 1L;

    // ==========================================================================================================================================================================================
    // Atributos
    // ==========================================================================================================================================================================================

    protected Modalidade modalidade;

    protected int[] medalhas;

    // ==========================================================================================================================================================================================
    // Construtores
    // ==========================================================================================================================================================================================

    public Atleta() {
	super();
	this.medalhas = new int[3];
    }

    public Atleta(String nome, String cpf, Genero genero, Modalidade modalidade, int medalhasDeOuro,
	    int medalhasDePrata, int medalalhasDeBronze) {
	super(nome, cpf, genero);
	this.modalidade = modalidade;
	this.medalhas = new int[] { medalhasDeOuro, medalhasDePrata, medalalhasDeBronze };
    }

    // ==========================================================================================================================================================================================
    // Getters & Setters
    // ==========================================================================================================================================================================================

    public Modalidade getModalidade() {
	return this.modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
	this.modalidade = modalidade;
    }

    public int[] getMedalhas() {
	return this.medalhas;
    }

    public void setMedalhas(int[] medalhas) {
	this.medalhas = medalhas;
    }

    public int getMedalhasDeOuro() {
	return medalhas[0];
    }

    public void setMedalhasDeOuro(int medalhasDeOuro) {
	this.medalhas[0] = medalhasDeOuro;
    }

    public int getMedalhasDePrata() {
	return medalhas[1];
    }

    public void setMedalhasDePrata(int medalhasDePrata) {
	this.medalhas[1] = medalhasDePrata;
    }

    public int getMedalhasDeBronze() {
	return medalhas[2];
    }

    public void setMedalhasDeBronze(int medalhasDeBronze) {
	this.medalhas[2] = medalhasDeBronze;
    }

    // ==========================================================================================================================================================================================
    // Comparações
    // ==========================================================================================================================================================================================

    @Override
    public int compareTo(Atleta o) {

	int ret = 0;

	ret = this.getNome().compareTo(o.getNome()); // Organiza por Nome

	if (ret == 0) {
	    ret = this.getModalidade().compareTo(o.getModalidade()); // Organiza por Modalidade

	    if (ret == 0) {

		ret = this.getCpf().compareTo(o.getCpf()); // Organiza por CPF
	    }
	}

	return ret;
    }

    // ==========================================================================================================================================================================================
    // Sobrecargas de Métodos da Classe Object
    // ==========================================================================================================================================================================================

    @Override
    public String toString() {

	return super.toString() + " Atleta [modalidade=" + this.modalidade + ", medalhas="
		+ Arrays.toString(this.medalhas) + "]";
    }

}
