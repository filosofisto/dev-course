package com.cursojava;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class JAXBParserContas {

    List<Conta> parse(String filename) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Contas.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        long t1 = System.currentTimeMillis();
        Contas contas = (Contas) unmarshaller.unmarshal(new FileReader(filename));
        long t2 = System.currentTimeMillis();

        System.out.printf("Tempo de processmento: %d ms\n", (t2-t1));

        return contas.getContas();
    }
}
