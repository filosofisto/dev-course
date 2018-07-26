package com.javabasico;

public class NetworkConnection implements Connectable {

	@Override
	public void open() {
		System.out.println("ConexaoNet->open()");
	}

	@Override
	public void close() {
		System.out.println("ConexaoNet->close()");
	}
}
