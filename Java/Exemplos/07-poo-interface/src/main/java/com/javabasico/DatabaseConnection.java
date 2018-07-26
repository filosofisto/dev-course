package com.javabasico;

public class DatabaseConnection implements Connectable {

	@Override
	public void open() {
		System.out.println("ConexaoBancoDados->open()");
	}

	@Override
	public void close() {
		System.out.println("ConexaoBancoDados->close()");
	}
}
