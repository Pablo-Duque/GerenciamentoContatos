import java.util.Scanner;

public class Front {
	public static void main(String[] args) {
		ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
		int option = 0;
		try (Scanner obj = new Scanner(System.in)) {
			while(option != 5) {
				System.out.println("Selecione uma opcao:\n");
				System.out.println("1: Adicionar um novo contato\n");
				System.out.println("2: Pesquisar por um contato pelo nome\n");
				System.out.println("3: Listar todos os contatos em ordem alfabética crescente\n");
				System.out.println("4: Remover um contato existente por nome.\n");
				System.out.println("5: Sair\n");
				option = obj.nextInt();
				
			    switch (option) {
			        case 1 -> {
						System.out.println("\nDigite o nome do contato: ");
						String nome = obj.next();
						System.out.println("\nDigite o telefone do contato: ");
						String telefone = obj.next();
			        	arvore.adicionaNo(nome, telefone);
			        }
			        case 2 -> {
			        	System.out.println("\nDigite o nome do contato: ");
			        	String nome = obj.next();
			        				        	
			        	if(arvore.contem(nome)) {
			        		No atual = arvore.pegarNoArvorePorNome(nome);
			        		System.out.println("\nContato buscado: " + atual.getCod() + " | " + atual.getNome() + "(" + atual.getTelefone() +")");
			        	}else
			        		System.out.println("\nContato nao encontrado!");
			        }
			        case 3 -> arvore.imprimirInOrder();
			        case 4 -> {
			        	System.out.println("\nDigite o nome do contato: ");
			        	String nome = obj.next();
			        	
			        	if(arvore.contem(nome)) {
			            	arvore.removeNoPorNome(nome);
			        		System.out.println("\nContato removido!");
			        	}else
			        		System.out.println("\nContato nao encontrado!");
			        }
			        case 5 -> System.out.println("\nSaindo...");
			        default -> System.out.println("\nOpcao invalida!"); 
			}
			    System.out.println("\n");
			}
		}
	}
}
