package com.cursojava.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(
	name = "BANCO",
	uniqueConstraints={
			@UniqueConstraint(columnNames={"NOME"}, name="UK_BANCO_NOME"),
			@UniqueConstraint(columnNames={"COD_BANCO"}, name="UK_BANCO_COD_BANCO")
	}
)
@NamedQueries(
		@NamedQuery(name = "Banco.Listar", query = "select b from Banco b order by nome")
)
public class Banco implements Serializable {

	private static final long serialVersionUID = -5438736434913973259L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_BANCO", nullable=false)
    private Long id;

	@NotEmpty(message="O campo nome deve ser preenchido.")
	@NotBlank(message = "O campo nome deve ser preenchido.")
    @Size(max = 55, message="O campo nome deve possuir no máximo 45 caracteres.")
    @Column(name="NOME", nullable=false, length=55)
    private String nome;
	
	@NotNull(message="O campo código do banco deve ser preenchido.")
    @Column(name="COD_BANCO", nullable=false, length=10)
    private String codBanco;

	public Banco() {

	}

	public Banco(Long id) {
		setId(id);
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

	public String getCodBanco() {
		return codBanco;
	}

	public void setCodBanco(String codBanco) {
		this.codBanco = codBanco;
	}
} // fim classe Banco