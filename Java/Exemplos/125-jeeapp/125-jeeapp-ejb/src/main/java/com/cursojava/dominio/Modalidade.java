package com.cursojava.dominio;

import java.io.Serializable;

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
@Table(name = "MODALIDADE")
@NamedQueries({
		@NamedQuery(name = "Modalidade.Listar", query = "select m from Modalidade m order by m.descricao")
})
public class Modalidade implements Serializable{

	private static final long serialVersionUID = -6313493842332528150L;
	
	@Id
    @GeneratedValue //(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MODALIDADE", nullable=false)
    private Long id;
	
	@NotEmpty(message="O campo modalidade deve ser preenchido.")
	@NotBlank(message = "O campo modalidade deve ser preenchido.")
    @Size(max = 60, message="O campo modalidade deve possuir no máximo 60 caracteres.")
    @Column(name="DESCRICAO", nullable=false, length=60)
    private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
