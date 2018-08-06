package com.javabasico;

public enum VeiculoSQL {

	INSERT("insert into veiculo(placa, modelo, fabricante, ano) values(?,?,?,?)"),
	UPDATE("update veiculo set modelo=?,fabricante=?,ano=? where (placa=?)"),
	DELETE("delete from veiculo where placa=?"),
	READ("select * from veiculo where placa=?"),
	LIST("select * from veiculo order by fabricante");

	
	private String sql;
	
	VeiculoSQL(String sql) {
		this.sql = sql;
	}
	
	public String sql() {
		return sql;
	}
}
