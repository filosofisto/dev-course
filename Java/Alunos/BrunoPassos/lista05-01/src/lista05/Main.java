package lista05;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try {
			
						
			File fileInput = new File("\\workspace\\dev-course\\Java\\Alunos\\BrunoPassos\\arquivos\\contas.txt");
			Importador importador = new Importador();
			List<Conta> contas = importador.importar(fileInput);

			File fileOutput = new File("\\workspace\\dev-course\\Java\\Alunos\\BrunoPassos\\arquivos\\contasJson.txt");
			Exportador exportador = new ExportadorJson();
			exportador.exportar(fileOutput, contas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
