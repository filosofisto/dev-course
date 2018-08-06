package com.javabasico;

public enum VeiculoSQL {

	INSERT("INSERT INTO veiculo(placa,modelo,fabricante,ano) VALUES(?,?,?,?)"),
	UPDATE("UPDATE veiculo SET modelo=?, fabricante=?, ano=? WHERE (placa=?)"),
	DELETE("DELETE FROM veiculo WHERE placa=?"),
	READ("SELECT * FROM veiculo WHERE placa=?"),
	LIST("SELECT * FROM veiculo ORDER BY placa");
	
	private String sql;
	
	VeiculoSQL(String sql) {
		this.sql = sql;
	}
	
	public String sql() {
		return sql;
	}
}
