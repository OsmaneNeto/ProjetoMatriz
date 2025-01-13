package classe;

public class Doador {
	//Declarações
	public String nome;
	public float peso;
	public int idade;
	public String genero;
	//construtor
	public Doador(String nome, float peso, int idade, String genero) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.idade = idade;
		this.genero = genero;
	}
	//metodo
	//mostra a idade do doador e determina se pode ou não doar sangue e quanto
	public String mostrarQuantidadedeSangue() {
		if (this.idade >16 && this.idade<=69 && this.peso>= 50) {
			if(this.genero.equalsIgnoreCase("Masculino")) {//testa todas as letras
				return "\nDoar 700 gramas" + "\n" +"\n-------------------------------------------------------------";
		} else {
			return "\nDoar 400 gramas" + "\n" +"\n-------------------------------------------------------------";
		}
		} else {
			return "Não pode doar sangue";
			}
	}
	//metodo mostrar dados
	public String mostrarDados() {
		return "\nNome do Doador: "+this.nome
				+ "\nidade do Doador: " + this.idade
				+ "\npeso do Doador: " + this.peso +" KG"
				+ "\ngênero do doador: " + this.genero;
	}
}
