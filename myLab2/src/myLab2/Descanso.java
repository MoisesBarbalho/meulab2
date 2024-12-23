package myLab2;

public class Descanso {
	private int numeroDeSemanas;
	private int horasDeDescanso;
	private String statusGeral;
	private String emoji;
	
	public Descanso(int numeroDeSemanas, int horasDeDescanso) {
		this.numeroDeSemanas = numeroDeSemanas;
		this.horasDeDescanso = horasDeDescanso;
		this.defineStatusGeral();
	}
	public Descanso(int numeroDeSemanas) {
		this.numeroDeSemanas = numeroDeSemanas;
		this.horasDeDescanso = 0;
		this.defineStatusGeral();
	}
	public Descanso() {
		this.numeroDeSemanas = 0;
		this.horasDeDescanso = 0;
		this.defineStatusGeral();
	}
	public void defineHorasDescanso(int valor) {
		this.horasDeDescanso = valor;
		this.defineStatusGeral();
	}
	public void adicionaHorasDescanso(int valor) {
		this.horasDeDescanso += valor;
	}
	public void defineNumeroSemanas(int valor) {
		this.numeroDeSemanas = valor;
		this.defineStatusGeral();
	}
	public void defineEmoji(String emoji) {
		this.emoji = emoji;
	}
	public int getHorasDescanso() {
		return this.horasDeDescanso;
	}
	public int getNumeroDeSemanas() {
		return this.numeroDeSemanas;
	}
	public int getHorasPorSemana() {
		if(this.numeroDeSemanas != 0) {
			return this.horasDeDescanso / this.numeroDeSemanas;
		} else return 0;
	}
	public String getStatusGeral() {
		if(this.emoji != null) {
			return this.statusGeral + " - " + this.emoji;
		} else return this.statusGeral;
	}
	private void defineStatusGeral() {
		String novoStatusGeral;
		if(this.getHorasPorSemana() >= 26) {
			novoStatusGeral = "descansado";
		} else {
			novoStatusGeral = "cansado";
		}
		
		if(!(this.statusGeral.equals(novoStatusGeral))) {
			this.emoji = null;
		}
		this.statusGeral = novoStatusGeral;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--Status de descanso--\n")
		.append("Horas de descanso totais: " + this.horasDeDescanso + "\n")
		.append("Numero de semanas: " + this.numeroDeSemanas + "\n")
		.append("Horas de descanso por semana:" + this.getHorasPorSemana())
		.append("Status de descanso: " + this.getStatusGeral());
		return sb.toString();
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Descanso)) return false;
		if(o == this) return true;
		
		Descanso oD = (Descanso) o;
		if(this.getHorasDescanso() == oD.getHorasDescanso()
				&& this.getNumeroDeSemanas() == oD.getNumeroDeSemanas()) {
			return true;
		} else return false;
	}
	@Override
	public int hashCode() {
		int hash = 19;
		hash = 31 * hash + this.horasDeDescanso;
		hash = 31 * hash + this.numeroDeSemanas;
		return hash;
	}
}
