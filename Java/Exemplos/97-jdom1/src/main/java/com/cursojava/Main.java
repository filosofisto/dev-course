package com.cursojava;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static java.lang.System.exit;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                out.println("Informe o caminho do arquivo XML");
                exit(-1);
            }

            DomParserContas domParserContas = new DomParserContas();
            List<Conta> contas = domParserContas.parser(args[0]);

            for (Conta conta: contas) {
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
