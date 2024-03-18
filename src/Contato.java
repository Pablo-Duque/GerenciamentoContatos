public class Contato {
	private String nome;
	private String telefone;
	private int cod;
	private static int codGeral = 0;

	public Contato(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
		this.cod = codGeral;
		codGeral++;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public int getCod() {
		return cod;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setCod(int cod) {
		this.cod = cod;
	}
}