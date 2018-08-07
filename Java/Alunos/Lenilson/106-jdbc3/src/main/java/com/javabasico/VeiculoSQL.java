package com.javabasico;

public enum VeiculoSQL {

	INSERT("INSERT INTO devcourse.VEICULO(PLACA,MODELO,FABRICANTE,ANO) VALUES(?,?,?,?)"),
	UPDATE("UPDATE devcourse.VEICULO SET MODELO=?,FABRICANTE=?,ANO=? WHERE (PLACA=?)"),
	DELETE("DELETE FROM devcourse.VEICULO WHERE PLACA=?"),
	READ("SELECT * FROM devcourse.VEICULO WHERE PLACA=?"),
	LIST("SELECT * FROM devcourse.VEICULO ORDER BY MODELO");
	
	private String sql;
	
	VeiculoSQL(String sql) {
		this.sql = sql;
	}
	
	public String sql() {
		return sql;
	}
}
