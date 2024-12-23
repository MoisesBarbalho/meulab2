package myLab2;
import java.util.*;

public class RegistroResumos {
	private Map<String, Resumo> resumos;
	private  int capacidade;
	
	public RegistroResumos(Aluno aluno, int capacidadeDeResumos) {
		this.capacidade = capacidadeDeResumos;
		this.resumos = new LimitedHashMap<String, Resumo>(this.capacidade);
	}
	public void adicionaResumo(String tema, String conteudo) {
		if(this.resumos.containsKey(tema))
			throw new UnsupportedOperationException("Resumo já registrado.");
		Resumo novoResumo = new Resumo(tema, conteudo);
		this.resumos.put(tema, novoResumo);
	}
	public void removeResumo(String tema) {
		if(!(this.resumos.containsKey(tema)))
			throw new NoSuchElementException("Resumo não encontrado");
		this.resumos.remove(tema);
	}
	public int conta() {
		return this.resumos.size();
	}
	public String[] pegaResumos() {
		return this.resumos.values()
				.stream()
				.map(Resumo::toString).toArray(String[]::new);
	}
	public String imprimeResumos() {
		String resumosRegistrados = String.join(" | ", this.pegaResumos());
		return "Resumos Registrados: " + resumosRegistrados;
	}
	public boolean temResumo(String tema) {
		return this.resumos.containsKey(tema);
	}
	public String[] buscaResumo(String chaveDeBusca) {
		String chave = chaveDeBusca.toLowerCase();
		String[] encontrados =  this.resumos.values().stream()
				.filter(resumo -> resumo
						.getConteudo()
						.toLowerCase().contains(chave))
				.map(Resumo::getTema).toArray(String[]::new);
		Arrays.sort(encontrados);
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
		.append("Registrados:" + this.resumos.size() + "\n")
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
