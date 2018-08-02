package model;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormatoJSON {

	private static String arquivo = "FormatoJSON.json";

	public static void serializarConta(Conta... contas) throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		// Object to JSON in file
		mapper.writeValue(new File(arquivo), contas);

		// Object to JSON in String
		String jsonInString = mapper.writeValueAsString(contas);
		System.err.println(jsonInString);
	}

}
