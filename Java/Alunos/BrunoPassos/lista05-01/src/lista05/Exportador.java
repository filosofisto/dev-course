package lista05;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class Exportador {

	void exportar(File destino, List<Conta> contas) throws IOException{
		
	}
	String exportar(File destino, List<Conta> contas, String root) 
			throws IOException, NoSuchMethodException, SecurityException, 
			IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		return null;
	}
}
