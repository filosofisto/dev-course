package com.javabasico;

public class Main {

	public static void main(String[] args) {
		int age = -1;
		assert (age > 0) : "Opps! You can see that";
		if (age >= 18) {
			System.out.println("You're an adult! =)");
		}
	}
}
