package lista05;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ExportadorObject implements Exportador {

	@Override
	public void exportar(File destino, List<Conta> contas) throws IOException {

		FileOutputStream fileOut = new FileOutputStream(destino);

		ObjectOutputStream outObject = new ObjectOutputStream(fileOut);
		outObject.writeObject(contas);
		outObject.close();
	}

}
