package lista05;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Importador {

	public List<Conta> importar(File file) throws IOException{
		List<Conta> list = new ArrayList<Conta>();

        String linha;
        Conta conta;
        Scanner scanner = new Scanner(file).useDelimiter("\n");
        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            conta = processaLinha(linha);
            list.add(conta);
        }

        return list;
    }

    private Conta processaLinha(String linha) {
        Conta conta = new Conta();

        conta.setBanco(linha.substring(0,5));
        conta.setAgencia(linha.substring(5,11));
        conta.setCpf(linha.substring(11,22));
        conta.setSaldo(Double.parseDouble(linha.substring(22,40))/100);

        return conta;
    }
}
