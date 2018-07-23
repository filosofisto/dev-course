package console;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		String username;
		
		out.print("Usuario: ");
		username = System.console().readLine();
		
		out.print("Senha: ");
		char[] password = System.console().readPassword();
		
		out.printf("Usuario: %s, Senha: %s\n\n", username, new String(password));
	}

}
