package myLab2;
import java.util.*;

public class RegistroResumos {
	private Map<String, Resumo> resumos;
	private  int capacidade;
	private int contagem;
	
	public RegistroResumos(Aluno aluno, int capacidadeDeResumos) {
		this.capacidade = capacidadeDeResumos;
		this.resumos = new LimitedHashMap<String, Resumo>(this.capacidade);
		this.contagem = this.resumos.size(); 
	}
	public void adicionaResumo(String tema, String conteudo) throws ResumoJaAdicionadoException {
		if(this.resumos.containsKey(tema))
			throw new ResumoJaAdicionadoException("Resumo já registrado.");
		Resumo novoResumo = new Resumo(tema, conteudo);
		this.resumos.put(tema, novoResumo);
	}
	public void removeResumo(String tema) {
		if(!(this.resumos.containsKey(tema)))
			throw new NoSuchElementException("Resumo não encontrado");
		this.resumos.remove(tema);
	}
	public int conta() {
		return this.contagem;
	}
	public String[] pegaResumos() {
		return (String[])this.resumos.values()
				.stream()
				.map(Resumo::toString).toArray();
	}
	public String imprimeResumos() {
		return String.join(" | ", this.pegaResumos());
	}
	public boolean temResumo(String tema) {
		return this.resumos.containsKey(tema);
	}
	public String[] buscaResumo(String chaveDeBusca) {
		String chave = chaveDeBusca.toLowerCase();
		String[] encontrados = (String[]) this.resumos.values()
				.stream()
				.filter(resumo -> resumo.getConteudo().toLowerCase().contains(chave))
				.toArray();
		return encontrados;
	}
	private String[] getTemas() {
		return (String[]) this.resumos.keySet()
				.stream().toArray();
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("---Registro de Resumos---\n")
		.append("Capacidade: " + this.capacidade + "\n")
		.append("Registrados:" + this.contagem + "\n")
		.append("Temas:\n " + String.join(".\n",this.getTemas()));
		return sb.toString(); 
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof RegistroResumos)) return false;
		if(o == this) return true;
		
		RegistroResumos oRR = (RegistroResumos) o;
		return (this.imprimeResumos().contentEquals(oRR.imprimeResumos()));
	}
	@Override
	public int hashCode() {
		int hash = 19;
		hash = 31 * hash + this.resumos.hashCode();
		return hash;
	}
	
}
