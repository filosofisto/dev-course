package com.javabasico;

public class Veiculo {

	protected String placa;
	protected String modelo;
	protected String fabricante;
	protected int ano;

	public Veiculo(String placa, String modelo, String fabricante, int ano) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.ano = ano;
	}

	public Veiculo() {
		// TODO Auto-generated constructor stub
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", modelo=" + modelo + ", fabricante=" + fabricante + ", ano=" + ano + "]";
	}

	
	
}
