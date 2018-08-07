package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CIDADE")
public class Cidade {

	@Id
	@GeneratedValue
	@Column(name = "ID_CIDADE")
	protected long id;
	@Column(name = "NOME", nullable = false)
	protected String nome;
	@Column(name = "HABITANTES", nullable = false)
	protected int habitantes;
	
	@ManyToOne
    @JoinColumn(name="ID_ESTADO")
    private Estado estado;

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

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "\n\t Cidade [id=" + id + ", nome=" + nome + ", habitantes=" + habitantes + ", estado=" + estado.getNome() + "]";
	}
	
	
}
