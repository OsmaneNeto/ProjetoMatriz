package telas;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import classe.Aluno;

public class TelaAluno extends JFrame {
	private JLabel jlNome, jlNota1, jlNota2,jlImagem;
	
	private JTextField jtfNome, jtfNota1, jtfNota2, jtfLogin;
	
	private JButton jbCadastrar, jbMostrar;
	
	private Aluno[] alunos= new Aluno[20];//matriz
	
	private JTextArea jtaMostrar;
	
	private JPasswordField jpfSenha;
	
	private JScrollPane jspMostar;
	
	private ImageIcon imagem;
	
	private int indice = 0;
	
	public TelaAluno(String title) throws HeadlessException {
		super(title);
		setSize(400, 400);
		setLayout(null);
		getContentPane().setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		criarEventos();
		
	}

	private void iniciarComponentes() {
		URL url = this.getClass().getResource("/imagens/escola.png");
		Image IconeTitulo= Toolkit.getDefaultToolkit().getImage(url);
		this.setIconImage(IconeTitulo);
		
		//Objetos
		jlNome= new JLabel("Nome");
		jtfNome= new JTextField();
		
		jlNota1= new JLabel("Nota1°");
		jtfNota1= new JTextField();
		
		jlNota2= new JLabel("Nota2°");
		jtfNota2= new JTextField();
		
		jbCadastrar= new JButton("Cadastrar");
		jbMostrar= new JButton("Mostrar");
		
		jtaMostrar= new JTextArea();
		jspMostar= new JScrollPane(jtaMostrar);
		
		imagem = new ImageIcon(getClass().getResource("/imagens/escola.png"));//Imagem Icone
		jlImagem= new JLabel(imagem);//Jlabel suporta também imagem
		
		//Adicionar
		add(jlNome);
		add(jtfNome);
		
		add(jlNota1);
		add(jtfNota1);
		
		add(jlNota2);
		add(jtfNota2);
		
		
		add(jbCadastrar);
		
		add(jbMostrar);
		
		add(jspMostar);
		
		add(jlImagem);
		//Dimensionamento
		jlNome.setBounds(10, 20, 50, 20);//Coluna, Linha, Comprimento e Largura.
		jtfNome.setBounds(10, 40, 200, 20);//Coluna, Linha, Comprimento e Largura.
		
		jlNota1.setBounds(10, 70, 50, 20);//Coluna, Linha, Comprimento e Largura.
		jtfNota1.setBounds(10, 90, 50, 20);//Coluna, Linha, Comprimento e Largura.
		
		jlNota2.setBounds(160, 70, 50, 20);//Coluna, Linha, Comprimento e Largura.
		jtfNota2.setBounds(160, 90, 50, 20);//Coluna, Linha, Comprimento e Largura.
		
		jbCadastrar.setBounds(60, 120,100, 20);//Coluna, Linha, Comprimento e Largura.
		
		jbMostrar.setBounds(60, 150, 100, 20);//Coluna, Linha, Comprimento e Largura.
		
		jspMostar.setBounds(10, 180, 210, 170);//Coluna, Linha, Comprimento e Largura.
		
		jlImagem.setBounds(200, 0, 200, 210);//Coluna, Linha, Comprimento e Largura.
		
	}

	private void criarEventos() {
		//Criar exemplo do espaço do botão cadastrar
		jbCadastrar.addActionListener(new ActionListener() {//addActionListener Toda a interface cria metodos secretos
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Declarar as variaveis
				String nome;
				float nota1, nota2;
				
				//a validação do campo em vazio
				if (!jtfNome.getText().isEmpty()&&!jtfNota1.getText().isEmpty()&&!jtfNota2.getText().isEmpty()) {
					
					//entradas
					nome = jtfNome.getText();
					nota1= Float.parseFloat(jtfNota1.getText());
					nota2= Float.parseFloat(jtfNota2.getText());
					
					//Objeto
					alunos[indice] = new Aluno(nome, nota1, nota2);
					
					//Processamento
					alunos[indice].calcularMedia();
					alunos[indice].verificarStatusAluno();
					indice++;
					//Apagar os campos
					jtfNome.setText("");
					jtfNota1.setText("");
					jtfNota2.setText("");
					
				} else {
					JOptionPane.showMessageDialog(null,"Não hà alunos Cadastrados", "A Escola ", JOptionPane.WARNING_MESSAGE);
				}//fim do IFELSE
			
			}
		});//fim do evento
		
		//Crar Evento do Botão Mostrar
		jbMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Validação do Objeto Nulo
				if (alunos[0] != null) {
					jtaMostrar.setText("\t A Escola ");
					for (int i = 0; i < indice; i++) {
						jtaMostrar.append((alunos[i].mostrarDados() + alunos[i].verificarStatusAluno()));
						
					}
					
					
					//JOptionPane.showMessageDialog(null, aluno.mostrarDados()+"\n"+ aluno.verificarStatusAluno() );
				
				}else {
					JOptionPane.showMessageDialog(null, 
							"Não a Alunos Cadastrados",
							"A Escola ", JOptionPane.WARNING_MESSAGE);//pegar com 4 elementos
				}
			}
		});
		
	

	}
	}
