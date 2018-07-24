package lista02;

import java.io.Console;

public class Main {

	public static void main(String[] args) {
		Console console = System.console();
		
		//Leitura do Console
		System.out.println("Informe tres valores (pressione enter para cada valor informado): ");
		String v1 = console.readLine();
		String v2 = console.readLine();
		String v3 = console.readLine();
		
		//Conversao para int
		int i1, i2, i3;
		i1 = Integer.parseInt(v1);
		i2 = Integer.parseInt(v2);
		i3 = Integer.parseInt(v3);
		
		//Determinar a ordem
		if (i1 <= i2 && i1 <= i3) {
			System.out.prit
		}
	}

}
