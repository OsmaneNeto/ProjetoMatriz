package classe;

public class Pessoa {
	public String nome, endereco;
	public String telefone;
//construtor
	public Pessoa(String nome, String endereco, String telefone) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	//metodos
	public String mostrarDadosString() {
		return "Nome: " +this.nome
				+"\nEndereço: " + this.endereco
				+"\nTelefone: " + this.telefone;
	}

}
