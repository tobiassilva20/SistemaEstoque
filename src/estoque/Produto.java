package estoque;

public class Produto {
	
	private int codigo;
	private String descricao;
	private  int quantidade;
	
	public Produto(String descricao, int quantidade) {
		
		this.descricao = descricao;
		this.quantidade = quantidade;
	}
}
