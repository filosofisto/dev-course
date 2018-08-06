package com.javabasico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ViewportLayout;

public class VeiculoDAO {

	private Connection connection;

	private PreparedStatement pInsert;
	private PreparedStatement pUpdate;
	private PreparedStatement pDelete;
	private PreparedStatement pRead;
	private PreparedStatement pList;

	public VeiculoDAO(Connection connection) {
		this.connection = connection;
	}

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

	public void incluir(Veiculo veiculo) throws SQLException {
		PreparedStatement p = null;

		p = getPInsert();

		p.setString(1, veiculo.getPlaca());
		p.setString(2, veiculo.getModelo());
		p.setString(3, veiculo.getFabricante());
		p.setInt(4, veiculo.getAno());

		p.executeUpdate();

	}

	private PreparedStatement getPInsert() throws SQLException {
		if (pInsert == null) {
			pInsert = connection.prepareStatement(VeiculoSQL.INSERT.sql());
		}

		return pInsert;
	}

	public void excluir(String placa) throws SQLException {
		PreparedStatement p = getPDelete();

		p.setString(1, placa);

		p.executeUpdate();
	}

	private PreparedStatement getPDelete() throws SQLException {
		if (pDelete == null) {
			pDelete = connection.prepareStatement(VeiculoSQL.DELETE.sql());
		}

		return pDelete;
	}

	public void alterar(Veiculo veiculo) throws SQLException {
		PreparedStatement p = getPUpdate();

		p.setString(1, veiculo.getPlaca());
		p.setString(2, veiculo.getModelo());
		p.setString(3, veiculo.getFabricante());
		p.setInt(4, veiculo.getAno());

		p.executeUpdate();
	}

	private PreparedStatement getPUpdate() throws SQLException {
		if (pUpdate == null) {
			pUpdate = connection.prepareStatement(VeiculoSQL.UPDATE.sql());
		}

		return pUpdate;
	}

	public Veiculo obter(String placa) throws SQLException {
		ResultSet rs = null;

		try {
			PreparedStatement stm = getPRead();

			stm.setString(1, placa);

			rs = stm.executeQuery();

			Veiculo v = new Veiculo();

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
		}
	}

	private PreparedStatement getPRead() throws SQLException {
		if (pRead == null) {
			pRead = connection.prepareStatement(VeiculoSQL.READ.sql());
		}

		return pRead;
	}

	public List<Veiculo> listar() throws SQLException {
		ResultSet rs = null;

		try {
			PreparedStatement stm = getPList();

			rs = stm.executeQuery();

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
		}
	}

	private PreparedStatement getPList() throws SQLException {
		if (pList == null) {
			pList = connection.prepareStatement(VeiculoSQL.LIST.sql());
		}

		return pList;
	}

	public void incluir(List<Veiculo> veiculos) throws SQLException {
		this.incluir(veiculos.toArray(new Veiculo[veiculos.size()]));
	}

	public void incluir(Veiculo... veiculos) throws SQLException {
		for (Veiculo v : veiculos) {
			incluir(v);
		}
	}
}
