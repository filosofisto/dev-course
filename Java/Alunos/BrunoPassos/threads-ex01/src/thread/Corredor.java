package thread;

public class Corredor implements Runnable {

	@Override
	public void run() {

		for(int i=0; i<101; i++) {
			System.out.printf("Corredor= %d metros= %d \n", Thread.currentThread().getId(), i);
			if(i==100) {
				System.out.printf("%d - LINHA DE CHEGADA\n", Thread.currentThread().getId());
			}
			Thread.yield();
		}
	}
}

