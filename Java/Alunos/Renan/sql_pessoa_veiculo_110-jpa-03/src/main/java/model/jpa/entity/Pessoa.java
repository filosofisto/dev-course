package model.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class Pessoa {

	@Id
	@GeneratedValue
	@Column(name = "ID_PESSOA")
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
	// @OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
	// @OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_VEICULO")
	private Veiculo veiculo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", veiculo=" + veiculo + "]";
	}

	

}
