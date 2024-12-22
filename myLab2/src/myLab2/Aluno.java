package myLab2;
import java.util.*;

public class Aluno {
	private String matricula;
	private String nome;
	private Map<String, Disciplina> disciplinas;
	private Map<String, int[]> boletim;
	private int cra;
	private RegistroDeResumos resumos;
	private Descanso descanso;
	
	public Aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.disciplinas = new HashMap<String, Disciplina>();
		this.boletim = new HashMap<String, int[]>();
	}
}
