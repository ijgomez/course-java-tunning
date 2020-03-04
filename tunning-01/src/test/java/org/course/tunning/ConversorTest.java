package org.course.tunning;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ConversorTest {

	@Test
	public void test() throws Exception {
		byte[] entrada = new byte[10240];
		char[] salida = new char[entrada.length];
		Random r = new Random();
		r.nextBytes(entrada);
		Conversor.convert(entrada, 0, entrada.length, salida, 0, salida.length);
		for (int i = 0; i < salida.length; i++)
			//System.out.print(salida[i]);
			System.out.print(salida.length);
		
		assertTrue(true);
	}

}
