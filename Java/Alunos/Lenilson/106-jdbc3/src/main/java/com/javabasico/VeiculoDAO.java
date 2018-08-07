package com.javabasico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

	private Connection connection;
	
	private PreparedStatement pInsert;
	private PreparedStatement pUpdate;
	private PreparedStatement pDelete;
	private PreparedStatement pRead;

	public VeiculoDAO(Connection connection) {
		this.connection = connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// Ignore
			}
		}
	}

	public void incluir(Veiculo veiculo) throws SQLException {
		PreparedStatement v = null;

		try {
			v = getPInsert();

			v.setString(1, veiculo.getPlaca());
			v.setString(2, veiculo.getModelo());
			v.setString(3, veiculo.getFabricante());
			v.setInt(4, veiculo.getAno());

			v.executeUpdate();
		} finally {
			if (v != null) {
				try {
					v.close();
				} catch (SQLException e) {
					// Ignore
				}
			}
		}
	}
	
	private PreparedStatement getPInsert() throws SQLException {
		if (pInsert == null) {
			pInsert = connection.prepareStatement(
					VeiculoSQL.INSERT.sql()
			);
		}
		
		return pInsert;
	}

	public void excluir(String placa) throws SQLException {
		PreparedStatement p = null;

		try {
			p = connection.prepareStatement(VeiculoSQL.DELETE.sql());

			p.setString(1, placa);

			p.executeUpdate();
		} finally {
			if (p != null) {
				try {
					p.close();
				} catch (SQLException e) {
					// Ignore
				}
			}
		}
	}

	public void alterar(Veiculo veiculo) throws SQLException {
		PreparedStatement v = null;

		try {
			v = connection.prepareStatement(
					VeiculoSQL.UPDATE.sql());

			v.setString(1, veiculo.getModelo());
			v.setString(2, veiculo.getFabricante());
			v.setInt(3, veiculo.getAno());
			v.setString(4, veiculo.getPlaca());

			v.executeUpdate();
		} finally {
			if (v != null) {
				try {
					v.close();
				} catch (SQLException e) {
					// Ignore
				}
			}
		}
	}
	
	public Veiculo obter(String placa) 
			throws SQLException {
		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			stm = connection.prepareStatement(
				VeiculoSQL.READ.sql()
			);
			
			stm.setString(1, placa);
			
			rs = stm.executeQuery();

			Veiculo v = null;
			
			if (rs.next()) {
				v = new Veiculo();

				v.setPlaca(rs.getString("PLACA"));
				v.setModelo(rs.getString("MODELO"));
				v.setFabricante(rs.getString("FABRICANTE"));
				v.setAno(rs.getInt("ANO"));
			}

			return v;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// Ignore
				}
			}

			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// Ignore
				}
			}
		}
	}

	public List<Veiculo> listar() throws SQLException {
		Statement stm = null;
		ResultSet rs = null;

		try {
			stm = connection.createStatement();
			rs = stm.executeQuery(VeiculoSQL.LIST.sql());

			List<Veiculo> list = new ArrayList<Veiculo>();

			while (rs.next()) {
				Veiculo v = new Veiculo();

				v.setPlaca(rs.getString("PLACA"));
				v.setModelo(rs.getString("MODELO"));
				v.setFabricante(rs.getString("FABRICANTE"));
				v.setAno(rs.getInt("ANO"));

				list.add(v);
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

			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// Ignore
				}
			}
		}
	}

	public void incluir(List<Veiculo> veiculos) 
			throws SQLException {
		for (Veiculo v: veiculos) {
			incluir(v);
		}
	}
}
