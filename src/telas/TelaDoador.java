
package telas;

import java.awt.Color;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.Image;


import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import classe.Doador;

public class TelaDoador extends JFrame {
	
private JLabel jlNome, jlPeso, jlIdade, jlGenero, jlImagem ;//Jlabel suporta também imagem

private JTextField jtfNome, jtfPeso, jtfIdade;//texto na caixa

private JButton jbCadastrar, jbMostrar;//Botões

private JTextArea jtaMostrar;//usado para grandes textos

private JScrollPane jspMostar; //barra de rolagem

private JRadioButton jrbMasculino, jrbFeminino;

private ButtonGroup bgGenero; //agrupa os radios buttons que somente um eja selecionado

private ImageIcon imagem;

private Doador[] doadores = new Doador[40];

private int indice= 0;//null point excepssion


		public TelaDoador(String title) throws HeadlessException {
			super(title);
			setSize(400, 400);
			setLayout(null);
			getContentPane().setBackground(Color.RED);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			iniciarComponentes();
			criarEventos();
			
	  }

		private void iniciarComponentes() {
			
			//Objeto
			
			URL url = this.getClass().getResource("/imagens/doacaodeSangue3.png");
			Image IconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
			this.setIconImage(IconeTitulo);
			
			jlNome= new JLabel("Nome");
			jtfNome= new JTextField();
			
			jlPeso= new JLabel("Peso");
			jtfPeso= new JTextField();
			
			jlIdade= new JLabel("Idade");
			jtfIdade= new JTextField();
			
			jbCadastrar= new JButton("Cadastrar");
			
			jbMostrar= new JButton("Mostrar");
			jtaMostrar= new JTextArea();
			jspMostar= new JScrollPane(jtaMostrar);
			
			jrbMasculino= new JRadioButton("Masculino", true);
			jrbMasculino.setOpaque(false);;
			
			jrbFeminino= new JRadioButton("Feminino");
			jrbFeminino.setOpaque(false);;
			
			bgGenero= new ButtonGroup();
			jlGenero= new JLabel("Gênero");
			
			imagem = new ImageIcon(getClass().getResource("/imagens/doacaodeSangue2.png"));//Imagem Icone
			jlImagem= new JLabel(imagem);//Jlabel suporta também imagem
			
			
			//adicionar
			add(jlNome);
			add(jtfNome);
			
			add(jlPeso);
			add(jtfPeso);
			
			add(jlIdade);
			add(jtfIdade);
			
			add(jbCadastrar);
			
			add(jbMostrar);
			
			add(jrbFeminino);
			add(jrbMasculino);
			
			add(jlGenero);
			bgGenero.add(jrbMasculino);
			bgGenero.add(jrbFeminino);
			
			add(jlImagem);
			
			add(jspMostar);			
			
			//Dimensionamento 
		               	//Coluna, Linha, Comprimento e Largura.
			jlNome.setBounds(10, 20, 50, 20);//texto nome
			jtfNome.setBounds(10, 40, 200, 20);//quadrado nome

			jlPeso.setBounds(10, 60, 50, 20);//Coluna, Linha, Comprimento e Largura.
			jtfPeso.setBounds(10, 80, 50, 20);//Coluna, Linha, Comprimento e Largura.
			
			jlIdade.setBounds(160, 60, 50, 20);//Coluna, Linha, Comprimento e Largura.
			jtfIdade.setBounds(160, 80, 50, 20);//Coluna, Linha, Comprimento e Largura.
			
			jbCadastrar.setBounds(110, 120,100, 20);//Coluna, Linha, Comprimento e Largura.
			
			jbMostrar.setBounds(110, 150, 100, 20);//Coluna, Linha, Comprimento e Largura.
			jlGenero.setBounds(10, 110, 50, 20);//Coluna, Linha, Comprimento e Largura.
			
			jrbMasculino.setBounds(10, 130, 100, 20);//Coluna, Linha, Comprimento e Largura.
			jrbFeminino.setBounds(10, 150, 100, 20);//Coluna, Linha, Comprimento e Largura.
			
			jspMostar.setBounds(10, 180, 350, 160);//Coluna, Linha, Comprimento e Largura.
			
			jlImagem.setBounds(220, 40, 128, 128);//Coluna, Linha, Comprimento e Largura.
			
		}

		private void criarEventos() {
			//Criar exemplo do espaço do botão cadastrar
			jbCadastrar.addActionListener(new ActionListener() {//addActionListener Toda a interface cria metodos secretos
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// Declarar Variaveis
					 String nome;
					 float peso;
					 int idade;
					 String genero = null;
					 
					 //validação do campo em vazio
					 if (!jtfNome.getText().isEmpty()&&!jtfPeso.getText().isEmpty()&&!jtfIdade.getText().isEmpty()) {
						 
						 //entradas
						 nome = jtfNome.getText();						
						 peso= Float.parseFloat(jtfPeso.getText());
						 idade= Integer.parseInt(jtfIdade.getText());
						 if (jrbMasculino.isSelected()){
							 genero = "Masculino";
						 }
						 else
						 {
							 genero = "Feminino";
						 }
						 //genero= jrbMasculino.isSelected()? "Masculino":"Feminino";
						 
						 //Objeto
						 doadores[indice]= new Doador(nome, peso, idade, genero);
						 indice++;
						
						 
						 //Apagar os campos
						 jtfNome.setText("");
						 jtfPeso.setText("");
						 jtfIdade.setText("");
			
					} else {
						JOptionPane.showMessageDialog(null, "Não a doadores cadastrados ", "Doação", JOptionPane.WARNING_MESSAGE);
					}//fim do If Else
				}
			});//Fim de eventos
			
			//Crar Evento do Botão Mostrar
			jbMostrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					jtaMostrar.setText("\t  Doação de Sangue \n");
					
					//Validação do Objeto Nulo
					if (doadores[0]!=null) {
						for (int i = 0; i < indice; i++) {
							jtaMostrar.append((doadores[i].mostrarDados() + "\n" + doadores[i].mostrarQuantidadedeSangue()
									+"\n****************"));
							//System.out.println(doadores[i].mostrarDados() + "\n" + doadores[i].mostrarQuantidadedeSangue());
						}
						
						//JOptionPane.showMessageDialog(null, doador.mostrarDados()  + "\n" +doador.mostrarQuantidadedeSangue());
					} else {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Doação", JOptionPane.WARNING_MESSAGE);
					}
				}
			});;
		}



}
