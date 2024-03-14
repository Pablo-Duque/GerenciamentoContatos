public class No {

	private Contato contato;
	private No direito;
	private No esquerdo;

	public No(Contato contato, No esquerdo, No direito) {
		this.contato = contato;
		this.direito = direito;
		this.esquerdo = esquerdo;
	}

	public String getNome() {
		return contato.getNome();
	}
	
	public String getTelefone() {
		return contato.getTelefone();
	}
	
	public int getCod() {
		return contato.getCod();
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setDados(String nome, String telefone, int cod) {
		contato.setNome(nome);
		contato.setTelefone(telefone);
		contato.setCod(cod);
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public boolean ehFolha() {
		return (direito == null && esquerdo == null);
	}
}
