package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Mapa {

	private int[] area = new int[2];

	private ArrayList<Personagem> aliados;
	private ArrayList<Personagem> inimigos;

	public Mapa(int tamanho_x, int tamanho_y) {
		this.area = new int[] { tamanho_x, tamanho_y };
	}

	public Mapa(int tamanho_lado) {
		this(tamanho_lado, tamanho_lado);
	}

	public Mapa(int tamanho_x, int tamanho_y, List<Personagem> personagens) {
		this(tamanho_x, tamanho_y);
		this.adicionarPersonagem(personagens);
	}

	public Mapa(int tamanho_x, int tamanho_y, Personagem... personagens) {
		this(tamanho_x, tamanho_y);
		this.adicionarPersonagem(personagens);
	}

	public Mapa(int tamanho_lado, List<Personagem> personagens) {
		this(tamanho_lado, tamanho_lado, personagens);
	}

	public Mapa(int tamanho_lado, Personagem... personagens) {
		this(tamanho_lado, tamanho_lado, personagens);
	}

	public void adicionarPersonagem(Personagem... personagens) {
		for (Personagem personagem : personagens) {
			if (personagem.getPosicao() != null && this.isDentro(personagem.getPosicao())) {
				if (personagem.getLado() == Lado.ALIADO) {
					this.aliados.add(personagem);
				} else if (personagem.getLado() == Lado.INIMIGO) {
					this.inimigos.add(personagem);
				}
			}
		}
	}

	public void adicionarPersonagem(List<Personagem> personagens) {
		for (Personagem personagem : personagens) {
			if (personagem.getPosicao() != null && this.isDentro(personagem.getPosicao())) {
				if (personagem.getLado() == Lado.ALIADO) {
					this.aliados.add(personagem);
				} else if (personagem.getLado() == Lado.INIMIGO) {
					this.inimigos.add(personagem);
				}
			}
		}
	}

	public void acao() {
		for (int i = 0; i < aliados.size(); i++) {
			for (int j = 0; j < inimigos.size(); j++) {
				this.aliados.get(i).notaInimigo(this.inimigos.get(j));
				this.inimigos.get(i).notaInimigo(this.aliados.get(j));
			}
		}
	}

	public boolean isDentro(Point ponto) {
		return (ponto.x >= 0 && ponto.y >= 0) && (ponto.x < this.area[0] && ponto.y < this.area[1]);
	}

	public int getQuantidadeDePesonagens() {
		return this.aliados.size() + this.inimigos.size();
	}

}