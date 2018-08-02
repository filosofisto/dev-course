package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FormatoA {

	private static String arquivo = "FormatoA.txt";

	private static String indicador = ": ";

	private static String campo_banco = "Número do Banco";
	private static int tamanho_banco = 5;
	private static String campo_agencia = "Número da Agência";
	private static int tamanho_agencia = 6;
	private static String campo_cpf = "CPF do cliente";
	private static int tamanho_cpf = 11;
	private static String campo_saldo = "Saldo da Conta";
	private static int tamanho_saldo = 18;

	public static void serializarConta(Conta conta) {

		PrintWriter escritor = null;

		try {
			escritor = new PrintWriter(arquivo);
			StringBuilder texto = new StringBuilder();

			// Campo do Banco
			texto.append(campo_banco + indicador);
			if (conta.getBanco().length() > tamanho_banco) {
				texto.append(conta.getBanco().substring(0, tamanho_banco));
			} else {
				texto.append(conta.getBanco() + "                            ");
			}
			escritor.println(texto);

			// Campo da Agência
			texto = new StringBuilder();
			texto.append(campo_agencia + indicador);
			if (conta.getAgencia().length() > tamanho_agencia) {
				texto.append(conta.getAgencia().substring(0, tamanho_agencia));
			} else {
				texto.append(conta.getAgencia() + "                           ");
			}
			escritor.println(texto);

			// Campo do CPF
			texto = new StringBuilder();
			texto.append(campo_cpf + indicador);
			if (conta.getCpf().length() > tamanho_cpf) {
				texto.append(conta.getCpf().substring(0, tamanho_cpf));
			} else {
				texto.append(conta.getCpf() + "                        ");
			}
			escritor.println(texto);

			// Campo do Saldo
			texto = new StringBuilder();
			texto.append(campo_saldo + indicador);
			if (String.valueOf((int) Math.floor(conta.getSaldo())).length() > tamanho_saldo) {
				texto.append(String.valueOf((int) Math.floor(conta.getSaldo())).substring(0, tamanho_saldo));
			} else {
				texto.append(String.valueOf((int) Math.floor(conta.getSaldo())) + "                          ");
			}
			escritor.println(texto);

		} catch (IOException i) {
			i.printStackTrace();
		} finally {
			if (escritor != null) {
				escritor.close();
			}

		}
	}

	public static Conta deserializarConta() throws IOException {

		Conta deserializada = null;

		BufferedReader leitorBuff = null;

		try {
			FileReader leitorDeArquivo = new FileReader(arquivo);
			leitorBuff = new BufferedReader(leitorDeArquivo);

			String linha;

			deserializada = new Conta();

			// Banco
			linha = leitorBuff.readLine();
			linha = linha.substring(campo_banco.length() + indicador.length(),
					campo_banco.length() + tamanho_banco + indicador.length());
			deserializada.setBanco(linha);

			// Agencia
			linha = leitorBuff.readLine();
			linha = linha.substring(campo_agencia.length() + indicador.length(),
					campo_agencia.length() + tamanho_agencia + indicador.length());
			deserializada.setAgencia(linha);

			// CPF
			linha = leitorBuff.readLine();
			linha = linha.substring(campo_cpf.length() + indicador.length(),
					campo_cpf.length() + tamanho_cpf + indicador.length());
			deserializada.setCpf(linha);

			// Saldo
			linha = leitorBuff.readLine();
			linha = linha.substring(campo_cpf.length() + indicador.length(),
					campo_cpf.length() + tamanho_cpf + indicador.length());
			deserializada.setSaldo(Double.parseDouble(linha));

//			while ((linha = leitorBuff.readLine()) != null) {
//				
//			}

		} catch (IOException i) {
			i.printStackTrace();
		} finally {
			if (leitorBuff != null) {
				leitorBuff.close();
			}
		}

		return deserializada;
	}

}
