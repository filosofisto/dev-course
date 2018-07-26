package Lista03;

import java.util.ArrayList;
import java.util.Random;

public class Tabela {

	String nome;
	ArrayList<Time> times = new ArrayList<Time>();

	public Tabela() {

	}

	public Tabela(String nome) {
		this.nome = nome;
	}

	public Tabela(ArrayList<Time> times) {
		this.times = times;
	}

	public Tabela(String nome, ArrayList<Time> times) {
		this.nome = nome;
		this.times = times;
	}

	public void criarJogo(int indice_time1, int time1_gols_pros, int time1_gols_contra, int indice_time2,
			int time2_gols_pros, int time2_gols_contra) {

		if ((indice_time1 >= 0 && indice_time2 >= 0)
				&& (indice_time1 < this.times.size() && indice_time2 < this.times.size())) {
			if (time1_gols_pros + time2_gols_contra > time2_gols_pros + time1_gols_contra) {
				// Time 1 Ganhou
				this.times.get(indice_time1).acrescentaVitoria();
				this.times.get(indice_time2).acrescentaDerrota();
			} else if (time1_gols_pros + time2_gols_contra < time2_gols_pros + time1_gols_contra) {
				// Time 2 Ganhou
				this.times.get(indice_time1).acrescentaDerrota();
				this.times.get(indice_time2).acrescentaVitoria();
			} else {
				// Empate
				this.times.get(indice_time1).acrescentaEmpate();
				this.times.get(indice_time2).acrescentaEmpate();
			}

			this.times.get(indice_time1).acrescentaGolsPros(time1_gols_pros);
			this.times.get(indice_time1).acrescentaGolsContras(time1_gols_contra);

			this.times.get(indice_time2).acrescentaGolsPros(time2_gols_pros);
			this.times.get(indice_time2).acrescentaGolsContras(time2_gols_contra);

		}
	}

	public Time getVencedor() {
		int vencedor = 0;
		for (int i = 1; i < times.size(); i++) {
			if (times.get(i).calcularPontuacao() > times.get(vencedor).calcularPontuacao()) {
				vencedor = i;
			}
		}

		return this.times.get(vencedor);
	}
	public Time getPerdedor() {
		int perdedor = 0;
		for (int i = 1; i < times.size(); i++) {
			if (times.get(i).calcularPontuacao() < times.get(perdedor).calcularPontuacao()) {
				perdedor = i;
			}
		}

		return this.times.get(perdedor);
	}

	public void sortearCampeonato() {

		zerarCampeonato();

		for (int i = 0; i < times.size(); i++) {
			for (int j = i + 1; j < times.size(); j++) {
				Random r = new Random();
				criarJogo(i, r.nextInt(10), r.nextInt(3), j, r.nextInt(10), r.nextInt(3));
			}
		}
	}

	public void zerarCampeonato() {
		for (int i = 0; i < times.size(); i++) {
			times.get(i).setDerrotas(0);
			times.get(i).setEmpates(0);
			times.get(i).setVitorias(0);

			times.get(i).setGols_contras(0);
			times.get(i).setGols_pros(0);
		}
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

	@Override
	public String toString() {
		String txt = "\t Campeonato\t" + this.nome;

		txt += "\n\t Vencedor:\t" + getVencedor().getNome();
		txt += "\n\t Quantidade de times participantes:\t" + this.times.size();
		txt += "\n\t Quantidade de partidas realizadas:\t" + getQuantidadeDeJogos() + "\n";
		for (int i = 0; i < this.times.size(); i++) {
			txt += "\n\n\t\t Time de Índice nº" + i;
			txt += this.times.get(i).toString();
		}

		return txt;
	}

	public int getQuantidadeDeTimes() {
		return this.times.size();
	}

	public int getQuantidadeDeJogos() {
		int count = 0;
		for (Time time : times) {
			count += time.quantidadeDeJogos();
		}
		return count;
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
