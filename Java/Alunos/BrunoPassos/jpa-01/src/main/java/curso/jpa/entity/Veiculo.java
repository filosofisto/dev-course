package curso.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB003_VEICULO")
public class Veiculo {

	@Id
	@GeneratedValue
	@Column(name="ID_VEICULO")
	private Long id;

	@Column(name="PLACA", unique = true)
	private String placa;
	
	@Column(name="MODELO", nullable=false)
	private String modelo;

	@Column(name="FABRICANTE", nullable=false)
	private String fabricante;

	@Column(name="ANO", nullable=false)
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
		return "Veiculo{" +
				"id=" + id +
				", placa='" + placa + '\'' +
				", modelo='" + modelo + '\'' +
				", fabricante='" + fabricante + '\'' +
				", ano=" + ano +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
