package control;

import static java.lang.System.out;
import java.util.Random;

import model.Partida;
import model.Pontuacao;
import model.Tabela;
import model.Time;

public class Main {

	public static void main(String[] args) {

		Tabela tabela = new Tabela();

		Random r = new Random();

		int n = r.nextInt(32) + 3;
		int times = r.nextInt(n/2) + 3;

		while (n > 0) {
			n--;
			
			Partida partida = new Partida();
			int sorteio = r.nextInt(times);
			partida.setTimeA(new Time(sorteio + ""));

			while (sorteio == Integer.parseInt(partida.getTimeA().getNome())) {
				sorteio = r.nextInt(times);
				partida.setTimeB(new Time(sorteio + ""));
			}
			
			partida.setGolsA(r.nextInt(10));
			partida.setGolsB(r.nextInt(10));
			
			out.println(partida.toString());

			tabela.analisarPartida(partida);
		}

		out.println("\n\t Times: ");
		for (Time time : tabela.getTimes()) {
			out.println(time.toString());
		}
		out.println("\n\t Pontuações: ");
		for (Pontuacao pontuacao : tabela.getPontuacoes()) {
			out.println(pontuacao.toString());
		}
		
		out.println("\n ");
		
	}

}
