package com.javabasico;

import static java.lang.System.out;

public class Printer {

	public void print(Object obj) {
		Class cls = obj.getClass();
		PrettyPrinter pp = (PrettyPrinter) cls.getAnnotation(PrettyPrinter.class);
		
		if (pp == null) {
			throw new RuntimeException("Esqueceu de anotar com PrettyPrinter");
		}
		
		Class<? extends Formatter> classFormatter = pp.value();
		
		try {
			Formatter formatter = classFormatter.newInstance();
			
			print(obj, formatter);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private void print(Object obj, Formatter formatter) {
		out.printf("Imprimindo objeto do tipo %s com formatador %s\n",
				obj.getClass().getName(), formatter.getClass().getName());
	}
}
