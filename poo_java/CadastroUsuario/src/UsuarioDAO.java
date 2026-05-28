import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe responsável por salvar usuários no banco de dados
 * DAO = Data Access Object (Objeto de Acesso a Dados)
 */
public class UsuarioDAO {
    
    /**
     * Salva um usuário no banco de dados
     * @param usuario Objeto com os dados do usuário
     * @return true se salvou com sucesso, false caso contrário
     */
    public boolean salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, idade) VALUES (?, ?, ?)";
        
        // Usamos try-with-resources para garantir que a conexão será fechada
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Substituir os "?" pelos valores do usuário
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setInt(3, usuario.getIdade());
            
            // Executar o comando SQL
            int linhasAfetadas = stmt.executeUpdate();
            
            // Se inseriu pelo menos 1 linha, deu certo
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Erro ao salvar usuário: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Método de teste para o DAO
     */
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario("João Silva", "joao@email.com", 30);
        
        if (dao.salvar(usuario)) {
            System.out.println("✅ Usuário salvo com sucesso!");
        } else {
            System.out.println("❌ Erro ao salvar usuário.");
        }
    }
}
