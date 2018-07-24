package lista02;

import java.io.Console;

public class Main {

	public static void main(String[] args) {
		Console console = System.console();
		
		// Leitura do Console
		System.out.println("Informe tres valores (pressione enter para cada valor informado:");
		String v1 = console.readLine();
		String v2 = console.readLine();
		String v3 = console.readLine();
		
		// Conversao para int
		int i1, i2, i3;
		i1 = Integer.parseInt(v1);
		i2 = Integer.parseInt(v2);
		i3 = Integer.parseInt(v3);
		
		// Determinar a ordem
		System.out.print(min(i1, min(i2, i3)));
		System.out.print(mid(i1, i2, i3));
		System.out.print(max(i1, max(i2, i3)));
	}
	
	static int min(int n1, int n2) {
		if (n1 <= n2) {
			return n1;
		} else {
			return n2;
		}
	}
	
	static int max(int n1, int n2) {
		if (n1 >= n2)
			return n1;
		else
			return n2;
	}
	
	static int mid(int n1, int n2, int n3) {
		if ((n1 >= n2 && n1 <= n3) || (n1 >= n3 && n1 <= n2)) {
			return n1;
		} else if ((n2 >= n1 && n2 <= n3) || (n2 >= n3 && n2 <= n1)) {
			return n2;
		} else { 
			return n3;
		}
	}
}
