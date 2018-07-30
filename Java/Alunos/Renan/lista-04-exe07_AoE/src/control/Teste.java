package control;

import model.Lado;
import model.Mapa;
import model.Soldado;

public class Teste {

	public static void main(String[] args) {
		Mapa m =  new Mapa(100);
		Soldado s = new Soldado(Lado.ALIADO);
		
		m.adicionarPersonagem(s,s,s,s,s,s,s);

	}

}
