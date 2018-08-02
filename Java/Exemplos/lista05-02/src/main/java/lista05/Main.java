package lista05;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            //String pathIn = "\\workspace\\dev-course\\Java\\Alunos\\BrunoPassos\\arquivos\\contas.txt";
            /*String pathIn = "/home/eduardo/temp/contas.txt";
            File fileInput = new File(pathIn);
            Importador<Conta> importador = new ImportadorContas();
            List<Conta> contas = importador.importar(fileInput);*/

            String pathIn = "/home/eduardo/temp/veiculos.txt";
            File fileInput = new File(pathIn);
            Importador<Veiculo> importador = new ImportadorVeiculos();
            List<Veiculo> veiculos = importador.importar(fileInput);

            for (Veiculo veiculo: veiculos) {
                  System.out.println(veiculo);
            }

            //String pathOut = "\\workspace\\dev-course\\Java\\Alunos\\BrunoPassos\\arquivos\\contasJson.txt";
            /*String pathOut = "/home/eduardo/temp/contas.csv";
            File fileOutput = new File(pathOut);
            Exportador exportador = new ExportadorFormatoB();
            exportador.exportar(fileOutput, contas);*/
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
