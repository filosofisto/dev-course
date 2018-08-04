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
	enum Inside {
		BANCO, AGENCIA, CPF, SALDO, NONE
	};

	private long t1, t2;
	private List<Conta> contas;
	private Conta conta;
	private Inside inside;

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
			inside = Inside.NONE;
		} else if ("conta".equals(localName)) {
			conta = new Conta();
			conta.setBanco(attributes.getValue("banco"));
			conta.setAgencia(attributes.getValue("agencia"));
			conta.setCpf(attributes.getValue("cpf"));
			conta.setSaldo(Double.parseDouble(attributes.getValue("saldo")));
			contas.add(conta);
			
		} else if ("banco".equals(localName)) {
			inside = Inside.BANCO;
		} else if ("agencia".equals(localName)) {
			inside = Inside.AGENCIA;
		} else if ("cpf".equals(localName)) {
			inside = Inside.CPF;
		} else if ("saldo".equals(localName)) {
			inside = Inside.SALDO;
		} else {
			inside = Inside.NONE;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		if (isContentInvalid(content)) {
			return;
		}

		switch (inside) {
		case BANCO:
			conta.setBanco(content);
			break;
		case AGENCIA:
			conta.setAgencia(content);
			break;
		case CPF:
			conta.setCpf(content);
			break;
		case SALDO:
			conta.setSaldo(Double.parseDouble(content));
			break;
		}
	}

	private boolean isContentInvalid(String content) {
		// return content == null || content.trim().isEmpty() || content.indexOf("\n") >
		// -1 || content.indexOf("\t") > -1;
		return true; // por enquanto ...
	}
}
