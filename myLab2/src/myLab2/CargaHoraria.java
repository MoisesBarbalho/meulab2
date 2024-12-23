package myLab2;

public class CargaHoraria {
	private final int carga;
	private int cadastradas;
	
	public CargaHoraria(int carga) {
		this.carga = carga;
	}
	public CargaHoraria() {
		this.carga = 60;
	}
	public void registraHoras(int hora) {
		if(this.cadastradas >= this.carga) {
			throw new UnsupportedOperationException("Carga horária máxima alcançada");
		}
		this.cadastradas += hora;
	}
	public int getHorasCadastradas() {
		int horasCadastradas = this.cadastradas;
		return horasCadastradas;
	}
	public int getCargaTotal() {
		int cargaTotal = this.carga;
		return cargaTotal;
	}
	public double cumpridas() {
		double realizacao = this.cadastradas / this.carga * 100;
		return realizacao;
	}
	public boolean realizou() {
		if(this.cumpridas() >= 100) return true;
		else return false;
	}
	@Override
	public String toString() {
		String relatorio = "Horas: "+this.cadastradas+"h/" + this.carga+"h"+" ("+this.cumpridas()+"%)";
		return relatorio;
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof CargaHoraria)) return false;
		if(o == this) return true;
		
		CargaHoraria oCH = (CargaHoraria) o;
		if(this.cadastradas == oCH.cadastradas && this.carga == oCH.getCargaTotal()) {
			return true;
		} else return false;
	}
	@Override
	public int hashCode() {
		int hash = 19;
		hash = 31 * hash + this.cadastradas;
		hash = 31 * hash + this.carga;
		return hash;
	}

}
