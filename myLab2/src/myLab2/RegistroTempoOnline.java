package myLab2;

public class RegistroTempoOnline {
	private Disciplina disciplina;
	private int tempoOnlineEsperado;
	private int tempoOnline;
	
	public RegistroTempoOnline(Disciplina disciplina) {
		this.disciplina = disciplina;
		this.tempoOnlineEsperado = this.disciplina.getHorasTotais() * 2;
		this.tempoOnline = 0;
	}
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnline += tempo;
	}
	public boolean atingiuMeta() {
		return (this.tempoOnline >= this.tempoOnlineEsperado);
	}
	
}
