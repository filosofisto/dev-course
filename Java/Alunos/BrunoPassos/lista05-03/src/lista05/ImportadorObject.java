package lista05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ImportadorObject {

	public List<Conta> importaObjeto(File file) throws IOException, ClassNotFoundException {
		
		FileInputStream fileInput = new FileInputStream(file);

		List<Conta> contas = new ArrayList<>();
		ObjectInputStream objInput = new ObjectInputStream(fileInput);

		contas = (List<Conta>) objInput.readObject();

		objInput.close();

		return contas;

	}

}
