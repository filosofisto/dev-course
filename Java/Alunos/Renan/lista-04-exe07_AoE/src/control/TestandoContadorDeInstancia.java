package control;

import java.awt.Point;
import java.util.Random;

import model.Arma;
import model.Arqueiro;
import model.Cavaleiro;
import model.Guerreiro;
import model.Lado;
import model.Mapa;
import model.Operario;
import model.Personagem;
import model.Soldado;
import static java.lang.System.out;

public class TestandoContadorDeInstancia {

	public static void main(String[] args) {

		int n = r.nextInt(100) + 1;

		Mapa m = new Mapa(r.nextInt(n) + 1, r.nextInt(n) + 4);

		while (n > 0) {

			Lado lado = null;

			if (r.nextBoolean()) {
				lado = Lado.ALIADO;
			} else {
				lado = Lado.INIMIGO;
			}

			Point ponto = new Point(r.nextInt(m.getTamanhoX() + n), r.nextInt(m.getTamanhoY() + n));

			switch (r.nextInt(4)) { // Random 0 a 3
			case 0:
				Personagem a = new Arqueiro(lado, ponto);
				out.println(" Arqueiro \t" + a.toString());
				m.adicionarPersonagem(a);
				break;
			case 1:
				Personagem c = new Cavaleiro(lado, ponto);
				out.println(" Cavaleiro \t" + c.toString());
				m.adicionarPersonagem(c);
				break;
			case 2:
				Personagem o = new Operario(lado, ponto);
				out.println(" Operario \t" + o.toString());
				m.adicionarPersonagem(o);
				break;
			case 3:
				Personagem s = new Soldado(lado, ponto);
				out.println(" Soldado \t" + s.toString());
				m.adicionarPersonagem(s);
				break;
			}

			n--;
		}

		System.gc(); // Chamando o Garbage Collector

		out.println();

		out.println("\t| Arma	\t|\tDano\t|\tAlcance\t|\tPeso\t|");
		out.println("\t| ARCO	\t|\t" + Arma.ARCO.getDano() + "\t|\t" + Arma.ARCO.getAlcance() + "\t|\t"
				+ Arma.ARCO.getPeso() + "\t|");
		out.println("\t| ESPADA \t|\t" + Arma.ESPADA.getDano() + "\t|\t" + Arma.ESPADA.getAlcance() + "\t|\t"
				+ Arma.ESPADA.getPeso() + "\t|");
		out.println("\t| LANCA	\t|\t" + Arma.LANCA.getDano() + "\t|\t" + Arma.LANCA.getAlcance() + "\t|\t"
				+ Arma.LANCA.getPeso() + "\t|");

		out.println();

		out.println("Area do Mapa: " + m.calcularArea());
		out.println("Personagens adicionados ao Mapa: " + m.getQuantidadeDePesonagens());
		out.println();
		out.println(" Personagens \t " + Personagem.quantidadeDeInstanciasCriadas() + " Instancias criadas, \t"
				+ Personagem.quantidadeDeInstancias() + " Ainda na memória.");
		out.println();
		out.println(" Guerreiros \t " + Guerreiro.quantidadeDeInstanciasCriadas() + " Instancias criadas, \t"
				+ Guerreiro.quantidadeDeInstancias() + " Ainda na memória.");
		out.println();
		out.println(" Arqueiros \t " + Arqueiro.quantidadeDeInstanciasCriadas() + " Instancias criadas, \t"
				+ Arqueiro.quantidadeDeInstancias() + " Ainda na memória.");
		out.println(" Cavaleiros \t " + Cavaleiro.quantidadeDeInstanciasCriadas() + " Instancias criadas, \t"
				+ Cavaleiro.quantidadeDeInstancias() + " Ainda na memória.");
		out.println(" Operarios \t " + Operario.quantidadeDeInstanciasCriadas() + " Instancias criadas, \t"
				+ Operario.quantidadeDeInstancias() + " Ainda na memória.");
		out.println(" Operarios \t " + Soldado.quantidadeDeInstanciasCriadas() + " Instancias criadas, \t"
				+ Soldado.quantidadeDeInstancias() + " Ainda na memória.");

		m.acao();

	}

	private static Random r = new Random();

	/*
	 * private static int arg_index = 0;
	 * 
	 * private String nextArg(String[] args) { return args[arg_index++]; }
	 */

}
