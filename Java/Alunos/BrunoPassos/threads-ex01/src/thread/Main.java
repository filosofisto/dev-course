package thread;

public class Main {

	public static void main(String[] args) {
		
		Thread[] threads = new Thread[8];
		
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Corredor());
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}
}
