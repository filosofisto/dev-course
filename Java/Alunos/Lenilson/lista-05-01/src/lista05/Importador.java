package lista05;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Importador {

	public List<Conta> importadorPos(File file) throws IOException{
		List<Conta> list = new ArrayList<>();
		
		String linha;
		Conta conta;
		Scanner scanner = new Scanner(file).useDelimiter("\n");
		
		while(scanner.hasNextLine()) {
			linha = scanner.nextLine();
			//conta = ;
		}
		
		
		return list;
	}
}
