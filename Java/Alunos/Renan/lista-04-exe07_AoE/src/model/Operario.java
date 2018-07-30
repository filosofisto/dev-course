package model;

import java.awt.Point;

public class Operario extends Personagem {

	private static int instancias_operario = 0;
	private static int operarios_criados = 0;

	public Operario(Lado lado) {
		super(lado, 35, 35);
		Operario.instancias_operario++;
		Operario.operarios_criados++;
	}

	public Operario(Lado lado, Point posicao) {
		super(lado, 35,35, posicao);
		Operario.instancias_operario++;
		Operario.operarios_criados++;
	}

	public static int quantidadeDeInstancias() {
		return Operario.instancias_operario;
	}

	public static int quantidadeDeInstanciasCriadas() {
		return Operario.operarios_criados;
	}

	public void finalize() {
		Operario.instancias_operario--;
	}

}
