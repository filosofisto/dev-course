package com.cursojava;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO")
public class Estado {

	@Id
	@Column(name = "ID_ESTADO")
	private String nomeEstado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estado",cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CIDADE")
	private List<Cidade> cidades;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_PAIS")
	private Pais pais;

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
