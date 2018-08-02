package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FormatoJSON implements Formato<Conta> {

	@Override
	public void codificar(String arquivo, Conta... contas) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		// Object para JSON em arquivo
		mapper.writeValue(new File(arquivo), contas);
	}

	@Override
	public Conta[] decodificar(String arquivo) throws Exception {
		Conta[] contas = null;
		
		ObjectMapper mapper = new ObjectMapper();

		//JSON do arquivo para Object
		contas = mapper.readValue(new File(arquivo), Conta[].class);
		
		return contas;
	}

	@Override
	public String demonstrarCodificacao(Conta... contas) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		// Object para JSON em String
		return mapper.writeValueAsString(contas);
	}

}
