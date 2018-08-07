package com.cursojava.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PAIS")
public class Pais {

	@Id
	@GeneratedValue
	@Column(name = "ID_PAIS")
	protected long id;
	@Column(name = "NOME", nullable = false)
	protected String nome;
	@Column(name = "SIGLA")
	protected String sigla;

	@OneToMany(mappedBy = "pais")
	protected Set<Estado> estados;

	public long getId() {
		return id;
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

	public Set<Estado> getEstados() {
		return estados;
	}

	public void setEstados(Set<Estado> estados) {
		this.estados = estados;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", estados=" + estados + "]";
	}

}
