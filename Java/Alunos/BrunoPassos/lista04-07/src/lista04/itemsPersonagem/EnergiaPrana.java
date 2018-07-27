package lista04.itemsPersonagem;

public class EnergiaPrana {

	private int energia;
	private Mapa mapa;

	public EnergiaPrana(int pontoX, int pontoY) {
		this.energia = 100;
		mapa.setPontoX(pontoX);
		mapa.setPontoy(pontoY);
	}
	
	public void retiraEnergia(int ataque){
		assert (ataque < 0) : "Não pode ser menor do que 0";
		this.energia -= ataque;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
	

}
