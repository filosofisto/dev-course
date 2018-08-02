package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormatoA implements Formato<Conta> {

	// Quantidade de Caracteres
	public final static int tamanhoBanco = 5;
	public final static int tamanhoAgencia = 6;
	public final static int tamanhoCpf = 11;
	public final static int tamanhoSaldo = 18;

	@Override
	public void codificar(String arquivo, Conta... contas) throws Exception {
		FileWriter escritor = null;

		try {
			escritor = new FileWriter(arquivo);
			for (Conta conta : contas) {
				String registro = this.demonstrarCodificacao(conta);
				escritor.write(registro + System.lineSeparator());

			}
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
	public Conta[] decodificar(String arquivo) throws IOException {
		List<Conta> contas = new ArrayList<Conta>();

		FileReader leitorDeArquivo = null;

		try {
			leitorDeArquivo = new FileReader(new File(arquivo));
			BufferedReader leitorBuffered = new BufferedReader(leitorDeArquivo);

			String linha;

			do {
				linha = leitorBuffered.readLine();

				int i = 0;

				Conta conta = new Conta();

				try {
					conta.banco = linha.substring(i, tamanhoBanco);
					i = tamanhoBanco;
					conta.agencia = linha.substring(i, tamanhoAgencia);
					i = tamanhoAgencia;
					conta.cpf = linha.substring(i, tamanhoCpf);
					i = tamanhoCpf;
					System.err.println(linha.substring(linha.length()-tamanhoSaldo));
					conta.saldo = Double.parseDouble(linha.substring(linha.length()-tamanhoSaldo)) / 100;
					System.err.println(conta.saldo);

					contas.add(conta);
				} catch (NullPointerException npe) {
					break;
				}
			} while (linha != null);

		} catch (IOException i) {
			throw i;
		} finally {
			try {
				leitorDeArquivo.close();
			} catch (Exception e) {
			}
		}
		return contas.toArray(new Conta[contas.size()]);
	}

	@Override
	public String demonstrarCodificacao(Conta... contas) throws Exception {
		StringBuilder codificado = new StringBuilder();
		for (Conta conta : contas) {
			if (conta.agencia.length() < tamanhoAgencia) {
				throw new Exception("Campo Número da Agência com tamanho abaixo do aceitavel pelo formato.");
			} else if (conta.banco.length() < tamanhoBanco) {
				throw new Exception("Campo Número do Banco com tamanho abaixo do aceitavel pelo formato.");
			} else if (conta.cpf.length() < tamanhoCpf) {
				throw new Exception("Campo Número do CPF com tamanho abaixo do aceitavel pelo formato.");
			} else {
				String banco = conta.banco.substring(0, tamanhoBanco);
				String agencia = conta.agencia.substring(0, tamanhoAgencia);
				String cpf = conta.cpf.substring(0, tamanhoCpf);
				String saldo = String.format("%018d", (int) (conta.saldo * 100));

				codificado.append(banco + agencia + cpf + saldo);
			}
		}
		return codificado.toString();
	}

}
