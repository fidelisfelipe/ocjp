package ocjp.fundmentals;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperadoresTest {
	
	/**
	 * 
	 * Os Operadores Bit-a-Bit são todos aqueles que realizam suas operações sobre os bits de um número, 
	 * e não sobre o seu valor. Existem ao todo três destes operadores e cada um deles tem um valor de precedência diferente. 
	 * O que tem precedência mais alta é o AND bit-a-bit (&). Ele analisa dois bits e retorna 1 se ambos forem iguais à 1 e 0 caso contrário.
	 *  Depois vem o OR exclusivo bit-a-bit (^) que retorna 1 se os bits forem diferentes e 0 caso contrário. 
	 *  Por último, vem o operador OR inclusivo (|), que retorna 0 caso ambos os bits valerem 0 e retorna 1 caso contrário. 
	 *  Estes operadores podem ser usados em qualquer tipo de dados, desde que possuam o mesmo tamanho em bits. Exemplos de uso:
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testBitBitOR() throws Exception {
		Integer a = 123;
		float b = 123f;
		boolean c = false;
		
		boolean assertiva = false;
		
		//Bit-aBit OU OR
		if(c | a == b){
			assertiva = true;
		}
		
		assertTrue(assertiva);
		
		int numero;
		numero=34&435;  //numero passa a valer 34
		assertTrue(numero == 34);
		numero=34^46;   //numero passa a valer 12
		assertTrue(numero == 12);
		numero=436|547; //numero passa a valer 951
		assertTrue(numero == 951);
		
	}

}
