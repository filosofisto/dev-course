package com.cursojava.dominio;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PESSOA")
@NamedQueries({ @NamedQuery(name = "Pessoa.Listar", query = "select p from Pessoa p order by p.nome") })
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue // (strategy=GenerationType.IDENTITY)
	@Column(name = "ID_PESSOA", nullable = false)
	private Long id;

	@NotEmpty(message = "O campo nome deve ser preenchido.")
	@NotBlank(message = "O campo nome deve ser preenchido.")
	@Size(max = 120, message = "O campo nme deve possuir no máximo 120 caracteres.")
	@Column(name = "NOME", nullable = false, length = 120)
	private String nome;

//	@Column(name = "NASCIMENTO"/* , nullable=false */)
//	private Timestamp nascimento;
//
//	@Column(name = "ID_AEROPORTO")
//	private Aeroporto aeroportoFavorito;

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

}
