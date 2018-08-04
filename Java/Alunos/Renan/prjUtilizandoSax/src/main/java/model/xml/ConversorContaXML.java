package model.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import model.Conta;

public class ConversorContaXML {
	public List<Conta> passarLista(String filename) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxPF = SAXParserFactory.newInstance();
		saxPF.setNamespaceAware(true);
		SAXParser conversorSAX = saxPF.newSAXParser();
		

		XMLReader leitorXML = conversorSAX.getXMLReader();
		ContasContentHandler contasCH = new ContasContentHandler();
		leitorXML.setContentHandler(contasCH);
		leitorXML.parse(converterParaArquivoURL(filename));

		return contasCH.getContas();
	}

	private String converterParaArquivoURL(String filename) {
		String caminho = new File(filename).getAbsolutePath();
		if (File.separatorChar != '/') {
			caminho = caminho.replace(File.separatorChar, '/');
		}

		if (!caminho.startsWith("/")) {
			caminho = "/" + caminho;
		}
		return "file:" + caminho;
	}
}
