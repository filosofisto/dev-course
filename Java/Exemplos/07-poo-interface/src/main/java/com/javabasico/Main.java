package com.javabasico;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			erro(-1);
		}
		if (!args[0].equals("database") && !args[0].equals("network")) {
			erro(-2);
		}
		
		Connector c = new Connector();
		
		try {
			c.connect(args[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void erro(int codigo) {
		System.err.println("Parametro: [database|network] ");
		System.exit(codigo);
	}
}
