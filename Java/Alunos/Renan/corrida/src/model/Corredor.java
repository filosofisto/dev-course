package model;

import java.util.Random;

public class Corredor extends Thread{
	
	private static int contador;
	
	private final int id = Corredor.contador+1;
	
	private int chegada;
	private int distanciaPercorrida;
	
	private boolean comSono;
	
	
	public Corredor(int chegada, boolean comSono) {
		this.chegada = chegada;
		this.comSono = comSono;
		this.distanciaPercorrida = 0;
		
		Corredor.contador++;
	}
	
	public Corredor(int chegada){
		this(chegada, false);
	}
	
	
	
	public void run() {
		if(this.chegada == 0) {
			try {
				throw new Exception("Chegada igual a zero");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		while(this.distanciaPercorrida < this.chegada) {
			if(this.comSono && new Random().nextBoolean()) {
				try {
					Thread.sleep(new Random().nextInt(chegada)+1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			++this.distanciaPercorrida;
			System.out.println("\t Corredor de ID nº"+this.id+"\t percorreu "+this.distanciaPercorrida+", faltando "+(this.chegada-this.distanciaPercorrida)+" para a chegada em sua corrida de "+this.chegada+".");
		}
		
		System.out.println("\t Corredor de ID nº"+this.id+"\t chegou na chegada!");
	}
	
	
	
	
}
