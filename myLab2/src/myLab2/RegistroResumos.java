package myLab2;
import java.util.*;

public class RegistroResumos {
	private Map<String, Resumo> resumos;
	private  int capacidade;
	private int contagem;
	
	public RegistroResumos(int capacidadeDeResumos) {
		this.capacidade = capacidadeDeResumos;
		this.resumos = new LimitedHashMap<String, Resumo>(this.capacidade);
		this.contagem = 0; 
	}
	public void adicionaResumo(String tema, String conteudo) throws ResumoJaAdicionadoException {
		if(this.resumos.containsKey(tema))
			throw new ResumoJaAdicionadoException("Resumo já registrado.");
		Resumo novoResumo = new Resumo(tema, conteudo);
		this.resumos.put(tema, novoResumo);
	}
}
