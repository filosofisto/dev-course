package lista05;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Importador<T> {

    List<T> importar(File file) throws IOException;
}
