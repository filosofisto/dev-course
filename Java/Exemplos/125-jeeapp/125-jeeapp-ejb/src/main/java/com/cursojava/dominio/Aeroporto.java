package com.cursojava.dominio;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "AEROPORTO")
@NamedQueries({
		@NamedQuery(name = "Aeroporto.Listar", query = "select a from Aeroporto a order by a.nome")
})
public class Aeroporto implements Serializable {

	private static final long serialVersionUID = -8072609416565074635L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_AEROPORTO", nullable=false)
    private Long id;

	@NotEmpty(message="O campo aeroporto deve ser preenchido.")
	@NotBlank(message = "O campo aeroporto deve ser preenchido.")
    @Size(max = 60, message="O campo aeroporto deve possuir no máximo 60 caracteres.")
    @Column(name="NOME", nullable=false, length=60)
    private String nome;

	@NotEmpty(message="O campo cidade deve ser preenchido.")
	@Size(max = 60, message="O campo cidade deve possuir no máximo 60 caracteres.")
	@Column(name="CIDADE", nullable=false, length=60)
	private String cidade;
	
    @Size(max = 8, message="O campo Sigla deve possuir no máximo 8 caracteres.")
	@Column(name="SIGLA", nullable=true, length=8)
    private String sigla;

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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}