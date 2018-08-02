package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormatoXML1 {

	private static String arquivo = "FormatoXML1.xml";

	public static void serializarConta(Conta... contas) {
		for (Conta conta : contas) {
			FormatoSQL.serializarConta(conta);
		}
	}

	public static void serializarConta(Conta conta) throws Exception {

		XMLEncoder encoder = null;

		try {
			try {
				encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(arquivo)));
			} catch (FileNotFoundException fileNotFound) {
				throw new FileNotFoundException("Erro equanto criava ou abia o arquivo " + arquivo);
			}
			encoder.writeObject(conta);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			encoder.close();
		}
	}

	public static List<Conta> deserializarConta() throws IOException {
		List<Conta> contas = new ArrayList<Conta>();

		FileInputStream leitor = null;
		XMLDecoder decodificador = null;
		try {
			leitor = new FileInputStream(arquivo);
			decodificador = new XMLDecoder(leitor);
			Conta conta = null;
			do {
				conta = (Conta) decodificador.readObject();

				contas.add(conta);
			} while (conta != null);
		} catch (IOException i) {
			i.printStackTrace();
		} finally {
			try {
				decodificador.close();
			} catch (Exception e) {
			}
			try {
				leitor.close();
			} catch (Exception e) {
			}
		}
		return contas;
	}
}
