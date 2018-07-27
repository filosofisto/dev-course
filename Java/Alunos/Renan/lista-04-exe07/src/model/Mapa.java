package model;

import java.util.ArrayList;

public class Mapa {	
	
	private static int rodada = 0;
	
	private static int[][] tabuleiro;
	
	private static ArrayList<Personagem> pecas;
	
	
	//	As peças agem por conta própria a cada rodada
	public void acao() {
		
		Mapa.rodada++;
	}
	
	public int getRodadaAtual() {
		return Mapa.rodada; 
	}
	
}
