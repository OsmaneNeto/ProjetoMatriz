package telas;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import classe.Usuario;

public class TelaCadastroAluno extends JFrame {
	private JLabel jlLogin,  jlSenha;
	private JTextField jtfLogin;
	private JPasswordField jpfSenha;
	private JButton jbCadastrar;
	private Usuario[] usuarios;
	private int indice;

	//construtor superclass
		public TelaCadastroAluno(String title, Usuario[] usuarios, int indice) throws HeadlessException {
			super(title);
			this.usuarios = usuarios;
			this.indice = indice;
			setSize(250, 250);//tamanho de tela
			setLayout(null);
			getContentPane().setBackground(Color.RED);
			setLocationRelativeTo(this);//tela aparece centralizada
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			iniciarComponentes();
			criarEventos();
		}

	private void iniciarComponentes() {
		URL url = this.getClass().getResource("/imagens/escola.png");
		Image IconeTitulo= Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(IconeTitulo);
			// TODO Auto-generated method stub
			jlLogin= new JLabel("Login");
			jlSenha= new JLabel("Senha");
			jtfLogin= new JTextField();
			jpfSenha= new JPasswordField();
			
			jbCadastrar= new JButton("Cadastrar");
			
			
			//Adicionar
			add(jlLogin);
			add(jlSenha);
			add(jtfLogin);
			add(jpfSenha);
			add(jbCadastrar);
			
			//Dimensionar
			jlLogin.setBounds(80, 10, 50, 20);//Coluna, Linha, Comprimento e Largura.
			jtfLogin.setBounds(80, 30, 80, 20);//Coluna, Linha, Comprimento e Largura.
			
			jlSenha.setBounds(80, 60, 50, 20);//Coluna, Linha, Comprimento e Largura.
			jpfSenha.setBounds(80, 80, 80, 20);//Coluna, Linha, Comprimento e Largura.
			
			jbCadastrar.setBounds(70, 115, 100, 20);//Coluna, Linha, Comprimento e Largura.
			
}
	private void criarEventos() {
		//Botão cadastrar
		jbCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String login = jtfLogin.getText();
				String senha = String.valueOf(jpfSenha.getPassword());//ValueOf converte conjunto de caracteres para String
				usuarios[indice]= new Usuario(login, senha);
				setVisible(false);
				
			}
		});//fim do botão
		
		
	}//fim do criarEventos
	
}