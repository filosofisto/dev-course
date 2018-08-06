package com.javabasico;

public enum VeiculoSQL {

	INSERT("INSERT INTO VEICULO(PLACA, MODELO, FABRICANTE, ANO) VALUES(?,?,?,?)"),
	UPDATE("UPDATE VEICULO SET MODELO=?,FABRICANTE=?,ANO=? WHERE (PLACA=?)"),
	DELETE("DELETE FROM VEICULO WHERE PLACA=?"),
	READ("SELECT * FROM VEICULO WHERE PLACA=?"),
	LIST("SELECT * FROM VEICULO ORDER BY FABRICANTE");
	
	private String sql;
	
	VeiculoSQL(String sql) {
		this.sql = sql;
	}
	
	public String sql() {
		return sql;
	}
}
