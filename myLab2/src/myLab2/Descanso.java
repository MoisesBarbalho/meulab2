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
	public Descanso() {
		this.numeroDeSemanas = 0;
		this.horasDeDescanso = 0;
		this.defineStatusGeral();
	}
	public void defineHorasDescanso(int valor) {
		this.horasDeDescanso = valor;
		this.defineStatusGeral();
	}
	public void defineNumeroSemanas(int valor) {
		this.numeroDeSemanas = valor;
		this.defineStatusGeral();
	}
	public void defineEmoji(String emoji) {
		this.emoji = emoji;
	}
	public String getStatusGeral() {
		if(this.emoji != null)
			return this.statusGeral + " - " + this.emoji;
		else return this.statusGeral;
	}
	private void defineStatusGeral() {
		String novoStatusGeral;
		if(this.numeroDeSemanas != 0) {
			int horasPorSemana = this.horasDeDescanso / this.numeroDeSemanas;
			if(horasPorSemana >= 26)
				novoStatusGeral = "descansado";
			else novoStatusGeral = "cansado";
		} 
		else novoStatusGeral = "cansado";
			
		if(!(this.statusGeral.equals(novoStatusGeral)))
			this.emoji = null;
		
		this.statusGeral = novoStatusGeral;
	}

}
