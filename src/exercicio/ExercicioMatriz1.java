 package exercicio;

import javax.swing.JOptionPane;

public class ExercicioMatriz1 {

	public static void main(String[] args) {
		//matriz para guardar números inteiros
		//declarar matriz unidimensional
		int [] matriz = new int[10];
		//leitura de uma matriz
		for (int i = 0; i < matriz.length; i++) {
			matriz[i] =Integer.parseInt(JOptionPane.showInputDialog("Entre com o valor na matriz") );
			
		}
	// escrita da matriz
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(matriz[i]);
			
		}
	}

}
