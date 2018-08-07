package com.javabasico;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Pessoa[] pessoas = {
				new Pessoa("81646674981", "Pele da Silva", 17),
				new Pessoa("81646674982", "Pele da Souza", 15),
				new Pessoa("81646674983", "Pele Pereira", 23),
				new Pessoa("81646674984", "Pele Francisco", 89),
				new Pessoa("81646674985", "Pele Jose", 45),
				new Pessoa("81646674986", "Pele Jesus", 33)
		};

		try {
			insert(pessoas);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void insert(Pessoa[] pessoas) throws IOException, ClassNotFoundException, SQLException {
		Connector connector = new Connector();
		PessoaDAO dao = new PessoaDAO(connector.makeConnection());

		try {
			dao.startTransaction();

			int i = 0;

			for (Pessoa pessoa : pessoas) {
				/*if (++i % 5 == 0)
					throw new RuntimeException("Failed");*/

				dao.incluir(pessoa);
			}

			dao.commitTransaction();
		} catch (Exception e) {
			dao.rollbackTransaction();
		} finally {
			dao.closeConnection();
		}
	}

}
