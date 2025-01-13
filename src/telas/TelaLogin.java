package telas;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import classe.Usuario;

public class TelaLogin extends JFrame {
	private JLabel jlLogin,  jlSenha;
	private JTextField jtfLogin;
	private JPasswordField jpfSenha;
	private JButton jbLogar, jbCadastrar;
	private Usuario[] usuarios =new Usuario[40];
	private int indice= 0;
	
	
	
//construtor superclass
	public TelaLogin(String title) throws HeadlessException {
		super(title);
		setSize(250, 250);//tamanho de tela
		setLayout(null);
		getContentPane().setBackground(Color.RED);
		setLocationRelativeTo(this);//tela aparece centralizada
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		criarEventos();
	}
private void iniciarComponentes() {
		// TODO Auto-generated method stub
		jlLogin= new JLabel("Login");
		jlSenha= new JLabel("Senha");
		jtfLogin= new JTextField();
		jpfSenha= new JPasswordField();
		jbLogar= new JButton("Logar");
		jbCadastrar= new JButton("Cadastrar");
		
		//Adicionar
		add(jlLogin);
		add(jlSenha);
		add(jtfLogin);
		add(jpfSenha);
		add(jbCadastrar);
		add(jbLogar);
		
		//Dimensionar
		jlLogin.setBounds(80, 10, 50, 20);//Coluna, Linha, Comprimento e Largura.
		jtfLogin.setBounds(80, 30, 80, 20);//Coluna, Linha, Comprimento e Largura.
		
		jlSenha.setBounds(80, 60, 50, 20);//Coluna, Linha, Comprimento e Largura.
		jpfSenha.setBounds(80, 80, 80, 20);//Coluna, Linha, Comprimento e Largura.
		
		jbLogar.setBounds(70, 115, 100, 20);//Coluna, Linha, Comprimento e Largura.
		
		jbCadastrar.setBounds(70, 145, 100, 20);//Coluna, Linha, Comprimento e Largura.
		
	}
private void criarEventos() {
		//Cadastrar
	jbCadastrar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			TelaCadastro cadastro = new TelaCadastro("Cadastro", usuarios, indice);
			cadastro.setVisible(true);
			indice++;
			
		}
	});
	//botão logar
	jbLogar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (usuarios[0] !=null) {
				for (int i = 0; i < indice; i++) {
					if (usuarios[i].login.equals(jtfLogin.getText()) &&usuarios[i].senha.equals(String.valueOf(jpfSenha.getPassword()))) {
						TelaDoador doador= new TelaDoador("Dação de sangue");
						doador.setVisible(true);
						setVisible(false);//deixa a tela de login invisivel
						break;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Nenhum usuario Cadastrado", "Login", JOptionPane.WARNING_MESSAGE);
			}
		}
	});
	
		
	}//fim do criiarEventos

public static void main(String[] args) {
	TelaLogin login = new TelaLogin("Login");
	login.setVisible(true);
}

}
