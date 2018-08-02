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
			String pathIn = "C:\\dev-course\\Java\\Alunos\\Lenilson\\arquivos\\contas.txt";
			//String pathIn = "/home/eduardo/temp/contas.txt";
			File fileInput = new File(pathIn);
			Importador importador = new Importador();
			List<Conta> contas = importador.importar(fileInput);

			String pathOut = "C:\\dev-course\\Java\\Alunos\\Lenilson\\arquivos\\contasOBJ";
			//String pathOut = "/home/eduardo/temp/conts.json";
			File fileOutput = new File(pathOut);
			ExportadorObjeto exportador = new ExportadorObjeto();
			exportador.exportar(fileOutput, contas);
			
			ImportadorObjeto importadorObj = new ImportadorObjeto();
			List<Conta> contasObj = importadorObj.importar(fileOutput);
			
			System.out.println("Contas importadas atraves de Objeto");
			for (Conta conta: contasObj) {
				System.out.println(conta);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
