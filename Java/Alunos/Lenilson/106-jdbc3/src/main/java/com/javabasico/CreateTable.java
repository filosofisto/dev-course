package com.javabasico;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	
	private static final String SQL_CREATE_VEICULO = 
		"CREATE TABLE VEICULO (PLACA CHAR(7) NOT NULL PRIMARY KEY, MODELO VARCHAR(30) NOT NULL, FABRICANTE VARCHAR(30) NOT NULL, ANO INTEGER NOT NULL)";

	private Connection conn;
	
	public boolean createVeiculo() throws SQLException, ClassNotFoundException {
		if (!existVeiculo()) {
			createTableVeiculo();
			
			return true;
		}
		
		return false;
	}
	
	private void createTableVeiculo() throws SQLException, ClassNotFoundException {
		Statement stm = null;
		try {
			stm = getConnection().createStatement();
			stm.executeUpdate(SQL_CREATE_VEICULO);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					//Ignore
					e.printStackTrace();
				}
			}
		}
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		if (conn == null) {
			Connector connector = new Connector();
			conn = connector.makeConnection();
		}
		
		return conn;
	}

	private boolean existVeiculo() throws SQLException, ClassNotFoundException {
		Statement stm = getConnection().createStatement();
		
		try {
			stm.execute("select placa from veiculo");
			
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			try {
				stm.close();
			} catch (SQLException e) {
				//Ignore
				e.printStackTrace();
			}
		}
	}
}
