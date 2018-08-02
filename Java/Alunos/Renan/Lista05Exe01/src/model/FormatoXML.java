package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormatoXML implements Formato<Conta> {

	public void codificar(String arquivo, Conta... contas) throws Exception {

		XMLEncoder encoder = null;

		try {
			try {
				encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(arquivo)));
			} catch (FileNotFoundException fileNotFound) {
				throw new FileNotFoundException("Erro equanto criava ou abia o arquivo " + arquivo);
			}
			encoder.writeObject(contas);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			encoder.close();
		}
	}

	public Conta[] decodificar(String arquivo) throws IOException {
		List<Conta> contas = new ArrayList<Conta>();

		FileInputStream leitor = null;
		XMLDecoder decodificador = null;
		try {
			leitor = new FileInputStream(arquivo);
			decodificador = new XMLDecoder(leitor);

			contas = new ArrayList<Conta>(Arrays.asList((Conta[]) decodificador.readObject()));

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
		return contas.toArray(new Conta[contas.size()]);
	}

	@Override
	public String demonstrarCodificacao(Conta...contas) throws Exception {
		throw new UnsupportedOperationException("Ainda não implementado!");
	}

}
