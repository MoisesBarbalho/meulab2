package myLab2;
import java.util.*;

public class Aluno {
	private String matricula;
	private String nome;
	private Map<String, Disciplina> disciplinas;
	private double meuCRA;
	private RegistroResumos meusResumos;
	private Descanso rotinaDeDescanso;
	private Map<String, RegistroTempoOnline> tempoOnlinePorDisciplina;
	
	public Aluno(String nome, String matricula, int duracaoDoPeriodo, int capacidadeDeResumos) {
		this.nome = nome;
		this.matricula = matricula;
		this.disciplinas = new HashMap<String, Disciplina>();
		this.tempoOnlinePorDisciplina = new HashMap<String, RegistroTempoOnline>();
		this.rotinaDeDescanso = new Descanso(duracaoDoPeriodo);
		this.meusResumos = new RegistroResumos(capacidadeDeResumos);
		this.meuCRA = 0;
	}
	public Aluno(String nome, String matricula, int duracaoDoPeriodo) {
		this.nome = nome;
		this.matricula = matricula;
		this.disciplinas = new HashMap<String, Disciplina>();
		this.tempoOnlinePorDisciplina = new HashMap<String, RegistroTempoOnline>();
		this.rotinaDeDescanso = new Descanso(duracaoDoPeriodo);
		this.meusResumos = new RegistroResumos();
		this.meuCRA = 0;
	}
	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.disciplinas = new HashMap<String, Disciplina>();
		this.tempoOnlinePorDisciplina = new HashMap<String, RegistroTempoOnline>();
		this.rotinaDeDescanso = new Descanso();
		this.meusResumos = new RegistroResumos();
		this.meuCRA = 0;
		
	}
	public void registrarDisciplina(Disciplina disciplina) {
		this.disciplinas.put(disciplina.getNome(), disciplina);
		RegistroTempoOnline tempoOnlineParaDisciplina = new RegistroTempoOnline(disciplina);
		this.tempoOnlinePorDisciplina.put(disciplina.getNome(), tempoOnlineParaDisciplina);
		this.defineCRA();
	}
	public Disciplina getDisciplina(String nome) {
		if(!(this.disciplinas.containsKey(nome))) {
			throw new NoSuchElementException("Disciplina não encontrada");
		}
		return this.disciplinas.get(nome);
	}
	public void registrarTempoOnline(String disciplina, int tempo) {
		this.tempoOnlinePorDisciplina.get(disciplina).adicionaTempoOnline(tempo);
	}
	public RegistroTempoOnline getRegistroTempoOnline(String disciplina) {
		if(!this.tempoOnlinePorDisciplina.containsKey(disciplina)) {
			throw new NoSuchElementException("Disciplina não encontrada");
		}
		return this.tempoOnlinePorDisciplina.get(disciplina);
	}
	public void setResumos(int capacidade, boolean tf) {
		RegistroResumos novoRegistro = new RegistroResumos(capacidade);
		if(tf) {
			String[] jaRegistrados = this.meusResumos.pegaResumos();
			for(String resumoString : jaRegistrados) {
				if(resumoString != null) {
					String[] arrayResumo = resumoString.split(": ");
					novoRegistro.adicionaResumo(arrayResumo[0], arrayResumo[1]);
				}
			}
		}
		this.meusResumos = novoRegistro;
	}
	public RegistroResumos getResumos() {
		return this.meusResumos;
	}
	public void setDescanso(int numSemanas, int horasDescansadas ) {
		this.rotinaDeDescanso.defineNumeroSemanas(numSemanas);
		this.rotinaDeDescanso.defineHorasDescanso(horasDescansadas);
	}
	public Descanso getDescanso() {
		return this.rotinaDeDescanso;
	}
	private void defineCRA() {
		Iterator<Disciplina> i = this.disciplinas.values().iterator();
		double soma = 0;
		int count = 0;
		while(i.hasNext()) {
			soma += i.next().getNotas().getMedia();
			count++;
		}
		this.meuCRA = soma/count;
	}
	
}
