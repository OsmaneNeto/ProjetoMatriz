package telas;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import classe.Pessoa;

public class TelaPessoa extends JFrame {

	 
		private JLabel jlNome, jlEndereco, jlTelefone;

		private JTextField jtfNome, jtfEndereco, jtfTelefone;

		private JButton jbCadastrar, jbMostrar;

		private JTextArea jtaMostrar;//usado para grandes textos

		private JScrollPane jspMostar; //barra de rolagem

		private int indice= 0;//null point excepssion
		
		private Pessoa[]pessoas = new Pessoa[20];
	

				public TelaPessoa(String title) throws HeadlessException {
					super(title);
					setSize(400, 400);
					setLayout(null);
					getContentPane().setBackground(Color.BLUE);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					iniciarComponentes();
					criarEventos();
					
			  }

				

				private void iniciarComponentes() {
					//Objeto
					jlNome= new JLabel("Nome");
					jtfNome= new JTextField();
					
					jlEndereco= new JLabel("endereço");
					jtfEndereco= new JTextField();
					
					jlTelefone= new JLabel("Telefone");
					jtfTelefone= new JTextField();
					
					jbCadastrar= new JButton("Cadastrar");
					
					jbMostrar= new JButton("Mostrar");
					jtaMostrar= new JTextArea();
					jspMostar= new JScrollPane(jtaMostrar);
					
					
					
					//adicionar
					add(jlNome);
					add(jtfNome);
					
					add(jlEndereco);
					add(jtfEndereco);
					
					add(jlTelefone);
					add(jtfTelefone);
					
					add(jbCadastrar);
					
					add(jbMostrar);
					add(jspMostar);
					
					//Dimensionamento 
	               	//Coluna, Linha, Comprimento e Largura.
		jlNome.setBounds(10, 20, 50, 20);//texto nome
		jtfNome.setBounds(10, 40, 310, 20);//quadrado nome

		jlEndereco.setBounds(10, 60, 100, 20);//Coluna, Linha, Comprimento e Largura.
		jtfEndereco.setBounds(10, 80, 100, 20);//Coluna, Linha, Comprimento e Largura.
		
		jlTelefone.setBounds(210, 60, 100, 20);//Coluna, Linha, Comprimento e Largura.
		jtfTelefone.setBounds(210, 80, 100, 20);//Coluna, Linha, Comprimento e Largura.
		
		jbCadastrar.setBounds(110, 120, 100, 20);//Coluna, Linha, Comprimento e Largura.
		
		jbMostrar.setBounds(110, 150, 100, 20);//Coluna, Linha, Comprimento e Largura.
		jspMostar.setBounds(10, 180, 350, 160);//Coluna, Linha, Comprimento e Largura.
	}
				private void criarEventos() {
					// TODO Auto-generated method stub
					jbCadastrar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							String nome, endereco, telefone;
							
							if (!jtfNome.getText().isEmpty()&&!jtfEndereco.getText().isEmpty()&&!jtfTelefone.getText().isEmpty()) {
								//entradas
								nome = jtfNome.getText();
								endereco = jtfEndereco.getText();
								telefone= jtfTelefone.getText();
								//oprocessamento
								pessoas[indice]= new Pessoa(nome, endereco, telefone);
								indice++;
								//objeto 
								
								
								
								
								//apagar os campos
								jtfNome.setText("");
								jtfEndereco.setText("");
								jtfTelefone.setText("");
								
							} else {
								JOptionPane.showMessageDialog(null,  "Preencha todos os campos", "Pessoa", JOptionPane.WARNING_MESSAGE);
							}
							
							
						}
					}
					);//fim do evento
					
					//cria evento do botão mostrar
					jbMostrar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							jtaMostrar.setText("\t                Pessoas\n");
							if (pessoas[0] !=null) {
								for (int i = 0; i < indice; i++) {
									jtaMostrar.append(pessoas[i].mostrarDadosString());
								}
							} else {
								JOptionPane.showMessageDialog(null,  "Não á Pessoas Cadastradas", "Pessoa", JOptionPane.WARNING_MESSAGE);
							}
							
						}
					});//fim
					
					
				}
}
