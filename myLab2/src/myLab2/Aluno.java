package myLab2;
import java.util.*;

public class Aluno {
	private String matricula;
	private String nome;
	private Map<String, Disciplina> disciplinas;
	private int cra;
	private RegistroResumos resumos;
	private Descanso descanso;
	private Map<String, RegistroTempoOnline> tempoOnline;
	
	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.disciplinas = new HashMap<String, Disciplina>();
		this.tempoOnline = new HashMap<String, RegistroTempoOnline>();
	}
}
