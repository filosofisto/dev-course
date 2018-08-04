package com.cursojava;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DomParserContas {

    public List<Conta> parse(String filename) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(false);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(true);

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        OutputStreamWriter errorWriter = new OutputStreamWriter(System.err, "UTF-8");
        documentBuilder.setErrorHandler(new ContasErrorHandler(new PrintWriter(errorWriter, true)));

        long t1 = System.currentTimeMillis();

        Document doc = documentBuilder.parse(new File(filename));

        NodeList contasNodeList = doc.getChildNodes().item(0).getChildNodes();
        Node nodeContas, nodeConta;
        List<Conta> contas = new ArrayList<Conta>();
        Conta conta;

        for (int i = 0; i < contasNodeList.getLength(); i++) {
            nodeContas = contasNodeList.item(i);
            if ("conta".equals(nodeContas.getNodeName())) {
                conta = new Conta();
                contas.add(conta);

                NodeList nodesContaChildren = nodeContas.getChildNodes();
                for (int j = 0; j < nodesContaChildren.getLength(); j++) {
                    nodeConta = nodesContaChildren.item(j);
                    if ("banco".equals(nodeConta.getNodeName())) {
                        conta.setBanco(nodeConta.getTextContent());
                    } else if ("agencia".equals(nodeConta.getNodeName())) {
                        conta.setAgencia(nodeConta.getTextContent());
                    } else if ("cpf".equals(nodeConta.getNodeName())) {
                        conta.setCpf(nodeConta.getTextContent());
                    } else if ("saldo".equals(nodeConta.getNodeName())) {
                        conta.setSaldo(Double.parseDouble(nodeConta.getTextContent()));
                    }
                }
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.printf("Tempo de processmento: %d ms\n", (t2-t1));

        return contas;
    }

    private static class ContasErrorHandler implements ErrorHandler {

        private PrintWriter out;

        ContasErrorHandler(PrintWriter out) {
            this.out = out;
        }

        private String getParseExceptionInfo(SAXParseException spe) {
            String systemId = spe.getSystemId();
            if (systemId == null) {
                systemId = "null";
            }

            String info = "URI=" + systemId + " Line=" + spe.getLineNumber() + ": " + spe.getMessage();
            return info;
        }

        public void warning(SAXParseException spe) throws SAXException {
            out.println("Warning: " + getParseExceptionInfo(spe));
        }

        public void error(SAXParseException spe) throws SAXException {
            String message = "Error: " + getParseExceptionInfo(spe);
            throw new SAXException(message);
        }

        public void fatalError(SAXParseException spe) throws SAXException {
            String message = "Fatal Error: " + getParseExceptionInfo(spe);
            throw new SAXException(message);
        }
    }

}
