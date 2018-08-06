package com.javabasico;

public class Veiculo {

	private String placa;
	private String modelo;
	private String fabricante;
	private Integer ano;

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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", modelo=" + modelo + ", fabricante=" + fabricante + ", ano=" + ano + "]";
	}

}
