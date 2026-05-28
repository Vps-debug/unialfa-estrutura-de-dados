import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Formulário para cadastro de usuários
 */
public class Formulario extends JFrame {
    
    // Componentes da interface
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtIdade;
    private JButton btnSalvar;
    private JLabel lblMensagem;
    
    public Formulario() {
        // Configurar a janela
        setTitle("Cadastro de Usuários");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centralizar na tela
        setLayout(new BorderLayout());
        
        // Criar o painel principal
        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre componentes
        
        // Campo Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(new JLabel("Nome:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        txtNome = new JTextField(20);
        painel.add(txtNome, gbc);
        
        // Campo Email
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(new JLabel("Email:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        txtEmail = new JTextField(20);
        painel.add(txtEmail, gbc);
        
        // Campo Idade
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(new JLabel("Idade:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        txtIdade = new JTextField(5);
        painel.add(txtIdade, gbc);
        
        // Botão Salvar
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        btnSalvar = new JButton("SALVAR");
        btnSalvar.setBackground(new Color(0, 120, 215));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setFont(new Font("Arial", Font.BOLD, 14));
        painel.add(btnSalvar, gbc);
        
        // Label para mensagens
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        lblMensagem = new JLabel("Preencha os dados acima", SwingConstants.CENTER);
        lblMensagem.setForeground(Color.GRAY);
        painel.add(lblMensagem, gbc);
        
        add(painel, BorderLayout.CENTER);
        
        // Configurar ação do botão Salvar (vamos implementar depois)
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarUsuario();
            }
        });
    }
    
    /**
     * Método que será chamado ao clicar no botão Salvar
     * (Vamos implementar depois de criar o DAO)
     */
    private void salvarUsuario() {
        // TODO: Implementar após criar UsuarioDAO
        lblMensagem.setText("Processando...");
    }
    
    /**
     * Método principal - inicia o programa
     */
    public static void main(String[] args) {
        // Garantir que a interface será criada na thread correta
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }
}
