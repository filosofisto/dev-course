package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FormatoB {

	private static String arquivo = "FormatoB.text";
	public static void serializarConta(Conta conta) {

		PrintWriter escritor = null;

		try {
			escritor = new PrintWriter(arquivo);
			escritor.print(conta.getCpf() + ";" + conta.getBanco() + ";" + conta.getAgencia() + ";" + conta.getSaldo());
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

	public static Conta deserializarConta() throws IOException {

		Conta conta = null;

		BufferedReader leitorBuff = null;

		try {
			FileReader leitorDeArquivo = new FileReader(arquivo);
			leitorBuff = new BufferedReader(leitorDeArquivo);

			String linha = leitorBuff.readLine();

			conta = new Conta();

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
			
			conta.setSaldo(Double.parseDouble(temp));

		} catch (IOException i) {
			i.printStackTrace();
		} finally {
			try {
				leitorBuff.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return conta;
	}

}
