package lista04.personagems;

import lista04.itemsPersonagem.EnergiaPrana;
import lista04.itemsPersonagem.StatusOperario;

public class Operario extends Personagem{
	
	private EnergiaPrana energiaPrana;
	private StatusOperario status;

	public EnergiaPrana getEnergiaPrana() {
		return energiaPrana;
	}

	public void setEnergiaPrana(EnergiaPrana energiaPrana) {
		this.energiaPrana = energiaPrana;
	}

	public StatusOperario getStatus() {
		return status;
	}

	public void setStatus(StatusOperario status) {
		this.status = status;
	}
	
	

}
