package com.javabasico;

public class ConnectionFactory {

	public Connectable makeConnectable(String tipoConexao) throws Exception {
		if ("database".equals(tipoConexao)) {
			return new DatabaseConnection();
		} else if ("network".equals(tipoConexao)) {
			return new NetworkConnection();
		} else {
			throw new Exception("Tipo de conexao desconhecido");
		}
	}
}
