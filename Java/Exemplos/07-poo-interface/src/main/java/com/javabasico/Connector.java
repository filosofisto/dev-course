package com.javabasico;

public class Connector {

	public void connect(String tipoConexao) throws Exception {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connectable c = connectionFactory.makeConnectable(tipoConexao);
		
		c.open();
		
		//bla bla bla
		
		c.close();
	}
}
