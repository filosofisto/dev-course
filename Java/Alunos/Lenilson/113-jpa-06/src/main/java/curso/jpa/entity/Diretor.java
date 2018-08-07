package curso.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Diretor extends Funcionario{

	@Column(name="AUXMORADIA")
	private double auxMoradia;

	public double getAuxMoradia() {
		return auxMoradia;
	}

	public void setAuxMoradia(double auxMoradia) {
		this.auxMoradia = auxMoradia;
	}
	
}
