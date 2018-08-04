package control;

import static java.lang.System.exit;
import static java.lang.System.out;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import model.Conta;
import model.xml.ConversorContaXML;

public class Main {

	public static void main(String[] args) {
		try {
			String arquivo = null;
			if (args.length < 1) {
				arquivo = "arquivo.xml";
			} else {
				arquivo = args[0];
			}
			
			ConversorContaXML conversor = new ConversorContaXML();
			List<Conta> contas = conversor.passarLista(arquivo);

			for (Conta conta : contas) {
				out.println(conta);
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
