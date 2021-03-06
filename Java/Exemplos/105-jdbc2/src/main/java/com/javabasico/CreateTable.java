package com.javabasico;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	
	private static final String SQL_CREATE_PESSOA = 
		"CREATE TABLE PESSOA (CPF CHAR(11) NOT NULL PRIMARY KEY, NOME VARCHAR(30) NOT NULL, IDADE INTEGER NOT NULL)";

	private Connection conn;
	
	public boolean createPessoa() {
		try {
			conn = getConnection();

			if (!existeTabelaPessoa()) {
				createTablePessoa();

				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	private void createTablePessoa() throws SQLException, ClassNotFoundException {
		Statement stm = null;
		try {
			stm = getConnection().createStatement();
			stm.executeUpdate(SQL_CREATE_PESSOA);
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

	private boolean existeTabelaPessoa() throws SQLException, ClassNotFoundException {
		Statement stm = getConnection().createStatement();
		
		try {
			stm.executeQuery("select cpf from pessoa");
			
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
