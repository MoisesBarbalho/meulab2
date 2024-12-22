package myLab2;
import java.util.*;

public class RegistroResumos {
	private Map<String, Resumo> resumos;
	private  int capacidade;
	private int contagem;
	
	public RegistroResumos(int capacidadeDeResumos) {
		this.capacidade = capacidadeDeResumos;
		this.resumos = new LinkedHashMap<String, Resumo>();
		this.contagem = 0; 
	}
	public void adicionaResumo(String tema, String conteudo) {
		Resumo novoResumo = new Resumo(tema, conteudo);
		this.
		
	}
}
