package com.javabasico;

import static java.lang.System.out;

public class MyThread extends Thread {

	private int identificador;
	
	public MyThread(int identificador) {
		this.identificador = identificador;
	}
	
	@Override
	public void run() {
		long t1 = System.currentTimeMillis();

		for (int i = 0; i < 100; i++) {
			out.printf("id: %d, valor do i=%d\n", identificador, i);
			//Thread.yield();
			/*if (i % 10 == 0) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}*/
		}

		long t2 = System.currentTimeMillis();
		System.out.printf("Thread %d finalizou em %d ms\n", identificador, (t2-t1));
	}
}
