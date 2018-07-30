package control;

import java.awt.Point;

import model.Lado;
import model.Mapa;
import model.Personagem;
import model.Soldado;

public class Teste {

	public static void main(String[] args) {
		Mapa m =  new Mapa(100);
		Soldado s = new Soldado(Lado.ALIADO, new Point(1,1));
		
		m.adicionarPersonagem(s,s,s,s,s,s,s);
		System.out.println(m.getQuantidadeDePesonagens());
		System.out.println(Personagem.quantidadeDeInstancias());
	}

}
