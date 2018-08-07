package curso.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB002_PESSOA")
public class Pessoa {

	@Id 
	@GeneratedValue
	@Column(name="ID_PESSOA")
	private Long id;
	
	@Column(name="NOME", nullable=false, length=50)
	private String nome;
	
	//@OneToOne(fetch=FetchType.LAZY)
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ENDERECO")
	private Endereco endereco;

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
}
