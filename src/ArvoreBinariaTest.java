import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArvoreBinariaTest {

	private ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
	private ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder();

	@BeforeEach
	void inicializarArvore() {
		arvore = new ArvoreBinariaBusca();
	}

	@Test
	void deveRetornarEhVaziaSemRaiz() {
		assertTrue(arvore.ehVazia());
	}

	@Test
	void deveRetornarNaoEhVaziaComRaiz() {
		No noA = new No(new Contato("A","1"), null, null);
		arvore.setRaiz(noA);

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.pegaQuantidadeNos());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(1, arvore.pegaQuantidadeNos());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		assertEquals(2, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		assertEquals(2, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		assertEquals(3, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		assertEquals(4, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		assertEquals(4, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		assertEquals(5, arvore.pegaQuantidadeNos());

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertEquals(7, arvore.pegaQuantidadeNos());

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.pegaAlturaDaArvore());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(0, arvore.pegaAlturaDaArvore());
	}

	@Test
	void deveRetornarAlturaSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		assertEquals(1, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		assertEquals(1, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		assertEquals(1, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertEquals(2, arvore.pegaAlturaDaArvore());

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarAlturaSubNosComElementos() {

		arvore = builder.montaArvoreCheiaDoisNiveis();
		No noC = arvore.getRaiz().getEsquerdo();

		assertEquals(1, arvore.pegaAlturaDoNo(noC));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.pegaProfundidadeDoNo(noRef));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		No noRef = arvore.getRaiz();
		assertEquals(0, arvore.pegaProfundidadeDoNo(noRef));
	}

	@Test
	void deveRetornarProfundidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreRaizFilhoDireito();
		No noRef = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizFilhoEsquerdo();
		noRef = arvore.getRaiz().getEsquerdo();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizFilhoDireitoEsquerdo();
		noRef = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		noRef = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();
		noRef = arvore.getRaiz().getDireito().getDireito();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreRaizDoisFilhoDireitoDoisEsquerdo();
		noRef = arvore.getRaiz().getDireito().getDireito();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		noRef = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.pegaProfundidadeDoNo(noRef));

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarNullSePegarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertNull(arvore.pegarNoArvorePorNome("Z"));
	}

	@Test
	void deveRetornarNullSePegarNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertNull(arvore.pegarNoArvorePorNome("Z"));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertNull(arvore.pegarNoArvorePorNome("Z"));
	}

	@Test
	void deveRetornarNoSePegarRaiz() {
		arvore = builder.montaArvoreSoRaiz();

		No noRetornado = arvore.pegarNoArvorePorNome("E");

		assertNotNull(noRetornado);
		assertEquals("E", noRetornado.getNome());
	}

	@Test
	void deveRetornarNoSePegarOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();

		No noRetornado = arvore.pegarNoArvorePorNome("C");

		assertNotNull(noRetornado);
		assertEquals("C", noRetornado.getNome());
	}

	@Test
	void deveRetornarFalseContemArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertFalse(arvore.contem("Z"));
	}

	@Test
	void deveRetornarFalseContemNoNaoExistente() {
		arvore = builder.montaArvoreSoRaiz();
		assertFalse(arvore.contem("Z"));

		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertFalse(arvore.contem("Z"));
	}

	@Test
	void deveRetornarTrueContemSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertTrue(arvore.contem("E"));
	}

	@Test
	void deveRetornarNoComtemOutroElemento() {
		arvore = builder.montaArvoreCheiaDoisNiveis();
		assertTrue(arvore.contem("C"));
		assertTrue(arvore.contem("D"));
		assertTrue(arvore.contem("A"));
	}


	@Test
	void adicionarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();

		arvore.adicionaNo("E", "5");

		assertEquals(0, arvore.pegaAlturaDaArvore());
		assertEquals("E", arvore.getRaiz().getNome());
		assertTrue(arvore.contem("E"));
	}

	@Test
	void adicionarNoArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();

		arvore.adicionaNo("G", "7");

		assertEquals(1, arvore.pegaAlturaDaArvore());
		assertEquals("E", arvore.getRaiz().getNome());
		assertTrue(arvore.contem("G"));
	}

	@Test
	void adicionarNoArvoreComElementosSoFilhoDireito() {

		arvore = builder.montaArvoreRaizFilhoDireito();

		arvore.adicionaNo("C", "3");

		assertEquals(1, arvore.pegaAlturaDaArvore());
		assertEquals("E", arvore.getRaiz().getNome());
		assertTrue(arvore.contem("C"));
	}

	@Test
	void adicionarNoArvoreComElementosSoFilhoEsquerdo() {

		arvore = builder.montaArvoreRaizFilhoEsquerdo();

		arvore.adicionaNo("G", "7");

		assertEquals(1, arvore.pegaAlturaDaArvore());
		assertEquals("E", arvore.getRaiz().getNome());
		assertTrue(arvore.contem("G"));
	}

	@Test
	void adicionarNoArvoreComElementosDoisFilhosDireitoEsquerdo() {

		arvore = builder.montaArvoreCheiaDoisNiveis();

		arvore.adicionaNo("B", "2");

		assertEquals(3, arvore.pegaAlturaDaArvore());
		assertEquals("E", arvore.getRaiz().getNome());
		assertTrue(arvore.contem("B"));
	}

	@Test
	void removerNoArvoreSoRaizValorExiste() {
		arvore = builder.montaArvoreSoRaiz();

		arvore.removeNoPorNome("E");
		assertFalse(arvore.contem("E"));
		assertNull(arvore.getRaiz());
	}
	
	@Test
	void removerNoArvoreSoRaizValorNaoExiste() {
		arvore = builder.montaArvoreSoRaiz();

		arvore.removeNoPorNome("EE");
		assertTrue(arvore.contem("E"));
		assertNotNull(arvore.getRaiz());
	}

	@Test
	void removerNoArvoreNaoFolhaSoFilhoDireito() {

		arvore = builder.montaArvoreRaizDoisFilhoDireitoUmEsquerdo();

		arvore.removeNoPorNome("G");

		assertEquals("E", arvore.getRaiz().getNome());
		assertFalse(arvore.contem("G"));
		assertEquals(1, arvore.pegaAlturaDaArvore());
		
	}

	@Test
	void removerNoArvoreNaoFolhaSoFilhoEsquerdo() {

		arvore = builder.montaArvoreRaizUmFilhoDireitoDoisEsquerdo();
		
		arvore.removeNoPorNome("C");

		assertEquals("E", arvore.getRaiz().getNome());
		assertFalse(arvore.contem("C"));
		assertEquals(1, arvore.pegaAlturaDaArvore());
	}

	@Test
	void removerNoArvoreComElementosDoisFilhosDireitoEsquerdo() {

		arvore = builder.montaArvoreCheiaDoisNiveis();

		arvore.removeNoPorNome("E");

		assertEquals("F", arvore.getRaiz().getNome());
		assertFalse(arvore.contem("E"));
	}
	
	@Test
	void removerNoArvoreEspecialParaExclusao() {
		
	
		arvore = builder.montaArvoreEspecialParaExclusao();

		arvore.removeNoPorNome("E");
		
		assertEquals("F", arvore.getRaiz().getEsquerdo().getNome());
		assertFalse(arvore.contem("E"));
		arvore.imprimir2DArvore();
	}
	
}
