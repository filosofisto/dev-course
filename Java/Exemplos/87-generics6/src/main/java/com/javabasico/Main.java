package com.javabasico;


/**
 * Obtendo tipo parametrizado
 * 
 * @author eduardo
 *
 */
public class Main {

	public static void main(String[] args) {
		ListaEncadeadaSubClass list = 
			new ListaEncadeadaSubClass();
		System.out.println(list.getParentItemClass());
		
		/*ListaEncadeada<String> listStr = new ListaEncadeada<String>();
		System.out.println(listStr.getItemClass());*/
	}
	
	
}