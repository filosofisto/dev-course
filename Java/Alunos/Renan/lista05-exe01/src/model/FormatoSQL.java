package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormatoSQL {

	private static String arquivo = "FormatoSQL.sql";

	public static void serializarConta(Conta... contas) {
		for (Conta conta : contas) {
			FormatoSQL.serializarConta(conta);
		}
	}

	public static void serializarConta(Conta conta) {

		FileWriter escritor = null;

		try {
			escritor = new FileWriter(arquivo, true);

			escritor.write("insert into TB001_MOVIMENTACAO (CPF, COD_BANCO, COD_AGENCIA, SALDO) ");

			escritor.write(" values ('" + conta.cpf + "', '" + conta.banco + "', '" + conta.agencia + "', '"
					+ conta.saldo + "'); " + System.lineSeparator());

		} catch (IOException i) {
			i.printStackTrace();
		} finally {
			try {
				escritor.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static ArrayList<Conta> deserializarConta() throws IOException {
		ArrayList<Conta> contas = new ArrayList<Conta>();

		BufferedReader leitorBuff = null;

		try {
			FileReader leitorDeArquivo = new FileReader(arquivo);
			leitorBuff = new BufferedReader(leitorDeArquivo);

			String linha;
			String temp;
			while ((linha = leitorBuff.readLine()) != null) {
				
				linha = linha.substring(linha.lastIndexOf("values"));
				
				Conta c = new Conta();
				
				
				// Insert into TABLE FIELDS... values (VALUES...);
				linha = linha.substring(linha.indexOf('(')+1, linha.indexOf(')'));
				for (int n = 1; n < 4; ++n) {
					temp = linha.substring(2, linha.indexOf(',')-1);
					
					switch (n) {
					case 1:	// CPF
						c.setCpf(temp);
					case 2:	// Banco
						c.setBanco(temp);
						break;
					case 3:	// Agência
						c.setAgencia(temp);;
						break;
					}

					int i = linha.indexOf(',') + 1;
					linha = linha.substring(i);
				}
				//	Saldo
				temp = linha.substring(2,linha.length()-1);
				c.setSaldo(Double.parseDouble(temp));

				contas.add(c);
			}
		} catch (IOException i) {
			i.printStackTrace();
		} finally {
			try {
				leitorBuff.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return contas;
	}

}
