package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Mapa {

	private int[] area = new int[2];

	private List<Personagem> atores = new ArrayList<Personagem>();

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
				this.atores.add(personagem);
			}
		}
	}

	public void adicionarPersonagem(List<Personagem> personagens) {
		for (Personagem personagem : personagens) {
			if (personagem.getPosicao() != null && this.isDentro(personagem.getPosicao())) {
				this.atores.add(personagem);
			}
		}
	}

	public void acao() {
		/*
		 *	Ativa a ação de cada Personagem no campo
		 */
		for (int i = 0; i < this.atores.size(); i++) {
			for (int j = i + 1; j < this.atores.size(); j++) {
				
				//	Verifca quem pode atacar quem
				
				if (this.atores.get(i).isVivo() 
						&& this.atores.get(i) instanceof Guerreiro
						&& this.atores.get(i).getEstado() != Estado.ATACANDO
						&& this.atores.get(i).notaInimigo(this.atores.get(j))) {
					Guerreiro atacante = (Guerreiro) this.atores.get(i);
					this.atores.set(j, atacante.atacar(this.atores.get(j)));
					this.atores.set(i, atacante);
				} else if (this.atores.get(i).getEstado() == Estado.DESCANSANDO){
					this.atores.get(i).setEstado(Estado.PRONTO);
				}else {
					this.atores.get(i).setEstado(Estado.DESCANSANDO);
				}
				
				if (this.atores.get(j).isVivo() 
						&& this.atores.get(j) instanceof Guerreiro
						&& this.atores.get(j).getEstado() != Estado.ATACANDO
						&& this.atores.get(j).notaInimigo(this.atores.get(i))) {
					Guerreiro atacante = (Guerreiro) this.atores.get(j);
					this.atores.set(i, atacante.atacar(this.atores.get(i)));
					this.atores.set(j, atacante);
				} else if (this.atores.get(j).getEstado() == Estado.DESCANSANDO){
					this.atores.get(j).setEstado(Estado.PRONTO);
				}else {
					this.atores.get(j).setEstado(Estado.DESCANSANDO);
				}
			}
		}
	}

	public boolean isDentro(Point ponto) {
		return (ponto.x >= 0 && ponto.y >= 0) && (ponto.x < this.area[0] && ponto.y < this.area[1]);
	}

	public int calcularArea() {
		return this.area[0] * this.area[1];
	}

	public int getQuantidadeDePesonagens() {
		return this.atores.size();
	}

	public int getTamanhoX() {
		return this.area[0];
	}

	public int getTamanhoY() {
		return this.area[1];
	}

	public int[] getArea() {
		return area;
	}

	public void setArea(int[] area) {
		this.area = area;
	}

	public List<Personagem> getAtores() {
		return atores;
	}

	public void setAtores(List<Personagem> atores) {
		this.atores = atores;
	}
	
	

}