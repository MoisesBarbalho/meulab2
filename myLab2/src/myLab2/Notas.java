package myLab2;
import java.util.*;

public class Notas {
	private double[] valores;
	private int[] pesos;
	private double media;
	
	public Notas(int numeroDeNotas, int[] pesos) {
		this.valores = new double[numeroDeNotas];
		this.pesos = pesos;
		this.media = 0;
	}
	public Notas(int numeroDeNotas) {
		this.valores = new double[numeroDeNotas];
		this.pesos = new int[numeroDeNotas];
		this.media = 0;
		this.ajustaPesos();
	}
	public void setNotas(double[] notas) {
		this.valores = notas;
		this.tiraMedia();
	}
	public void cadastraNota(int qual, double valor) {
		this.valores[qual - 1] = valor * this.pesos[qual - 1];
		this.tiraMedia();
	}
	public double[] getNotas() {
		return this.valores;
	}
	public int[] getPesos() {
		return this.pesos;
	}
	public double getMedia() {
		return this.media;
	}
	public String showNotas() {
		return Arrays.toString(this.valores);
	}
	public String showPesos() {
		return Arrays.toString(this.pesos);
	}
	public String showMedia() {
		return Double.toString(this.media);
	}
	private void tiraMedia() {
		int somaPesos = Arrays.stream(this.pesos).sum();
		double somaNotas = Arrays.stream(this.valores).sum();
		this.media = somaNotas / somaPesos;	
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
		sb.append("-Notas: " +this.showNotas() + ".\n")
		.append("-Pesos: " +this.showPesos() + ".\n")
		.append("-Média: " +this.showMedia() + ".\n");
		return sb.toString();
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Notas)) return false;
		if(o == this) return true;
		
		Notas oN = (Notas) o;
		if(this.toString().contentEquals(oN.toString())) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		int hash = 19;
		int somaNotas = (int) Arrays.stream(this.valores).sum();
		int somaPesos = Arrays.stream(this.pesos).sum();
		int media = (int) this.media;
		hash = 31 * hash + somaNotas;
		hash += somaPesos + media;
		return hash;	
	}
}
