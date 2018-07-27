package control;

import static java.lang.System.out;

import java.awt.Color;
import java.util.Random;

import model.Ponto;
import model.Ponto3D;
import model.PontoColorido;

public class Teste {

	public static void main(String[] args) {

		out.println("1. Modele uma classe que represente um ponto geométrico em duas dimensões."
				+ "\n Um ponto pode ser representado pelas suas coordenadas x e y."
				+ "\n Considere a questão do “encapsulamento”, ou seja, não exponha diretamente os atributos da classe, mas forneça métodos públicos para que outros objetos possam ler e atualizar estes atributos. \r\n"
				+ "1.1 Quantos construtores a sua classe possui?\r\n" + "1.2 Qual a superclasse do classe Ponto?\r\n"
				+ "1.3 A sua classe possui uma representação como String? Qual?\r\n"
				+ "1.4 Sobrescreva o método equals(Object) para definir o que seria igualdade semântica entre duas instâncias de Ponto.\r\n"
				+ "1.5 Acrescente a capacidade de clonagem na classe Ponto.\r\n"
				+ "1.6 Acrescente um método com a seguinte assinatura: public float distancia(Ponto). Este método deverá retornar a distância entre o ponto que está executando o método distancia e o ponto passado como parâmetro. Considere a estrutura cartesiana abaixo onde a distância é a hipotenusa do triângulo formado pelos pontos:\r\n"
				+ " \r\n"
				+ "1.7 Modele uma classe que represente um ponto geométrico tridimensional como uma especialização da classe Ponto.\r\n"
				+ "1.8 Modele uma classe que represente um ponto Colorido.\r\n"
				+ "1.9 Como controlar a quantidade de instâncias da classe Ponto?\r\n");

		out.println("\n\n\t Declarando os Pontos . . . ");

		Ponto p1;
		Ponto p2;
		Ponto3D p3D;
		Ponto3D p3D_outro;
		PontoColorido pC;
		PontoColorido pC2;

		try {
			p1 = new Ponto(Double.parseDouble(getNextArg(args)), Double.parseDouble(getNextArg(args)));
		} catch (Exception e) {
			Random r = new Random();
			p1 = new Ponto(r.nextDouble(), r.nextDouble());
		}

		try {
			p2 = new Ponto(Double.parseDouble(getNextArg(args)), Double.parseDouble(getNextArg(args)));
		} catch (Exception e) {
			Random r = new Random();
			p2 = new Ponto(r.nextDouble(), r.nextDouble());
		}

		try {
			p3D = new Ponto3D(Double.parseDouble(getNextArg(args)), Double.parseDouble(getNextArg(args)),
					Double.parseDouble(getNextArg(args)));
		} catch (Exception e) {
			Random r = new Random();
			p3D = new Ponto3D(r.nextDouble(), r.nextDouble(), r.nextDouble());
		}

		try {
			p3D_outro = new Ponto3D(Double.parseDouble(getNextArg(args)), Double.parseDouble(getNextArg(args)),
					Double.parseDouble(getNextArg(args)));
		} catch (Exception e) {
			Random r = new Random();
			p3D_outro = new Ponto3D(r.nextDouble(), r.nextDouble(), r.nextDouble());
		}

		try {
			pC = new PontoColorido(Double.parseDouble(getNextArg(args)), Double.parseDouble(getNextArg(args)),
					new Color(Integer.parseInt(getNextArg(args))));
		} catch (Exception e) {
			Random r = new Random();
			pC = new PontoColorido(r.nextDouble(), r.nextDouble(),
					new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		}

		try {
			pC2 = new PontoColorido(Double.parseDouble(getNextArg(args)), Double.parseDouble(getNextArg(args)),
					new Color(Integer.parseInt(getNextArg(args))));
		} catch (Exception e) {
			Random r = new Random();
			pC2 = new PontoColorido(r.nextDouble(), r.nextDouble(),
					new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		}

		out.println();

		out.println("\t 1º Ponto 2D: \t" + p1.toString());
		out.println("\t 2º Ponto 2D: \t" + p2.toString());
		out.println("\t\t Equals: \t" + p1.equals(p2));
		out.println("\t\t Distância: \t" + p1.distancia(p2));

		out.println("\t 1º Ponto 3D: \t" + p3D.toString());
		out.println("\t 2º Ponto 3D: \t" + p3D_outro.toString());
		out.println("\t\t Equals: \t" + p3D.equals(p3D_outro));
		out.println("\t\t Distância: \t" + p3D.distancia(p3D_outro));
		out.println();
		out.println("\t Ponto Colorido 1: \t" + pC.toString());		
		out.println("\t Ponto Colorido 2: \t" + pC2.toString());
		out.println("\t\t Equals: \t" + pC.equals(pC2));

		out.println();

		out.println("\t Ponto2D \t Original: \t" + p1.toString());
		p2 = p1.getClone();
		out.println("\t Ponto2D \t Clone: \t" + p2.toString());
		out.println("\t Ponto2D \t Equals: \t" + p1.equals(p2));

		out.println();

		out.println("\t Ponto3D \t Original: \t" + p3D.toString());
		p3D_outro = p3D.getClone();
		out.println("\t Ponto3D \t Clone: \t" + p3D.toString());
		out.println("\t Ponto3D \t Equals: \t" + p3D.equals(p3D_outro));

		out.println();

		out.println("\t Ponto Colorido \t Original: \t" + pC.toString());
		pC2 = pC.getClone();
		out.println("\t Ponto Colorido \t Clone: \t" + pC2.toString());
		out.println("\t Ponto Colorido \t Equals: \t" + pC.equals(pC2));

		out.println();
		
		out.println("Quantidade de Pontos: "+Ponto.getQuantidadeDePontos());
		out.println("Quantidade de Pontos 3D: "+Ponto3D.getQuantidadeDePontos3D());
		out.println("Quantidade de Pontos Coloridos: "+PontoColorido.getQuantidadeDePontosColoridos());
		
	}

	private static int args_index = 0;

	private static String getNextArg(String[] args) {
		return args[args_index++];

	}

}
