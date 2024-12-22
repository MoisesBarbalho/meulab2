package myLab2;

public class Disciplina {
	private String nomeDaDisciplina;
	private int[] notas;
	private int numeroDeNotas;
	private int[] pesos;
	private int horas;
	private RegistroTempoOnline tempoOnline;
	
	public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.numeroDeNotas = numeroDeNotas;
		this.notas = new int[numeroDeNotas];
		this.pesos = pesos;
	}
	public Disciplina(String nomeDisciplina, int numeroDeNotas) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.numeroDeNotas = numeroDeNotas;
		this.notas = new int[numeroDeNotas];
		this.pesos = new int[numeroDeNotas];
		this.ajustaPesos();
	}
	public Disciplina(String nomeDisciplina) {
		this(nomeDisciplina, 4);
	}
}
