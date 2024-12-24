package myLab2;

public class Disciplina {
	private String nomeDaDisciplina;
	private Notas notas;
	private CargaHoraria cargaHoraria;
	
	public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos, int carga) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.notas = new Notas(numeroDeNotas, pesos);
		this.cargaHoraria = new CargaHoraria(carga);
	}
	public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesos) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.notas = new Notas(numeroDeNotas, pesos);
		this.cargaHoraria = new CargaHoraria(60);
	}
	public Disciplina(String nomeDisciplina, int numeroDeNotas) {
		this.nomeDaDisciplina = nomeDisciplina;
		this.notas = new Notas(numeroDeNotas);
		this.cargaHoraria = new CargaHoraria(60);
	}
	public Disciplina(String nomeDisciplina) {
		this(nomeDisciplina, 4);
	}
	public String getNome() {
		return this.nomeDaDisciplina;
	}
	public CargaHoraria getCargaHoraria() {
		return this.cargaHoraria;
	}
	public Notas getNotas() {
		return this.notas;
	}
	public String showNotas() {
		return this.notas.toString();
	}
	public boolean aprovado() {
		if(this.cargaHoraria.realizou()) return (this.notas.getMedia() >= 7);
		else return false;
	}
	public String getSituacao() {
		if(this.cargaHoraria.realizou()) {
			return (this.aprovado()) ? "Aprovado(a)"  : "Reprovado(a)";
		} else return "Cursando";
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--Disciplina: " + this.nomeDaDisciplina + "--\n")
		.append(this.notas.toString())
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
