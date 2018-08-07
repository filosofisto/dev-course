package model.entity;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ESTADO")
public class Estado {

	@Id
	@GeneratedValue
	@Column(name = "ID_ESTADO")
	protected long id;
	@Column(name = "NOME", nullable = false)
	protected String nome;
	@Column(name = "SIGLA")
	protected String sigla;
	
	@OneToMany(mappedBy = "estado")
	protected Set<Cidade> cidades;
	
	@ManyToOne
    @JoinColumn(name="ID_PAIS", nullable=false)
    private Pais pais;

	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
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
		return "\n\t Estado [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", cidades=" + cidades + ", pais=" + pais.getNome()
				+ "]";
	}
}
