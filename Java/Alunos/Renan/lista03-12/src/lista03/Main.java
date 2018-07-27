package lista03;

import static java.lang.System.out;

import java.io.Console;

public class Main {

	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		Console c = System.console();
		
		TabelaBrasileirao brasileirao = new TabelaBrasileirao();
		Jogo jogo;
		
		for (;;) {
			jogo = new Jogo();
			
			out.println("Entre com o time A: ");
			jogo.setTimeA(new Time(c.readLine()));
			
			out.println("Gols marcados: ");
			jogo.setGolsA(Integer.parseInt(c.readLine()));
			
			out.println("Entre com o time B: ");
			jogo.setTimeB(new Time(c.readLine()));
			
			out.println("Gols marcados: ");
			jogo.setGolsB(Integer.parseInt(c.readLine()));
			
			brasileirao.adicionarJogo(jogo);
			
			out.println("Continuar [S/N]");
			if (c.readLine().equals("N")) {
				break;
			}
		}
		
		brasileirao.exibirResultado();
	}
}
