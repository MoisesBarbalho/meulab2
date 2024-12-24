package myLab2;

public class RegistroTempoOnline {
	private Disciplina disciplina;
	private int tempoOnlineEsperado;
	private int tempoOnline;
	
	public RegistroTempoOnline(Disciplina disciplina) {
		this.disciplina = disciplina;
		this.tempoOnlineEsperado = this.disciplina.getCargaHoraria().getCargaTotal() * 2;
		this.tempoOnline = 0;
	}
	public String getDisciplina() {
		return this.disciplina.getNome();
	}
	public int getTempoOnline() {
		return this.tempoOnline;
	}
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnline += tempo;
	}
	public boolean atingiuMeta() {
		return (this.tempoOnline >= this.tempoOnlineEsperado);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tempo Online para a disciplina " + this.disciplina.getNome() + ":");
		sb.append(this.tempoOnline + "h/" + this.tempoOnlineEsperado + "h\n");
		if(this.atingiuMeta()) {
			sb.append("Meta atingida.");
		} else {
			sb.append("Meta não-atingida");
		}
		return sb.toString();
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof RegistroTempoOnline)) return false;
		if(o == this) return true;
		
		RegistroTempoOnline oRTO = (RegistroTempoOnline) o;
		if(this.disciplina.getNome().equals(oRTO.disciplina.getNome()) 
				&& this.tempoOnline == oRTO.getTempoOnline()) {
			return true;
		} else return false;
	}
	@Override
	public int hashCode() {
		int hash = 19;
		hash = 31 * hash + this.disciplina.hashCode();
		hash = 31 * hash + this.tempoOnline;
		return hash;
	}
}
