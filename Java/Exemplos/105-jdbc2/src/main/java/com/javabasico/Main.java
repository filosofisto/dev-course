package com.javabasico;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		CreateTable createTable = new CreateTable();
		boolean criou = createTable.createPessoa();

		if (criou) {
			System.out.println("Tabela pessoa criada com sucesso");
		}

		System.out.println("Sistema iniciado");
	}

}
