package lista05;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			String pathIn = "C:\\workspace\\temp\\contasObj.txt";
//			String pathIn = "/home/eduardo/temp/contas.txt";
			File fileInput = new File(pathIn);
			ImportadorObject importadorObject = new ImportadorObject();
			List<Conta> contas = importadorObject.importaObjeto(fileInput);
			
			//String pathOut = "\\workspace\\dev-course\\Java\\Alunos\\BrunoPassos\\arquivos\\contasJson.txt";
//			String pathOut = "/home/eduardo/temp/conts.obj";
			String pathOut = "C:\\workspace\\temp\\sql";
			File fileOutput = new File(pathOut);
			Exportador exportador = new ExportadorScriptSQL();
			exportador.exportar(fileOutput, contas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
