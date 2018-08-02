package model;

public interface Formato <T>{

	void codificar(String arquivo, T... objetos) throws Exception;
	
	T[] decodificar(String arquivo) throws Exception;
	
	
	
	String demonstrarCodificacao(T... objetos) throws Exception;
	
}
