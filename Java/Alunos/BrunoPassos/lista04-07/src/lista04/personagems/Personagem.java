
package lista04.personagems;

import lista04.itemsPersonagem.EnergiaPrana;
import lista04.itemsPersonagem.Mapa;

public abstract class Personagem {

	private EnergiaPrana energiaPrana;
	private Mapa mapa;
	
	// locomover de um ponto a outro
	
	public void locomover(int pontoX, int pontoY) {
		this.mapa = new Mapa(pontoX, pontoY);
	}
	
	// ataca personagem
	//	public abstract void ataca(Personagem personagem);
		
	public EnergiaPrana getEnergiaPrana() {
		return energiaPrana;
	}

	public void setEnergiaPrana(EnergiaPrana energiaPrana) {
		this.energiaPrana = energiaPrana;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

}
