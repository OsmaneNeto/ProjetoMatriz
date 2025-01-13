package classe;

public class Aluno {
	public String nome;
	public float nota1;
	public float nota2;
	public float media;
	public String statusAluno;
	//construtor
	public Aluno(String nome, float nota1, float nota2) {
		super();
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	//metodos
	public String mostrarDados() {
		return "Nome: " + this.nome
				+ "\n1° nota: " + this.nota1 
				+"\n2° nota: " + this.nota2
				+"\nMedia: " + this.media;
		
	}
	public void calcularMedia() {
		this.media = (this.nota1 + this.nota2)/2;
	}
public String verificarStatusAluno() {
	return this.statusAluno= this.media>=5?"\naprovado\n":"\nreprovado\n";
}

	}
//this.statusAluno= this.media>?"aprovado":"reprovado"
