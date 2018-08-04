package com.cursojava;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    public void save(String filename, Contas contas) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Contas.class);
        Marshaller marshaller = context.createMarshaller();

        long t1 = System.currentTimeMillis();
        marshaller.marshal(contas, new FileWriter(filename));
        long t2 = System.currentTimeMillis();

        System.out.printf("Tempo de processmento: %d ms\n", (t2-t1));
    }
}
