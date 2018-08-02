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
			//String pathIn = "\\workspace\\dev-course\\Java\\Alunos\\BrunoPassos\\arquivos\\contas.txt";
			String pathIn = "/home/eduardo/temp/contas.txt";
			File fileInput = new File(pathIn);
			Importador importador = new Importador();
			List<Conta> contas = importador.importar(fileInput);

			//String pathOut = "\\workspace\\dev-course\\Java\\Alunos\\BrunoPassos\\arquivos\\contasJson.txt";
			String pathOut = "/home/eduardo/temp/conts.json";
			File fileOutput = new File(pathOut);
			Exportador exportador = new ExportadorJson();
			exportador.exportar(fileOutput, contas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
