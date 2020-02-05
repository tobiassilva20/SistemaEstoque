package estoque;

import java.util.Scanner;

public class Estoque {
	String desc;
	int qtd;
			public void iniciarEstoque() {
					int op;
					do {
						System.out.println("Bem-vindo ao Sistema de Estoque!!!....\nDigite uma opcao para começar:");
						System.out.println("1 - Novo produto \n 2 - Sair");
						System.out.println("Opcao: ");
						
						op = new Scanner(System.in).nextInt();
						
						switch (op) {
						case 1 :
							System.out.println(adicionarProduto());
							break;
						}
					}while(op != 4);
				}
				
		
			
	//Metodo que adiciona um novo produto.
	public String adicionarProduto() {
			new Produto(desc, qtd);
			System.out.print("Insira a descricao do produto:");
			desc = new Scanner(System.in).nextLine();
			
			System.out.println("Insira a quantidade do produto:");
			qtd = new Scanner(System.in).nextInt();
			
			return "Produto adicionado com sucesso!";
	}	
}
