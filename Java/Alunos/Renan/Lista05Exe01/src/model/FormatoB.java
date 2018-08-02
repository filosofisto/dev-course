package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormatoB implements Formato<Conta> {

	private static String separador = ";";

	@Override
	public void codificar(String arquivo, Conta... contas) throws Exception {
		FileWriter escritor = null;

		try {
			escritor = new FileWriter(new File(arquivo));
			escritor.write(demonstrarCodificacao(contas));

		} catch (IOException i) {
			throw i;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				escritor.close();
			} catch (Exception e) {
			}
		}

	}

	@Override
	public Conta[] decodificar(String arquivo) throws Exception {
		List<Conta> contas = new ArrayList<Conta>();
		
		Scanner leitor = null;
		try {
			leitor = new Scanner(new File(arquivo));
			
			while(leitor.hasNextLine()) {
				String linha =  leitor.nextLine();
				
				Conta conta = new Conta();

				String temp;
				int index = 0;
				for (int n = 1; n < 4; n++) {
					temp = linha.substring(0, linha.indexOf(';'));
					
					switch(n) {
					case 1:
						conta.setCpf(temp);
						break;
					case 2:
						conta.setBanco(temp);
						break;
					case 3:
						conta.setAgencia(temp);
						break;
					}
					
					index = linha.indexOf(';')+1;
					linha = linha.substring(index);
				}
				
				temp = linha;
				
				conta.setSaldo(Double.parseDouble(temp)/100);
				
				contas.add(conta);
				
			}
			
		}catch(IOException i) {
			throw i;
		}finally {
			try {
				leitor.close();
			}catch(Exception e) {
				
			}
		}
		
		
		return contas.toArray(new Conta[contas.size()]);
	}

	@Override
	public String demonstrarCodificacao(Conta... contas) throws Exception {
		StringBuilder registros = new StringBuilder();

		for (Conta conta : contas) {
			registros.append(conta.cpf + separador + conta.banco + separador + conta.agencia + separador
					+ ((int) (conta.saldo * 100)) + System.lineSeparator());
		}
		return registros.toString();
	}

}
