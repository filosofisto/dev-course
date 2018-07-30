package com.javabasico;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		MySubClass mySubClass = new MySubClass();
		Quality q1 = mySubClass.getClass().getAnnotation(Quality.class);
		if (q1 != null) {
			out.printf("MySubClass quality: %s\n", q1.value().name());
		} else {
			out.printf("MySubClass nao esta anotada com @Quality\n");
		}
		
		MyOtherSubClass myOtherSubClass = new MyOtherSubClass();
		Quality q2 = myOtherSubClass.getClass().getAnnotation(Quality.class);
		if (q2 != null) {
			out.printf("MyOtherSubClass quality: %s\n", q2.value().name());
		} else {
			out.printf("MyOtherSubClass nao esta anotada com @Quality\n");
		}
		
		MyOtherSubSubClass myOtherSubSubClass = new MyOtherSubSubClass();
		Quality q3 = myOtherSubSubClass.getClass().getAnnotation(Quality.class);
		if (q3 != null) {
			out.printf("MyOtherSubSubClass quality: %s\n", q3.value().name());
		} else {
			out.printf("MyOtherSubSubClass nao esta anotada com @Quality\n");
		}
	}

}
