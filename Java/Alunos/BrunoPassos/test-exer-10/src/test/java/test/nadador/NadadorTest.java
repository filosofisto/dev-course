package test.nadador;

import org.junit.Test;

import com.cursojava.Nadador;

import junit.framework.Assert;

public class NadadorTest {

	@Test(expected = Exception.class)
	public void verificaNull() throws Exception {
		Nadador nadador = new Nadador();

		nadador.setClassificacaoNadador(4);

	}

	@Test
	public void verificaClassificacao() throws Exception {
		Nadador nadador = new Nadador();
		
		String classificacao = nadador.verificaIdadeNadador(18);
		
		Assert.assertEquals(classificacao.toUpperCase(), "adulto".toUpperCase());
	}

}
