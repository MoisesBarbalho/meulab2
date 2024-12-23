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
	public double[] getNotas() {
		return this.notas;
	}
	public int[] getPesos() {
		return this.pesos;
	}
	public double getMedia() {
		return this.tiraMedia();
	}
	public String showNotas() {
		return Arrays.toString(this.notas);
	}
	public String showPesos() {
		return Arrays.toString(this.pesos);
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
		if(this.cargaHoraria.realizou()) return (this.tiraMedia() >= 7);
		else return false;
	}
	public String getSituacao() {
		if(this.cargaHoraria.realizou()) {
			return (this.aprovado()) ? "Aprovado(a)"  : "Reprovado(a)";
		} else return "Cursando";
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
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--Disciplina: " + this.nomeDaDisciplina + "--\n")
		.append("-Notas: " +this.showNotas() + ".\n")
		.append("-Pesos: " +this.showPesos() + ".\n")
		.append("-Média: " +this.showMedia() + ".\n")
		.append("-Carga Horaria: " + this.cargaHoraria.toString())
		.append("Situação: " + this.getSituacao());
		return sb.toString();
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Disciplina)) return false;
		if(o == this) return true;
		
		Disciplina oDi = (Disciplina) o;
		if(this.nomeDaDisciplina.equals(oDi.getNome())) {
			if(this.cargaHoraria.getCargaTotal() == this.getCargaHoraria().getCargaTotal()) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		int hash = 19;
		hash = 31 * hash + this.nomeDaDisciplina.hashCode();
		hash += this.cargaHoraria.getCargaTotal();
		return hash;
	}
}
