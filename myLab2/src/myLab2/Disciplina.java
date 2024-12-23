package myLab2;

import java.util.Arrays;

public class Disciplina {
	private String nomeDaDisciplina;
	private double[] notas;
	private int[] pesos;
	private CargaHoraria cargaHoraria;
	
	public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos, int carga) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.notas = new double[numeroDeNotas];
		this.pesos = pesos;
		this.cargaHoraria = new CargaHoraria(carga);
	}
	public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.notas = new double[numeroDeNotas];
		this.pesos = pesos;
		this.cargaHoraria = new CargaHoraria(60);
		this.ajustaPesos();
	}
	public Disciplina(String nomeDisciplina, int numeroDeNotas) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.notas = new double[numeroDeNotas];
		this.pesos = new int[numeroDeNotas];
		this.cargaHoraria = new CargaHoraria(60);
		this.ajustaPesos();
	}
	public Disciplina(String nomeDisciplina) {
		this(nomeDisciplina, 4);
	}
	public String getNome() {
		return this.nomeDaDisciplina;
	}
	public String showNotas() {
		return Arrays.toString(notas);
	}
	public String showMedia() {
		return Double.toString(this.tiraMedia());
	}
	public CargaHoraria getCargaHoraria() {
		return this.cargaHoraria;
	}
	public void cadastraNota(int qual, double valor) {
		this.notas[qual - 1] = valor * this.pesos[qual - 1];
	}
	public boolean aprovado() {
		return (this.tiraMedia() >= 7);
	}
	public double tiraMedia() {
		int somaPesos = Arrays.stream(this.pesos).sum();
		double somaNotas = Arrays.stream(this.notas).sum();
		return somaNotas / somaPesos;
		
	}
	private void ajustaPesos() {
        for (int i = 0; i < this.pesos.length; i++) {
            if (this.pesos[i] == 0) {
                this.pesos[i] = 1;
            }
        }
    }
}
