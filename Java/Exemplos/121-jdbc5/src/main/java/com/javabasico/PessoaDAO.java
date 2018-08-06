package com.javabasico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

	private Connection connection;
	
	private PreparedStatement pInsert;
	private PreparedStatement pUpdate;
	private PreparedStatement pDelete;
	private PreparedStatement pRead;
	private PreparedStatement pList;

	public PessoaDAO(Connection connection) {
		this.connection = connection;
	}

	public void startTransaction() throws SQLException {
		this.connection.setAutoCommit(false);
	}

	public void commitTransaction() throws SQLException {
		this.connection.commit();
	}

	public void rollbackTransaction() throws SQLException {
		this.connection.rollback();
	}

	public void closeConnection() {
		if (pInsert != null) {
			try {
				pInsert.close();
			} catch (SQLException e) {
				//Ignore
			}
		}
		if (pUpdate != null) {
			try {
				pUpdate.close();
			} catch (SQLException e) {
				//Ignore
			}
		}
		if (pDelete != null) {
			try {
				pDelete.close();
			} catch (SQLException e) {
				//Ignore
			}
		}
		if (pRead != null) {
			try {
				pRead.close();
			} catch (SQLException e) {
				//Ignore
			}
		}
		if (pList != null) {
			try {
				pList.close();
			} catch (SQLException e) {
				//Ignore
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// Ignore
			}
		}
	}

	public void incluir(Pessoa pessoa) throws SQLException {
		PreparedStatement p = null;

		p = getPInsert();

		p.setString(1, pessoa.getCpf());
		p.setString(2, pessoa.getNome());
		p.setInt(3, pessoa.getIdade());

		p.executeUpdate();

	}
	
	private PreparedStatement getPInsert() throws SQLException {
		if (pInsert == null) {
			pInsert = connection.prepareStatement(
					PessoaSQL.INSERT.sql()
			);
		}
		
		return pInsert;
	}

	public void excluir(String cpf) throws SQLException {
		PreparedStatement p = getPDelete();

		p.setString(1, cpf);

		p.executeUpdate();
	}

	private PreparedStatement getPDelete() throws SQLException {
		if (pDelete == null) {
			pDelete = connection.prepareStatement(
					PessoaSQL.DELETE.sql()
			);
		}

		return pDelete;
	}

	public void alterar(Pessoa pessoa) throws SQLException {
		PreparedStatement p = getPUpdate();

		p.setString(1, pessoa.getNome());
		p.setInt(2, pessoa.getIdade());
		p.setString(3, pessoa.getCpf());

		p.executeUpdate();
	}

	private PreparedStatement getPUpdate() throws SQLException {
		if (pUpdate == null) {
			pUpdate = connection.prepareStatement(
					PessoaSQL.UPDATE.sql()
			);
		}

		return pUpdate;
	}
	
	public Pessoa obter(String cpf) 
			throws SQLException {
		ResultSet rs = null;

		try {
			PreparedStatement stm = getPRead();
			
			stm.setString(1, cpf);
			
			rs = stm.executeQuery();

			Pessoa p = null;
			
			if (rs.next()) {
				p = new Pessoa();

				p.setCpf(rs.getString("CPF"));
				p.setNome(rs.getString("NOME"));
				p.setIdade(rs.getInt("IDADE"));
			}

			return p;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// Ignore
				}
			}
		}
	}

	private PreparedStatement getPRead() throws SQLException {
		if (pRead == null) {
			pRead = connection.prepareStatement(
					PessoaSQL.READ.sql()
			);
		}

		return pRead;
	}


	public List<Pessoa> listar() throws SQLException {
		ResultSet rs = null;

		try {
			PreparedStatement stm = getPList();

			rs = stm.executeQuery();

			List<Pessoa> list = new ArrayList<Pessoa>();

			while (rs.next()) {
				Pessoa p = new Pessoa();

				p.setCpf(rs.getString("CPF"));
				p.setNome(rs.getString("NOME"));
				p.setIdade(rs.getInt("IDADE"));

				list.add(p);
			}

			return list;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// Ignore
				}
			}
		}
	}

	private PreparedStatement getPList() throws SQLException {
		if (pList == null) {
			pList = connection.prepareStatement(
					PessoaSQL.LIST.sql()
			);
		}

		return pList;
	}

	public void incluir(List<Pessoa> pessoas) 
			throws SQLException {
		for (Pessoa p: pessoas) {
			incluir(p);
		}
	}
}
