package model;

import java.util.Random;

public class Corredor extends Thread implements Comparable<Corredor>{

	protected int chegada;
	protected int distanciaPercorrida;
	protected long tempoDeCorrida;
	
	
	protected boolean comSono;

	public Corredor(int chegada, boolean comSono) {
		this.chegada = chegada;
		this.comSono = comSono;
		
		this.distanciaPercorrida = 0;
		this.tempoDeCorrida = 0;
	}

	public Corredor(int chegada) {
		this(chegada, false);
	}

	public void run() {
		
		long inicio = System.currentTimeMillis();
		
		Random r = new Random();
		while (this.distanciaPercorrida < this.chegada) {
			if (this.comSono && r.nextBoolean()) {
				try {
					Thread.sleep(r.nextInt(10) + 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			++this.distanciaPercorrida;
			System.out.println("\t Corredor de ID nº" + this.getId() + "\t percorreu " + this.distanciaPercorrida
					+ ",\t faltando " + (this.chegada - this.distanciaPercorrida) + " para a chegada em sua corrida de "
					+ this.chegada + ".");
		}
		long fim = System.currentTimeMillis();
		
		this.tempoDeCorrida = fim - inicio;

		System.out.println("\t Corredor de ID nº" + this.getId() + "\t CHEGOU na linha de chegada levando "+this.tempoDeCorrida+"ms!");
	}
	
	public boolean chegou() {
		return this.distanciaPercorrida >= this.chegada;
	}

	@Override
	public int compareTo(Corredor outro) {
		if(outro.chegou() && this.chegou()) {
			return (int) (outro.tempoDeCorrida - this.tempoDeCorrida);
		}
		
		return outro.distanciaPercorrida - this.distanciaPercorrida; 
	}
	
	

}
