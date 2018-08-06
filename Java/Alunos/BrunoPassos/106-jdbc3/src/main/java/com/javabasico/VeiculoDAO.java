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
	private PreparedStatement pList;

	public void closeConnection() {
		if (pInsert != null) {
			try {
				pInsert.close();
			} catch (SQLException e) {
				// Ignore
			}
		}
		if (pUpdate != null) {
			try {
				pUpdate.close();
			} catch (SQLException e) {
				// Ignore
			}
		}
		if (pDelete != null) {
			try {
				pDelete.close();
			} catch (SQLException e) {
				// Ignore
			}
		}
		if (pRead != null) {
			try {
				pRead.close();
			} catch (SQLException e) {
				// Ignore
			}
		}
		if (pList != null) {
			try {
				pList.close();
			} catch (SQLException e) {
				// Ignore
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
	
	public VeiculoDAO(Connection connection) {
		this.connection = connection;
	}

	public void incluir(Veiculo veiculo) throws SQLException {
		PreparedStatement v = null;

		v = getPInsert();

		v.setString(1, veiculo.getPlaca());
		v.setString(2, veiculo.getModelo());
		v.setString(3, veiculo.getFabricante());
		v.setInt(4, veiculo.getAno());

		v.executeUpdate();

	}

	private PreparedStatement getPInsert() throws SQLException {
		if (pInsert == null) {
			pInsert = connection.prepareStatement(VeiculoSQL.INSERT.sql());
		}

		return pInsert;
	}

	public void excluir(String placa) throws SQLException {
		PreparedStatement v = getpDelete();

		v.setString(1, placa);

		v.executeUpdate();
	}

	public void alterar(Veiculo veiculo) throws SQLException {
		PreparedStatement v = getpUpdate();

		v.setString(1, veiculo.getModelo());
		v.setString(2, veiculo.getFabricante());
		v.setInt(3, veiculo.getAno());

		v.executeUpdate();
	}

	public Veiculo obter(String placa) throws SQLException {
		PreparedStatement stm = null;
		ResultSet rs = null;

		try {
			stm = connection.prepareStatement(VeiculoSQL.READ.sql());

			stm.setString(1, placa);

			rs = stm.executeQuery();

			Veiculo v = null;

			if (rs.next()) {
				v = new Veiculo();

				v.setPlaca(rs.getString("placa"));
				v.setModelo(rs.getString("modelo"));
				v.setFabricante(rs.getString("fabricante"));
				v.setAno(rs.getInt("ano"));
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

				v.setPlaca(rs.getString("placa"));
				v.setModelo(rs.getString("modelo"));
				v.setFabricante(rs.getString("fabricante"));
				v.setAno(rs.getInt("ano"));

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

	public void incluir(List<Veiculo> veiculos) throws SQLException {
		for (Veiculo v : veiculos) {
			incluir(v);
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public PreparedStatement getpInsert() {
		return pInsert;
	}

	public void setpInsert(PreparedStatement pInsert) {
		this.pInsert = pInsert;
	}

	public PreparedStatement getpUpdate() throws SQLException {
		if (pUpdate == null) {
			pUpdate = connection.prepareStatement(
					VeiculoSQL.UPDATE.sql()
			);
		}

		return pUpdate;
	}

	public void setpUpdate(PreparedStatement pUpdate) {
		this.pUpdate = pUpdate;
	}

	public PreparedStatement getpDelete() {
		return pDelete;
	}

	public PreparedStatement setpDelete(PreparedStatement pDelete) throws SQLException {
		if (pDelete == null) {
			pDelete = connection.prepareStatement(VeiculoSQL.DELETE.sql());
		}

		return pDelete;
	}

	public PreparedStatement getpRead() throws SQLException {
		if (pRead == null) {
			pRead = connection.prepareStatement(VeiculoSQL.READ.sql());
		}

		return pRead;
	}

	public void setpRead(PreparedStatement pRead) {
		this.pRead = pRead;
	}

	public PreparedStatement getpList() throws SQLException {
		if (pList == null) {
			pList = connection.prepareStatement(VeiculoSQL.LIST.sql());
		}

		return pList;
	}

	public void setpList(PreparedStatement pList) {
		this.pList = pList;
	}
}
