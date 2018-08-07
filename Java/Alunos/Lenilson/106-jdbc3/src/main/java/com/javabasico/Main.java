package com.javabasico;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		init();
		
		try {
			menu();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void menu() throws IOException, ClassNotFoundException, SQLException {
		Teclado t = new Teclado();
		
		for (;;) {
			clearConsole();
			System.out.println("============ Menu ============");
			System.out.println("1. Incluir Veiculos");
			System.out.println("2. Listar Veiculos");
			System.out.println("3. Excluir Veiculo");
			System.out.println("4. Obter Veiculo");
			System.out.println("5. Sair da Aplicacao");
			System.out.println("==============================");
			
			String opcao = t.read(">");
			
			if (opcao.equals("1")) {
				insert();
			} else if (opcao.equals("2")) {
				list();
			} else if (opcao.equals("3")) {
				delete();
			} else if (opcao.equals("4")) {
				read();
			} else if (opcao.equals("5")) {
				System.out.println("By ;P");
				break;
			} else {
				System.out.println("Opcao invalida");
			}
		}
		
	}

	private static void clearConsole() {
		for (int i = 1; i < 5; i++) {
			System.out.println();
		}
	}

	private static void delete() throws ClassNotFoundException, SQLException, IOException {
		Teclado t = new Teclado();
		Connector connector = new Connector();
		VeiculoDAO dao = new VeiculoDAO(connector.makeConnection());
		
		System.out.println("Cadastro Veiculo");
		
		String placa = t.read("PLACA");
		
		dao.excluir(placa);
		
		dao.closeConnection();
	}

	private static void list() throws ClassNotFoundException, SQLException {
		Connector connector = new Connector();
		VeiculoDAO dao = new VeiculoDAO(connector.makeConnection());
		
		System.out.println("Listagem de Veiculos");
		
		List<Veiculo> list = dao.listar();
		
		for (Veiculo v: list) {
			System.out.println(v);
		}
		
		dao.closeConnection();
	}
	
	private static void read() throws ClassNotFoundException, SQLException, IOException {
		Teclado t = new Teclado();
		Connector connector = new Connector();
		VeiculoDAO dao = new VeiculoDAO(connector.makeConnection());
		
		System.out.println("Informe a placa");
		
		String placa = t.read("PLACA");
		
		Veiculo v = dao.obter(placa);
		
		if (v != null) {
			System.out.println(v);
		}
		
		dao.closeConnection();
	}

	private static void insert() throws IOException, ClassNotFoundException, SQLException {
		Teclado t = new Teclado();
		Connector connector = new Connector();
		VeiculoDAO dao = new VeiculoDAO(connector.makeConnection());
		
		System.out.println("Cadastro Veiculo");
		
		for(;;) {
			Veiculo veiculo = new Veiculo();
			
			veiculo.setPlaca(t.read("PLACA"));
			veiculo.setModelo(t.read("MODELO"));
			veiculo.setFabricante(t.read("FABRICANTE"));
			veiculo.setAno(Integer.parseInt(t.read("ANO")));
			
			dao.incluir(veiculo);
			
			if (!t.read("Continuar [S/N]").equalsIgnoreCase("S")) {
				break;
			}
		}
		
		dao.closeConnection();
	}

	private static void init() {
		try {
			CreateTable createTable = new CreateTable();
			boolean criou = createTable.createVeiculo();
			
			if (criou) {
				System.out.println("Tabela veiculo criada com sucesso");
			}
			
			System.out.println("Sistema iniciado");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
