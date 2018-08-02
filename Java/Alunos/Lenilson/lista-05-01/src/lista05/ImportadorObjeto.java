package lista05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ImportadorObjeto {
	
	public List<Conta> importar(File file) throws IOException{
		List<Conta> list = new ArrayList<Conta>();
		
		ObjectInputStream obj = new ObjectInputStream(new FileInputStream(file));
		try {
			list = (List<Conta>) obj.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
}
