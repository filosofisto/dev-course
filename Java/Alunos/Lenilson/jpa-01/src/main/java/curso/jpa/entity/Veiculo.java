package curso.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB003_VEICULO")
public class Veiculo {
	
	@Id 
	@Column(name="PLACA", unique=true, nullable=false)
	private String placa;
	
	@Column(name="MODELO", nullable=false)
	private String modelo;
	
	@Column(name="FABRICANTE", nullable=false)
	private String fabricante;
	
	@Column(name="ANO")
	private int ano;
	
	
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
