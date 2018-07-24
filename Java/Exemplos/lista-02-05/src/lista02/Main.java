package lista02;

public class Main {

	public static void main(String[] args) {
		/*if (args.length != 3) {
			System.err.println("Necessario 3 notas");
			System.exit(-1);
		}
		
		float media = (Float.parseFloat(args[0])
						+ Float.parseFloat(args[1])
						+ Float.parseFloat(args[2]))/3f;*/
		
		if (args.length < 1) {
			System.err.println("Pelo menos 1 nota");
			System.exit(-1);
		}
		
		float sum = 0f;
		
		/*for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			sum += Float.parseFloat(arg);
		}*/
		
		for (String arg: args) {
			sum += Float.parseFloat(arg);
		}
		
		float media = sum/args.length;
		
		System.out.printf("Media: %.2f", media);
	}
}
