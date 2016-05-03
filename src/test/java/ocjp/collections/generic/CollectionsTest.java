package ocjp.collections.generic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import org.junit.Test;

public class CollectionsTest {
	@Test
	public void testAumentarCapacidadeDoArrayList() throws Exception {
		//por padrão a lista reserva 10 alocações para objetos
		ArrayList list = new ArrayList();
		//assim esta alocação vai para 20 objetos
		list.ensureCapacity(5);
		//mas ele não pode reduzir o tamanho mínimo de 10 para 5 por exemplo
	}
	
	@Test
	public void tesHashTable() throws Exception {
		Hashtable<Integer, String> table = new Hashtable<Integer, String>();
		table.put(1, "janeiro");
		table.put(1, "jan");
		table.put(2, "março");
		table.put(3, "abril");
		
		assertTrue(table.size() == 3);
		
		assertTrue(table.get(1) == "jan");  //substitui a chave existente
		
		boolean lancouException = false;
		try {
			table.put(3, null);
		} catch (NullPointerException e) {
			lancouException = true; 
		}
		assertTrue("lança nullpointer ao inserir valor nulo",lancouException);
		
	}
	@Test
	public void tesHashMap() throws Exception {
		HashMap<Integer, String> table = new HashMap<Integer, String>();
		table.put(1, "janeiro");
		table.put(1, "jan");
		table.put(2, "março");
		table.put(3, "abril");
		
		assertTrue(table.size() == 3);
		
		assertTrue(table.get(1) == "jan");  //substitui a chave existente
		
		boolean lancouException = false;
		try {
			table.put(3, null);
		} catch (NullPointerException e) {
			lancouException = true; 
		}
		assertFalse("aceita valor nulo",lancouException);
	}
}
