package curso.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB002_ESTADO")
public class Estado {
	@Id 
	@GeneratedValue
	@Column(name="ID_ESTADO")
	private int id;
	
	@Column(name="NOME", nullable=false)
	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="estado", orphanRemoval=true)
	@JoinColumn(name="ID_CIDADE")
	private List<Cidade> cidades = new ArrayList<Cidade>();
	
	@ManyToOne
	@JoinColumn(name="ID_PAIS")
	private Pais pais;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nome=" + nome + ", cidades=" + cidades + ", pais=" + pais + "]";
	}
	
	
}
