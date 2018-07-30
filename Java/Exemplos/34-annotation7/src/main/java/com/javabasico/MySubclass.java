package com.javabasico;

/**
 * Exemplo demonstrando @Override
 * 
 * @author eduardo
 *
 */
public class MySubclass {

	/*@Override //a anota��o causa erro de compila��o
	public boolean equals(MySubclass other) {
		return false;
	}*/

	@Override 
	public boolean equals(Object obj) {
		return false;
	}
}
