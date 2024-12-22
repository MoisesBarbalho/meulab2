package myLab2;
import java.util.LinkedHashMap;
import java.util.Map;

public class LimitedHashMap<K,V> extends LinkedHashMap<K,V> {
	private static final long serialVersionUID = 1L;
	private final int capacidadeLimite;
	
	public LimitedHashMap(int capacidadeLimite){
		super(capacidadeLimite, 0.75f, false);
		this.capacidadeLimite = capacidadeLimite;
	}
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > capacidadeLimite;
	}
}

	

