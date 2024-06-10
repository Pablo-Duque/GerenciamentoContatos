public class ArvoreBinariaBusca {

	private No raiz;

	static final int CONTADOR_ESPACO = 5;

	public ArvoreBinariaBusca() {
		raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public boolean ehVazia() {
		return raiz == null;
	}

	public int pegaQuantidadeNos() {
		return pegaQuantidadeNosDoSubNo(raiz);
	}

	public int pegaQuantidadeNosDoSubNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		} else {
			return pegaQuantidadeNosDoSubNo(noReferencia.getEsquerdo()) + 1
					+ pegaQuantidadeNosDoSubNo(noReferencia.getDireito());
		}
	}

	public int pegaAlturaDoNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		} else {
			return pegaAlturaDoSubNo(noReferencia) - 1;
		}
	}

	private int pegaAlturaDoSubNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		}
		int alturaDireita = pegaAlturaDoSubNo(noReferencia.getDireito()); // 2
		int alturaEsquerda = pegaAlturaDoSubNo(noReferencia.getEsquerdo()); // 0

		return 1 + Math.max(alturaDireita, alturaEsquerda);
	}

	public int pegaAlturaDaArvore() {
		return pegaAlturaDoNo(raiz);
	}

	public int pegaProfundidadeDoNo(No noBuscado) {

		if (noBuscado == null) {
			return 0;
		} else {
			return pegaProfundidadeDoNoAteRaiz(raiz, noBuscado) - 1;
		}
	}

	private int pegaProfundidadeDoNoAteRaiz(No noReferencia, No noBuscado) {
		if (noReferencia == null) {
			return 0;
		} else {
			if (noBuscado.getNome() == noReferencia.getNome()) {
				return 1;
			}

			if (noBuscado.getNome().compareTo(noReferencia.getNome()) < 0) {
				return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getEsquerdo(), noBuscado);
			} else {
				return 1 + pegaProfundidadeDoNoAteRaiz(noReferencia.getDireito(), noBuscado);
			}
		}
	}

	public No pegarNoArvorePorNome(String nomeBuscado) {
		
		No atual = raiz;
		while (atual != null) {
			if (nomeBuscado.compareTo(atual.getNome()) == 0) {
				return atual;
			} else if (nomeBuscado.compareTo(atual.getNome()) < 0) {
				atual = atual.getEsquerdo();
			} else {
				atual = atual.getDireito();
			}
		}
		return null;
	}

	public boolean contem(String nomeBuscado) {

		return (pegarNoArvorePorNome(nomeBuscado) != null);
	}

	public void adicionaNo(String nome, String telefone) {

		if (raiz == null) {
			raiz = new No(new Contato(nome, telefone), null, null);
		} else {
			No atual = raiz;
			while (true) {
				if (nome.compareTo(atual.getNome()) <= 0) {
					if (atual.getEsquerdo() == null) {
						atual.setEsquerdo(new No(new Contato(nome, telefone), null, null));
						return;
					}
					atual = atual.getEsquerdo();
				} else {
					if (atual.getDireito() == null) {
						atual.setDireito(new No(new Contato(nome, telefone), null, null));
						return;
					}
					atual = atual.getDireito();
				}
			}
		}
	}

	public void removeNoPorNome(String nomeARemover) {
		No pai = null;
		No atual = raiz;
		while (atual != null) {
			if (nomeARemover.compareTo(atual.getNome()) == 0) {
				if (atual.ehFolha()) {
					removerNoFolha(pai, atual);
				} else if (atual.getDireito() == null) {
					removerSoFilhoEsquerdo(pai, atual);
				} else if (atual.getEsquerdo() == null) {
					removerSoFilhoDireito(pai, atual);
				} else {
					No sucessor = buscarSucessor(atual);
					String nomeSucessor = sucessor.getNome();
					String telefoneSucessor = sucessor.getTelefone();
					int codSucessor = sucessor.getCod();
					removeNoPorNome(nomeSucessor);
					atual.setDados(nomeSucessor, telefoneSucessor, codSucessor);
				}
				return;
			} else if (nomeARemover.compareTo(atual.getNome()) < 0) {
				pai = atual;
				atual = atual.getEsquerdo();
			} else {
				pai = atual;
				atual = atual.getDireito();
			}
		}
	}

	private void removerSoFilhoDireito(No pai, No atual) {
		if (pai == null) {
			raiz = atual.getDireito();
		} else {
			if (pai.getEsquerdo() == atual) {
				pai.setEsquerdo(atual.getDireito());
			} else {
				pai.setDireito(atual.getDireito());
			}
		}
	}

	private void removerSoFilhoEsquerdo(No pai, No atual) {
		if (pai == null) {
			raiz = atual.getEsquerdo();
		} else {
			if (pai.getEsquerdo() == atual) {
				pai.setEsquerdo(atual.getEsquerdo());
			} else {
				pai.setDireito(atual.getEsquerdo());
			}
		}
	}

	private void removerNoFolha(No pai, No atual) {
		if (pai == null) {
			raiz = null;
		} else {
			if (pai.getEsquerdo() == atual) {
				pai.setEsquerdo(null);
			} else {
				pai.setDireito(null);
			}
		}
	}

	private No buscarSucessor(No noAtual) {
		No sucessor = noAtual.getDireito();
		while (sucessor.getEsquerdo() != null) {
			sucessor = sucessor.getEsquerdo();
		}
		return sucessor;
	}

	public void imprimirPreOrder() {
		percorrerPreOrder(raiz);
	}

	private void percorrerPreOrder(No noReferencia) {
		if (noReferencia != null) {
			System.out.println(noReferencia.getCod() + " | " + noReferencia.getNome() + "(" + noReferencia.getTelefone() +")");
			percorrerPreOrder(noReferencia.getEsquerdo());
			percorrerPreOrder(noReferencia.getDireito());
		}
	}

	public void imprimirInOrder() {
		percorrerInOrder(raiz);
	}

	private void percorrerInOrder(No noReferencia) {
		if (noReferencia != null) {
			percorrerInOrder(noReferencia.getEsquerdo());
			System.out.println(noReferencia.getCod() + " | " + noReferencia.getNome() + "(" + noReferencia.getTelefone() +")");
			percorrerInOrder(noReferencia.getDireito());
		}
	}

	public void imprimirPosOrder() {
		percorrerPosOrder(raiz);
	}

	private void percorrerPosOrder(No noReferencia) {
		if (noReferencia != null) {
			percorrerPosOrder(noReferencia.getEsquerdo());
			percorrerPosOrder(noReferencia.getDireito());
			System.out.println(noReferencia.getCod() + " | " + noReferencia.getNome() + "(" + noReferencia.getTelefone() +")");
		}
	}

	public void imprimir2DArvore() {
		print2DUtil(raiz, 0);
	}

	private void print2DUtil(No noReferencia, int space) {
		if (noReferencia == null) {
			return;
		}
		space += CONTADOR_ESPACO;
		print2DUtil(noReferencia.getDireito(), space);

		System.out.print("\n");
		for (int i = CONTADOR_ESPACO; i < space; i++)
			System.out.print(" ");
		System.out.print(noReferencia.getCod() + " | " + noReferencia.getNome() + "(" + noReferencia.getTelefone() + ")" + "\n");
		print2DUtil(noReferencia.getEsquerdo(), space);
	}

}
