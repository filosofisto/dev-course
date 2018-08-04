package com.cursojava;

import javax.xml.bind.JAXBException;
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

            JAXBParserContas jaxbParserContas = new JAXBParserContas();
            List<Conta> contas = jaxbParserContas.parse(args[0]);

            for (Conta conta : contas) {
                out.println(conta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
