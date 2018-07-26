package Lista03;

import java.util.ArrayList;

public class Campeonato {

	String nome;
	ArrayList<Time> times = new ArrayList<Time>();

	public Campeonato() {

	}

	public Campeonato(String nome) {
		this.nome = nome;
	}

	public Campeonato(ArrayList<Time> times) {
		this.times = times;
	}

	public Campeonato(String nome, ArrayList<Time> times) {
		this.nome = nome;
		this.times = times;
	}

	public void criarJogo(
			int indice_time1, int time1_gols_pros, int time1_gols_contra, 
			int indice_time2, int time2_gols_pros, int time2_gols_contra) {
		
	}

	public void adicionarTime(Time time) {
		this.times.add(time);
	}

	public int contarTimes() {
		return this.times.size();
	}

	public void removerTime(int indice) {
		this.times.remove(indice);
	}

	public void removerTime(String nome) {
		nome = nome.toLowerCase();

		for (int i = 0; i < times.size(); i++) {
			if (times.get(i).getNome().toLowerCase().equals(nome)) {
				times.remove(i);
				i--;
			}
		}
	}

	public String toString() {
		String txt = "\t Campeonato\t" + this.nome + " \n\n";

		for (int i = 0; i < this.times.size(); i++) {
			txt += "\n\t\t Time de Índice nº" + i;
			txt += this.times.get(i).toString();
		}

		return txt;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Time> getTimes() {
		return times;
	}

	public void setTimes(ArrayList<Time> times) {
		this.times = times;
	}

}
