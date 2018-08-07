package com.cursojava.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ESTADO")
public class Estado {

	@Id
	@GeneratedValue
	@Column(name = "ID_ESTADO")
	protected Long id;
	@Column(name = "NOME", nullable = false)
	protected String nome;
	@Column(name = "SIGLA")
	protected String sigla;

	@OneToMany(mappedBy = "estado", fetch = FetchType.EAGER)
	protected Set<Cidade> cidades;

	@ManyToOne
	@JoinColumn(name = "ID_PAIS")
	private Pais pais;

	public Estado() {
	}

	public Estado(Long id) {
		this.id = id;
	}

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Set<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(Set<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "\n\t Estado [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", cidades=" + cidades + ", pais="
				+ pais.getNome() + "]";
	}
}
