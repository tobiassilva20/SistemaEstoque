package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import estoque.Produto;


/**
 * Classe de Conexao responsavel pela conexao com o banco de dados estoque.
 * @see java.sql.Connection
 */
public class ConexaoComBanco {
	private Connection conexao;
	private final String strConexao = "jdbc:mysql://localhost:3306/estoque?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private final String usuario = "root";
	private final String senha = "";
	
	public PreparedStatement statment;

	/**
	 * O metodo {@code ConexaoComBanco} estabelece uma conexao com o banco de dados.
	 * @return nao ha retornos
	 */
	public ConexaoComBanco(){
				//Tenta estabelecer uma conexao
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conexao = DriverManager.getConnection(strConexao,usuario,senha);
					System.out.println("Conectado com Sucesso!");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
	}
	
	/**
	 * O metodo {@code salvarProduto} persiste dados recebidos do usuario no banco de dados.
	 * @param produto contem os dados a serem salvos.
	 */
	public void salvarProduto(Produto produto) {
		try {
			statment = conexao.prepareStatement("insert into produtos (id,descricao,quantidade) values (?,?,?)");
			statment.setInt(1, produto.getCodigo());
			statment.setString(2, produto.getDescricao());
			statment.setInt(3, produto.getQuantidade());
						
			//Executa a query----------------------------------------------------------------------------
			statment.execute();
			//Fecha conexao------------------------------------------------------------------------------
			
			//conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
