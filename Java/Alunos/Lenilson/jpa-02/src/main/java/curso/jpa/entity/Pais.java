package curso.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB001_PAIS")
public class Pais {

	@Id 
	@GeneratedValue
	@Column(name="ID_PAIS")
	private int id;
	
	@Column(name="NOME", nullable=false)
	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="ID_ESTADO")
	private List<Estado> estados = new ArrayList<Estado>();

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

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", estados=" + estados + "]";
	}
	
	
}
