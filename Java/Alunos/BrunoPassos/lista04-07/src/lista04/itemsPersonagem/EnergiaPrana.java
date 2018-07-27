package lista04.itemsPersonagem;

public class EnergiaPrana {

	private int energia;

	public EnergiaPrana() {
		this.energia = 100;
	}
	
	public EnergiaPrana(int energia) {
		this.energia = energia;
	}
	
	public void retiraEnergia(int ataque){
		assert (ataque < 0) : "Nao pode ser menor do que 0";
		
		this.energia -= ataque;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}
}
