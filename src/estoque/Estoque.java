package estoque;

import java.util.Scanner;

import conexoes.ConexaoComBanco;

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
				
		
			
	/**
	* O metodo {@code adicionarProduto} estabelece uma conexao com o banco de dados.
	* @return nao ha retornos
	*/		
	public String adicionarProduto() {
			Produto prod = new Produto();
			System.out.print("Insira a descricao do produto:");
			prod.setDescricao(new Scanner(System.in).nextLine());
			System.out.println("Insira a quantidade do produto:");
			prod.setQuantidade(new Scanner(System.in).nextInt());
			new ConexaoComBanco().salvarProduto(prod);
			return "Produto adicionado com sucesso!";
	}	
	
	public String buscarProduto() {
		
	}
}
