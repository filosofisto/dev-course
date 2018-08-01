package lista05;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try {
			File fileInput = new File("/home/eduardo/temp/contas.txt");
			Importador importador = new Importador();
			List<Conta> contas = importador.importar(fileInput);

			File fileOutput = new File("/home/eduardo/temp/contas.xml");
			Exportador exportador = new ExportadorXml1();
			exportador.exportar(fileOutput, contas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
