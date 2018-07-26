package poo;

public class Automovel implements Comparable<Automovel> {

	private String placa;
	
	public Automovel(String placa) {
		this.placa = placa;
	}

	@Override
	public int compareTo(Automovel o) {
		return placa.compareTo(o.placa);
	}
	
	public String getPlaca() {
		return placa;
	}
}
