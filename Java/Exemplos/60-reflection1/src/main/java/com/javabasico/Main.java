package com.javabasico;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		//Pessoa p = new Pessoa();
		//Class c = p.getClass();

		Object oPessoa = null;

		try {
			Class clsPessoa = Class.forName("com.javabasico.Pessoa");
			oPessoa = clsPessoa.newInstance();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//String b = "sou um objeto";
		Pessoa b = (Pessoa) oPessoa;
		//Object b = new Object();
		Class c = b.getClass();
		
		out.printf("Nome: %s\nNome simples: %s\n",
				c.getName(), c.getSimpleName());
		
		Field[] fields = c.getDeclaredFields();
		for (Field f: fields) {
			out.printf("%s: %s\n", f.getName(), f.getType().getSimpleName());
		}
		
		Constructor[] constructors = c.getConstructors();
		out.println("Construtores ==================== "
				+ constructors.length);
		for (Constructor constr: constructors) {
			for (Class paramClass: constr.getParameterTypes()) {
				out.printf("%s, ", paramClass.getName());
			}
			out.println();
		}
		
		Method[] methods = c.getDeclaredMethods();
		out.println("Metodos ==================== "
				+ methods.length);
		
		for (Method m: methods) {
			out.printf("%s %s\n",
					m.getReturnType().getName(), m.getName());
			
			if (m.getName().equals("length")) {
				try {
					Integer tamanho = (Integer) m.invoke(b);
					out.printf("%d\n", tamanho);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		//System.out.printf("Superclass: %s\n", c.getSuperclass().getName());
		
		Class[] interfaces = c.getInterfaces();
		out.println("Interfaces ================== "
				+ interfaces.length);
		for (Class intf: interfaces) {
			out.printf("%s ", intf.getSimpleName());
		}
	}
}
