package com.cursojava.entity;

import javax.persistence.*;

@Entity
@Table(name="CIDADE")
/*
@NamedQueries({
		@NamedQuery(
				name = "Cidade.Todas",
				query = "select new Cidade(c.nome, c.habitantes) from Cidade c order by c.nome"
		)
})
*/
public class Cidade {

	@Id
	@GeneratedValue
	@Column(name = "ID_CIDADE")
	protected long id;
	@Column(name = "NOME", nullable = false)
	protected String nome;
	@Column(name = "HABITANTES", nullable = false)
	protected int habitantes;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_ESTADO")
    private Estado estado;

	public Cidade() {
	}

	public Cidade(String nome, int habitantes) {
		this.nome = nome;
		this.habitantes = habitantes;
	}

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
		return "\n\t Cidade [id=" + id + ", nome=" + nome + ", habitantes=" + habitantes + ", estado=" + (estado!=null ? estado.getNome(): "") + "]";
	}
	
	
}
