package model;

public class Pontuacao implements Comparable<Pontuacao> {

	private Time time;
	private int vitorias;
	private int derrotas;
	private int empates;
	private int golsPro;
	private int golsSofridos;

	Pontuacao(Time time) {
		this.time = time;
	}

	public int getPartidas() {
		return vitorias + derrotas + empates;
	}

	public int getPontos() {
		return vitorias * 3 + empates;
	}

	public int getSaldoGols() {
		return golsPro - golsSofridos;
	}

	public int getVitorias() {
		return vitorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public int getEmpates() {
		return empates;
	}

	public int getGolsPro() {
		return golsPro;
	}

	public int getGolsSofridos() {
		return golsSofridos;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public void setGolsPro(int golsPro) {
		this.golsPro = golsPro;
	}

	public void setGolsSofridos(int golsSofridos) {
		this.golsSofridos = golsSofridos;
	}

	public void adicionaEmpate() {
		this.empates++;
	}

	public void adicionaEmpate(int empates) {
		this.empates += empates;
	}

	public void adicionaVitoria() {
		this.vitorias++;
	}

	public void adicionaVitoria(int vitorias) {
		this.vitorias += vitorias;
	}

	public void adicionaDerrota() {
		this.derrotas++;
	}

	public void adicionaDerrota(int derrotas) {
		this.derrotas += derrotas;
	}

	public void adicionaGolsPro(int gols) {
		this.golsPro += gols;
	}

	public void adicionaGolsSofridos(int gols) {
		this.golsSofridos += gols;
	}

	@Override
	public int compareTo(Pontuacao o) {
		int ret = o.getPontos() - this.getPontos();

		if (ret == 0) {
			ret = o.getVitorias() - this.getVitorias();
			if (ret == 0) {
				ret = o.getSaldoGols() - this.getSaldoGols();
			}
		}

		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + derrotas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pontuacao other = (Pontuacao) obj;
		if (derrotas != other.derrotas)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pontuacao [time=" + time + ", vitorias=" + vitorias + ", derrotas=" + derrotas + ", empates=" + empates
				+ ", golsPro=" + golsPro + ", golsSofridos=" + golsSofridos + ", getPartidas()=" + getPartidas()
				+ ", getPontos()=" + getPontos() + ", getSaldoGols()=" + getSaldoGols() + "]";
	}

}
