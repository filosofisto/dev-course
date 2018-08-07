package curso.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="DIRETOR")
public class Diretor extends Funcionario{

	
	@Column(name = "AUXILIO_MORADIA")
	private Double auxilioMoradia;

	public Double getAuxilioMoradia() {
		return auxilioMoradia;
	}

	public void setAuxilioMoradia(Double auxilioMoradia) {
		this.auxilioMoradia = auxilioMoradia;
	}
	
	

}
