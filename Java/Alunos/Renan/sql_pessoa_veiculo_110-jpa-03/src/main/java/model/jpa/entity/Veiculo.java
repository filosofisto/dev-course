package model.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "VEICULO")
public class Veiculo {

	@Id
	@GeneratedValue
	@Column(name = "ID_VEICULO")
	private long id;

	@Column(name = "PLACA", nullable = false)
	private String placa;

	@Column(name = "MODELO")
	private String modelo;

	@Column(name = "FABRICANTE")
	private String fabricante;

	@Column(name = "ANO")
	private int ano;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModeol() {
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
		return "Veiculo [id=" + id + ", placa=" + placa + ", modelo=" + modelo + ", fabricante=" + fabricante + ", ano="
				+ ano + "]";
	}

}
