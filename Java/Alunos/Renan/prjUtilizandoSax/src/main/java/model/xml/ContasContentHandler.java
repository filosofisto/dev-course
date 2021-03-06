package model.xml;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Conta;

public class ContasContentHandler extends DefaultHandler {

	private long t1, t2;
	private List<Conta> contas;
	private Conta conta;

	public List<Conta> getContas() {
		return contas;
	}

	@Override
	public void startDocument() throws SAXException {
		t1 = currentTimeMillis();
	}

	@Override
	public void endDocument() throws SAXException {
		t2 = currentTimeMillis();
		out.printf("Tempo de processamento: %d ms\n", (t2 - t1));
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if ("contas".equals(localName)) {
			contas = new ArrayList<Conta>();
		} else if ("conta".equals(localName)) {
			conta = new Conta();
			conta.setBanco(attributes.getValue("banco"));
			conta.setAgencia(attributes.getValue("agencia"));
			conta.setCpf(attributes.getValue("cpf"));
			conta.setSaldo(Double.parseDouble(attributes.getValue("saldo")));
			contas.add(conta);
		}
	}
}
