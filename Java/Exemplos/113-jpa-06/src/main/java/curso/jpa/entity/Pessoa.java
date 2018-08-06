package curso.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="TB001_PESSOA")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TP_PESSOA", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("P")
public class Pessoa {

	@Id 
	@GeneratedValue
	@Column(name="ID_PESSOA")
	private Long id;
	
	@Column(name="NOME", nullable=false)
	private String nome;
	
	@Column(name="TP_PESSOA", length=1, nullable=false, insertable=false, updatable=false)
	private String tipoPessoa;
	
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
	
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public boolean isPessoa() {
		return getTipoPessoa().equals("P");
	}
}
