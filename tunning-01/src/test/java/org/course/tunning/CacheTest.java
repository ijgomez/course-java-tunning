package org.course.tunning;

import static org.junit.Assert.*;

import org.junit.Test;

public class CacheTest {

	@Test
	public void test() {
		// Ejecutar, por ejemplo, con java -Xmx250m Cache, variando los tamaños de memoria para ver el efecto
		
		Cache<String,byte[]> cache = new Cache<>();
		
		 
		for (int i = 0; i < 10240; i++) {
			byte[] b = new byte[102400];
			cache.put(String.valueOf(i),b);
		}


		int faltan = 0;
		for (int i = 0; i < 10240; i++) {
			byte[] b = cache.get(String.valueOf(i));
			
			if (b == null) {
				System.out.println("La entrada para "+i+" falta");
				faltan++;
			}
		}
		System.out.println("Total de fallos = "+faltan);
		
		assertTrue(true);
	}

}
