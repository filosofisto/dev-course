package junit01;

import org.junit.Assert;
import org.junit.Test;

public class NadadorTest {

	@Test
	public void testCategoriaMenor5() {
		Nadador nadador = new Nadador("Pedro", 3);
		
		for (int i = -1; i < 5; i++) {
			try {
				nadador.setIdade(i);
				nadador.categoria();
				Assert.fail("Exception esperada!");
			} catch (Exception e) {
				// Exception esperada
			}
		}
		
	}
	
	@Test
	public void testCategoriaInfantilA() throws Exception {
		Nadador nadador = new Nadador("Pedro", 7);
		String categoria = nadador.categoria();
		
		Assert.assertEquals("Infantil A", categoria);
	}
	
	@Test
	public void testCategoriaInfantilB() throws Exception {
		Nadador nadador = new Nadador("Pedro", 10);
		String categoria = nadador.categoria();
		
		Assert.assertEquals("Infantil B", categoria);
	}
	
	@Test
	public void testCategoriaJuvenilA() throws Exception {
		Nadador nadador = new Nadador("Pedro", 13);
		String categoria = nadador.categoria();
		
		Assert.assertEquals("Juvenil A", categoria);
	}
	
	@Test
	public void testCategoriaJuvenilB() throws Exception {
		Nadador nadador = new Nadador("Pedro", 17);
		String categoria = nadador.categoria();
		
		Assert.assertEquals("Juvenil B", categoria);
	}
	
	@Test
	public void testCategoriaAdulto() throws Exception {
		Nadador nadador = new Nadador("Pedro", 18);
		String categoria = nadador.categoria();
		
		Assert.assertEquals("Adulto", categoria);
	}
	
	@Test
	public void testGetNome() {
		Nadador nadador = new Nadador("Pedro", 18);
		String nome = nadador.getNome();
		
		Assert.assertEquals("Pedro", nome);
	}
	
	@Test
	public void testGetIdade() {
		Nadador nadador = new Nadador("Pedro", 18);
		int idade = nadador.getIdade();
		
		Assert.assertEquals(18, idade);
	}

}
