package lista05;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Exportador {

	void exportar(File destino, List<Conta> contas) throws IOException;
}
