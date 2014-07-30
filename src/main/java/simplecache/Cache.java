package simplecache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cache<T, K> implements Map<T, K>{
	
	public final static long TIME_24_HOURS = 86400000L;
	public final static long TIME_12_HOURS = 43200000L;
	public final static long TIME_1_HOUR = 3600000L;

	private long timeout;
	
	private HashMap<T, Item<K>> map;
	
	public Cache(long timeout) {
		map = new HashMap<T, Item<K>>();
		this.timeout = timeout;
	}

	public int size() {
		return map.size();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public boolean containsKey(Object chave) {

		// Se possui a chave e ela está no prazo de validade
		return map.containsKey(chave) && ((System.currentTimeMillis() - map.get(chave).getTimeout()) < timeout);		
		
	}

	public K get(Object chave) {
		K retorno = null;
		
		// Se o mapa possui o elemento
		if (map.containsKey(chave)) {
			Item<K> elemento = map.get(chave);
			
			// Se o elemento esta no prazo de validade
			if ((System.currentTimeMillis() - elemento.getTimeout()) < timeout) {
				retorno = elemento.getValue();
			}
			else {
				map.remove(chave);
			}
		}
			
		return retorno;
	}

	public K put(T chave, K valor) {
		Item<K> elemento = new Item<K>(valor, System.currentTimeMillis());
		
		map.put(chave, elemento);
		
		return valor;
	}

	public void clear() {
		map.clear();
	}

	public Set<T> keySet() {
		return map.keySet();
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public K remove(Object key) {
		Item<K> elemento = map.remove(key); 

		if (elemento == null)
			return null;
		
		return elemento.getValue();
	}

	public void putAll(Map<? extends T, ? extends K> m) {
		for (T chave: m.keySet()) {
			put(chave, m.get(chave));
		}
	}

	public Collection<K> values() {
		List<K> retorno = new ArrayList<K>(map.size());
		
		for(Item<K> valor: map.values())
			retorno.add(valor.getValue());
		
		return retorno;
	}

	public Set<java.util.Map.Entry<T, K>> entrySet() {
		throw new UnsupportedOperationException("");
	}
}
