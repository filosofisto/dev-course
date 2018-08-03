package com.cursojava;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserContas extends DefaultHandler {

    private long t1, t2;

    @Override
    public void startDocument() throws SAXException {
        t1 = currentTimeMillis();
    }

    @Override
    public void endDocument() throws SAXException {
        t2 = currentTimeMillis();
        out.printf("Tempo de processamento: %d ms\n", (t2-t1));
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        out.printf("startElement->uri: %s, localName: %s, qName: %s\n", uri, localName, qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        out.printf("endElement->uri: %s, localName: %s, qName: %s\n", uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        out.printf("%s\n", new String(ch, start, length));
    }
}
