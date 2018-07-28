
package lista04.personagems;

import lista04.itemsPersonagem.EnergiaPrana;
import lista04.itemsPersonagem.Posicao;

public abstract class Personagem {

	private EnergiaPrana energiaPrana;
	private Posicao posicao;
	
	// locomover de um ponto a outro
	
	public void locomover(int pontoX, int pontoY) {
		this.posicao = new Posicao(pontoX, pontoY);
	}
	
	// ataca personagem
	//	public abstract void ataca(Personagem personagem);
		
	public EnergiaPrana getEnergiaPrana() {
		return energiaPrana;
	}

	public void setEnergiaPrana(EnergiaPrana energiaPrana) {
		this.energiaPrana = energiaPrana;
	}

	public Posicao getMapa() {
		return posicao;
	}

	public void setMapa(Posicao mapa) {
		this.posicao = mapa;
	}

}
