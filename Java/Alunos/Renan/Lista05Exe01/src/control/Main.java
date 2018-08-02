package control;

import static java.lang.System.out;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.Conta;
import model.FormatoA;
import model.FormatoB;
import model.FormatoJSON;
import model.FormatoSQL;
import model.FormatoXML;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		String nome = "Arquivo";

		out.println("\n\t\t Roteiro deste Programa:" + "\n\t 1. Escrever� no Formato A (posicional)"
				+ "\n\t 2. Ir� ler no Formato A" + "\n\t 2. Depois ir� Exportar para os seguintes formatos:"
				+ "\n\t 2.1. Formato B (cvs)" + "\n\t 2.2. Script SQL" + "\n\t 2.3. XML 1" + "\n\t 2.4. XML 2"
				+ "\n\t 2.5. JSON" + "\n\t 2.6. Objeto"
						+ "\n\t Arquivos s�o gerados na raiz do projeto."
						+ "\n\n\t\t Pressione [ENTER] para continuar.");
		
		new Scanner(System.in).nextLine();
		System.gc();

		Random r = new Random();

		int n = (r.nextInt(4) + 2);

		List<Conta> temp = new ArrayList<Conta>();

		do {
			temp.add(new Conta("Teste", String.format("%011d", r.nextInt(n) + 1),
					String.format("%05d", r.nextInt(n) + 1), String.format("%06d", r.nextInt(n) + 11),
					1.5 * (r.nextInt(n) + 1)));
		} while (--n > 0);

		Conta[] contas = temp.toArray(new Conta[temp.size()]);
		System.gc();

		out.println("\n\t Contas geradas:");
		for (Conta conta : contas) {
			out.println(conta.toString());
		}

		out.println("\n\t Formato A:");
		FormatoA fa = new FormatoA();		
		String arquivo = nome + ".txt";
		out.println(fa.demonstrarCodificacao(contas));
		fa.codificar(arquivo, contas);
		Conta[] lidas = fa.decodificar(arquivo);

		out.println("\n\t Contas lidas a partir do Arquivo no Formato A:");
		for (Conta conta : lidas) {
			out.println(conta.toString());
		}

		out.println("\n\t Importa do Formato A e Exporta para o Formato B:");
		FormatoB fb = new FormatoB();

		arquivo = nome + ".cvs";
		out.println(fb.demonstrarCodificacao(lidas));
		fb.codificar(arquivo, lidas);
		lidas = fb.decodificar(arquivo);

		out.println("\n\t Contas lidas a partir do Arquivo no Formato B:");
		for (Conta conta : lidas) {
			out.println(conta.toString());
		}
		
		out.println("\n\t Importa do Formato A e Exporta para o Formato XML:");
		FormatoXML fxml = new FormatoXML();

		arquivo = nome + ".xml";
		//out.println(fxml.demonstrarCodificacao(lidas));
		fxml.codificar(arquivo, lidas);
		lidas = fxml.decodificar(arquivo);

		out.println("\n\t Contas lidas a partir do arquivo "+arquivo);
		for (Conta conta : lidas) {
			out.println(conta.toString());
		}
		
		out.println("\n\t Importa do Formato A e Exporta para o Formato SQL Script:");
		FormatoSQL fsql = new FormatoSQL();

		arquivo = nome + ".sql";
		out.println(fsql.demonstrarCodificacao(lidas));
		fsql.codificar(arquivo, lidas);
		lidas = fsql.decodificar(arquivo);

		out.println("\n\t Contas lidas a partir do arquivo "+arquivo);
		for (Conta conta : lidas) {
			out.println(conta.toString());
		}
		

		out.println("\n\t Importa do Formato A e Exporta para o Formato JSON:");
		FormatoJSON fjson = new FormatoJSON();

		arquivo = nome + ".json";
		//out.println(fxml.demonstrarCodificacao(lidas));
		fjson.codificar(arquivo, lidas);
		lidas = fjson.decodificar(arquivo);

		out.println("\n\t Contas lidas a partir do arquivo "+arquivo);
		for (Conta conta : lidas) {
			out.println(conta.toString());
		}
		
				
		// SERIALIZAÇÃO
		out.println("\n\t Serialização de um objeto Conta");
		Conta c = new Conta("Fulano", "343424", "BANCO", "PERTO", 1000.00);
		out.println(c.toString());
		
		arquivo = "classeSerializada";

		// Codigo Serializado
		try {
			FileOutputStream fileOut = new FileOutputStream(arquivo);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(c);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		// De-Serializando Codigo
		Conta desceliarizada = null;
		try {
			FileInputStream fileIn = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fileIn);
			desceliarizada = (Conta) ois.readObject();
			ois.close();
			fileIn.close();

			out.println("\t Deserializada do arquivo "+arquivo);
			out.println(desceliarizada.toString());
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	}

}
