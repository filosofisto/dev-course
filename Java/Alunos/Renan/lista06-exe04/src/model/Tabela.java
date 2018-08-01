package model;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Tabela {

	Set<Time> times = new HashSet<Time>();
	Set<Pontuacao> pontuacoes = new TreeSet<Pontuacao>();

	public Tabela() {
	}

	public void adicionarTime(Time time) {
		if (!this.times.contains(time)) {
			this.times.add(time);
			this.pontuacoes.add(new Pontuacao(time));
		}
	}

	public void adicionarPontuacao(Pontuacao pontuacao) {
		Pontuacao[] temp = new Pontuacao[this.pontuacoes.size()];
		this.pontuacoes.toArray(temp);
		boolean encontrado = false;
		for (Pontuacao p : temp) {
			if (p.getTime().equals( pontuacao.getTime()) ){

				p.adicionaVitoria(pontuacao.getVitorias());
				p.adicionaDerrota(pontuacao.getDerrotas());
				p.adicionaEmpate(pontuacao.getEmpates());

				p.adicionaGolsPro(pontuacao.getGolsPro());
				p.adicionaGolsSofridos(pontuacao.getGolsSofridos());

				this.pontuacoes.remove(p);
				this.pontuacoes.add(p);

				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			if (!this.times.contains(pontuacao.getTime())) {
				this.times.add(pontuacao.getTime());
			}
			this.pontuacoes.add(pontuacao);
		}

	}

	public void analisarPartida(Partida partida) {
		if (times.contains(partida.getTimeA())) {
			times.add(partida.getTimeA());
		}
		if (times.contains(partida.getTimeB())) {
			times.add(partida.getTimeA());
		}

		if (partida.isEmpate()) {
			Pontuacao p = new Pontuacao(partida.getTimeA());
			p.adicionaEmpate();
			p.adicionaGolsPro(partida.getGolsPro(p.getTime()));
			p.adicionaGolsSofridos(partida.getGolsSofridos(p.getTime()));
			this.adicionarPontuacao(p);

			p = new Pontuacao(partida.getTimeB());
			p.adicionaEmpate();
			p.adicionaGolsPro(partida.getGolsPro(p.getTime()));
			p.adicionaGolsSofridos(partida.getGolsSofridos(p.getTime()));
			this.adicionarPontuacao(p);

		} else {
			Pontuacao p = new Pontuacao(partida.getVencedor());
			p.adicionaVitoria();
			p.adicionaGolsPro(partida.getGolsPro(p.getTime()));
			p.adicionaGolsSofridos(partida.getGolsSofridos(p.getTime()));
			this.adicionarPontuacao(p);
			
			p =  new Pontuacao(partida.getPerdedor());
			p.adicionaDerrota();
			p.adicionaGolsPro(partida.getGolsPro(p.getTime()));
			p.adicionaGolsSofridos(partida.getGolsSofridos(p.getTime()));
			this.adicionarPontuacao(p);
		}
	}

	public Set<Time> getTimes() {
		return times;
	}

	public void setTimes(Set<Time> times) {
		this.times = times;
	}

	public Set<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}

	public void setPontuacoes(Set<Pontuacao> pontuacoes) {
		this.pontuacoes = pontuacoes;
	}

	@Override
	public String toString() {
		return "Tabela [times=" + times + ", pontuacoes=" + pontuacoes + "]";
	}

	
	
}
