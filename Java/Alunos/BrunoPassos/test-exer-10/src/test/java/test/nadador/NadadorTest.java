package test.nadador;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cursojava.Nadador;

import junit.framework.Assert;

public class NadadorTest {

	private Nadador nadador;

	@Before
	public void setUp() {
		nadador = new Nadador();
	}

	@Test
	public void verificaIdadeForaDaFaixa() {
		for (int i = -1; i < 5; i++) {
			try {
				nadador.setClassificacaoNadador(i);
				Assert.fail("Exception esperada");
			} catch (Exception e) {
				// Esperado
			}
		}
	}

	@Test
	public void verificaClassificacaoAdulto() throws Exception {
		String classificacao = nadador.verificaIdadeNadador(18);
		
		Assert.assertEquals(classificacao.toUpperCase(), "adulto".toUpperCase());
	}

	@Test
	public void verificaClassificacaoInfantil() throws Exception {
		String classificacao = nadador.verificaIdadeNadador(5);
		Assert.assertEquals(classificacao.toUpperCase(), "infantil a".toUpperCase());

		classificacao = nadador.verificaIdadeNadador(6);
		Assert.assertEquals(classificacao.toUpperCase(), "infantil a".toUpperCase());

		classificacao = nadador.verificaIdadeNadador(7);
		Assert.assertEquals(classificacao.toUpperCase(), "infantil a".toUpperCase());

		classificacao = nadador.verificaIdadeNadador(8);
		Assert.assertNotSame(classificacao.toUpperCase(), "infantil a".toUpperCase());
	}
}
