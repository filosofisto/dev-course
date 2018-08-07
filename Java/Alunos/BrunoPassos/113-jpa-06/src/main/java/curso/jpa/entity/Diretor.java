package curso.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Diretor extends Funcionario {

	@Column(name="AUXILIO_MORADIA")
	private double auxilioMoradia;

	public double getAuxilioMoradia() {
		return auxilioMoradia;
	}

	public void setAuxilioMoradia(double auxilioMoradia) {
		this.auxilioMoradia = auxilioMoradia;
	}


	

}
