package com.javabasico;

public class Main {

	public static void main(String[] args) {
		int age = Integer.parseInt(args[0]);
		
		/*if (age >= 0) {
			showIdade(age);
			System.out.println("Ok, tudo certo belezinha");
		} else {
			System.out.println("Idade invalida");
			System.exit(-1);
		}*/
		
		showIdade(age);
		System.out.println("Ok, tudo certo belezinha");
	}
	
	private static void showIdade(int age) {
		assert (age > 0) : "Opps! You can see that";
		
		if (age >= 18) {
			System.out.println("You're an adult! =)");
		}
	}
}
