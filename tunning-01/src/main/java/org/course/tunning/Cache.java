package org.course.tunning;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class Cache<K,V> {
	
	private Map<K,SoftReference<V>> map = new HashMap<>();
	
	public void put(K clave, V valor) {
		map.put(clave, new SoftReference<V>(valor));
	}
	
	public V get(K clave) {
		SoftReference<V> valor = map.get(clave);
		if (valor != null) {
			V dato = valor.get();
			if (dato == null) {
				map.remove(clave);
			} 
			return dato;
		}
		return null;
	}
	
}
