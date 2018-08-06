package cursojava.sax;

import static java.lang.System.exit;
import static java.lang.System.out;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                out.println("Informe o caminho do arquivo XML");
                exit(-1);
            }

            SAXParserContas saxParserContas = new SAXParserContas();
            List<Conta> contas = saxParserContas.parse(args[0]);

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
