package lista05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorScriptSQL implements Exportador {

	@Override
	public void exportar(File destino, List<Conta> contas) throws IOException {

		
		PrintWriter out = new PrintWriter(destino);
		
		for(Conta conta: contas) {
			out.printf("insert into TB001_MOVIMENTACAO "
					+ "(CPF,COD_BANCO,COD_AGENCIA,SALDO) values('%s','%s','%s','%.2f');",
					conta.getCpf(),conta.getNumeroDoBanco(),conta.getNumeroDaAgencia(),conta.getSaldoConta());
		}
		out.close();
	}

}
