package lista05;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ExportadorObject implements Exportador {
    public void exportar(File destino, List<Conta> contas) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(destino));
        out.writeObject(contas);
        out.close();
    }
}
