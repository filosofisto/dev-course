package com.cursojava;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
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

            List<Conta> contaList = new ArrayList<Conta>();
            contaList.add(new Conta("81646674987", "00104", "1234", 12345.76));
            contaList.add(new Conta("81646674987", "00104", "1234", 12345.76));
            contaList.add(new Conta("81646674987", "00104", "1234", 12345.76));

            Contas contas = new Contas();
            contas.setContas(contaList);

            JAXBParserContas jaxbParserContas = new JAXBParserContas();
            jaxbParserContas.save(args[0], contas);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
