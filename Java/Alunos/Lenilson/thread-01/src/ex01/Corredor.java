package ex01;

import static java.lang.System.out;

import java.util.Random;

public class Corredor extends Thread {
	private static int posicao = 0;
	private int identificador;
	
	public Corredor(int identificador) {
		this.identificador = identificador + 1;
	}
	
	@Override
	public void run() {
		long t1 = System.currentTimeMillis();
        Random rnd = new Random();

        for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(rnd.nextInt(10)+1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}

		long t2 = System.currentTimeMillis();
		out.printf("Corredor na raia %d chegou na posisao %d!        TEMPO: %d ms\n", this.identificador, ++posicao, t2-t1);
	}
}
