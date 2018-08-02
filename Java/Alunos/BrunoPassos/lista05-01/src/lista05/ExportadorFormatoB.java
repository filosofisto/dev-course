package lista05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorFormatoB implements Exportador {

	@Override
	public void exportar(File destino, List<Conta> contas) throws IOException {

		PrintWriter out = new PrintWriter(destino);
		
		for(Conta conta: contas) {
			out.printf("%s;%s;%s;%.2f", conta.getNumeroDoBanco(), conta.getNumeroDaAgencia(), conta.getCpf(), conta.getSaldoConta());
		}
		
		out.close();


	}

}
