import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoTest {

	@Test
	void deveRetornarEhNoFolhaSoFilhoDireito() {
		No noUm = new No(new Contato("P", "123"), null, null); 
		No noDois = new No(new Contato("R", "321"), noUm, null);
		
		assertFalse(noDois.ehFolha());
		assertTrue(noUm.ehFolha());
	}
	
	@Test
	void deveRetornarEhNoFolhaSoFilhoEsquerdo() {
		No noUm = new No(new Contato("P", "123"), null, null); 
		No noDois = new No(new Contato("R", "321"), null, noUm);
		
		assertFalse(noDois.ehFolha());
		assertTrue(noUm.ehFolha());
	}
	

	@Test
	void deveRetornarEhNoFolhaDoisFilhos() {
		No noUm = new No(new Contato("P", "123"), null, null); 
		No noDois = new No(new Contato("R", "321"), null, null);
		No noTres = new No(new Contato("Q", "213"), noUm, noDois);
		
		assertFalse(noTres.ehFolha());
		assertTrue(noUm.ehFolha());
		assertTrue(noDois.ehFolha());
	}
	
	@Test
	void deveRetornarEhNoFolha() {
		No noUm = new No(new Contato("P", "123"), null, null); 
		assertTrue(noUm.ehFolha());
	}

}
