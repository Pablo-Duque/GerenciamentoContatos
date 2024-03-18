public class ArvoreBinariaBuilder {
	
	private ArvoreBinariaBusca arvore;
		
	public ArvoreBinariaBusca montaArvoreVazia() {
		this.arvore = new ArvoreBinariaBusca();
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreSoRaiz() {
		No noE = new No(new Contato("E", "123"), null, null);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noE);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizFilhoDireito() {
		No noG = new No(new Contato("G","7"), null, null);
		No noE = new No(new Contato("E","5"), null, noG);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noE);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizFilhoEsquerdo() {
		No noC = new No(new Contato("C","3"), null, null);
		No noE = new No(new Contato("E","5"), noC, null);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noE);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizFilhoDireitoEsquerdo() {
		No noG = new No(new Contato("G","7"), null, null);
		No noC = new No(new Contato("C","3"), null, null);
		No noE = new No(new Contato("E","5"), noC, noG);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noE);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizDoisFilhoDireitoUmEsquerdo() {
		No noH = new No(new Contato("H","8"), null, null);
		No noG = new No(new Contato("G","7"), null, noH);
		No noC = new No(new Contato("C","3"), null, null);
		No noE = new No(new Contato("E","5"), noC, noG);

		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noE);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizUmFilhoDireitoDoisEsquerdo() {
		No noG = new No(new Contato("G","7"), null, null);
		No noA = new No(new Contato("A","1"), null, null);
		No noC = new No(new Contato("C","3"), noA, null);
		No noE = new No(new Contato("E","5"), noC, noG);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noE);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreRaizDoisFilhoDireitoDoisEsquerdo() {
		No noA = new No(new Contato("A","1"), null, null);
		No noC = new No(new Contato("C","3"), noA, null);
		No noH = new No(new Contato("H","8"), null, null);
		No noG = new No(new Contato("G","7"), null, noH);
		No noE = new No(new Contato("E","5"), noC, noG);
		arvore.setRaiz(noE);
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreCheiaDoisNiveis() {
		No noA = new No(new Contato("A","1"), null, null);
		No noD = new No(new Contato("D","4"), null, null);
		No noC = new No(new Contato("C","3"), noA, noD);
		No noH = new No(new Contato("H","8"), null, null);
		No noF = new No(new Contato("F","6"), null, null);
		No noG = new No(new Contato("G","7"), noF, noH);
		No noE = new No(new Contato("E","5"), noC, noG);
		arvore = new ArvoreBinariaBusca();
		arvore.setRaiz(noE);
		return arvore;
	}
	
	public ArvoreBinariaBusca montaArvoreEspecialParaExclusao() {
		
		arvore = new ArvoreBinariaBusca();
		arvore.adicionaNo("O" ,"15");
		arvore.adicionaNo("P" ,"16");
		arvore.adicionaNo("U" ,"20");
		arvore.adicionaNo("Y" ,"23");
		arvore.adicionaNo("R" ,"18");
		arvore.adicionaNo("E" ,"5");
		arvore.adicionaNo("L" ,"12");
		arvore.adicionaNo("M" ,"13");
		arvore.adicionaNo("J" ,"10");
		arvore.adicionaNo("F" ,"6");
		arvore.adicionaNo("G" ,"7");
		arvore.adicionaNo("C","3");
		return arvore;
		
		
	}

}
