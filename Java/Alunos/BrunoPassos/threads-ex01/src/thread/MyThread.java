package thread;

public class MyThread implements Runnable {

	@Override
	public void run() {

		for(int i=0; i<101; i++) {
			System.out.printf("Corredor= %d metros= %d \n", Thread.currentThread().getId(), i);
			Thread.yield();
			if(i==100) {
				System.out.println("LINHA DE CHEGADA");
			}
		}
	}
}

