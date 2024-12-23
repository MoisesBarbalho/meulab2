package myLab2;

public class Resumo {
	private String tema;
	private String conteudo;
	
	public Resumo(String tema, String conteudo) {
		this.tema = tema;
		this.conteudo = conteudo;
	}
	public String getTema() {
		String title = this.tema;
		return title;
	}
	public String getConteudo() {
		String content = this.conteudo;
		return content;
	}
	public void setConteudo(String novoConteudo) {
		this.conteudo = novoConteudo;
	}
	@Override
	public String toString() {
		String temaEConteudo = this.tema + ": " + this.conteudo;
		return temaEConteudo;
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Resumo)) return false;
		if(o == this) return true;
		
		Resumo oR = (Resumo) o;
		return (this.tema.contentEquals(oR.getTema()));
	}
	@Override
	public int hashCode() {
		int hash = 19;
		hash = 31 * hash + this.tema.hashCode();
		return hash;
	}
}
