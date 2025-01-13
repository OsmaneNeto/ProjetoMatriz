package testes;

import javax.swing.JOptionPane;

import classe.Pessoa;

public class TestaPessoa {

	public static void main(String[] args) {
		// Declaração
		Pessoa[]  pessoa = new Pessoa[20];
		int indice = 0;
		String[] menu= {"Cadastrar", "Mostrar", "Sair"};
		String opcao;
		do {
			opcao = (String) JOptionPane.showInputDialog(null, "Escolha a opção", "O Cadastro", JOptionPane.INFORMATION_MESSAGE, null, menu, "Cadastrar");
			switch (opcao) {
			case "Cadastrar":
				String nome, endereco, telefone;
				nome= JOptionPane.showInputDialog("Entrar com o nome");
				endereco= JOptionPane.showInputDialog("Entrar com o Endereço");
				telefone= JOptionPane.showInputDialog("Entrar com o Telefone");
				pessoa[indice] = new Pessoa(nome, endereco, telefone);
				indice++;
				
				break;
			case "Mostrar":
				if (pessoa[0] != null) {
					for (int i = 0; i < indice; i++) {
						System.out.println(pessoa[i].mostrarDadosString());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Não á pessoas cadastradas", "O Cadastro", JOptionPane.WARNING_MESSAGE);
				}
				break;
			

			default:break;
			}
			
		} while (!opcao.equals("sair"));
	}

}
