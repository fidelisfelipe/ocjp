package ocjp.collections.generic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;
class TestComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
class TestComparable implements Comparable<String>{

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
public class CollectionsTest {
	
	@Test
	public void testListStringOrInteger() throws Exception {
		List list = new ArrayList<Integer>();
		list.add(new String("123"));
		System.out.println(list);
	}
	
	@Test
	public void testHashSet() throws Exception {
		String [] list = {"1","2","3","4","5","6","7","8","9","10"};
		Set set = new HashSet(Arrays.asList(list));
		set.add(list[0]);
		set.add(list[1]);
		assertTrue(set.size() == 10);
	}
	
	@Test
	public void testList() throws Exception {
		List<? super Integer> list = new ArrayList<Integer>();
		list.add(200);//compila e executa com sucesso
	}
	
	@Test
	public void testAumentarCapacidadeDoArrayList() throws Exception {
		//por padrão a lista reserva 10 alocações para objetos
		ArrayList list = new ArrayList();
		//assim esta alocação vai para 20 objetos
		list.ensureCapacity(5);
		//mas ele não pode reduzir o tamanho mínimo de 10 para 5 por exemplo
	}
	
	@Test
	public void testQueueVoltaSemRemoverDepoisRemoveOPrimeiroDaFila() throws Exception {
		Queue<Integer> fila = new LinkedList<Integer>();
		
		fila.add(1);
		fila.add(2);
		fila.add(3);
		//volta e não remove
		fila.peek();
		//remove
		fila.remove();
		
		assertTrue("[2, 3]".equals(fila.toString()));
	}
	
	@Test
	public void testQueueVoltaERemoveOPrimeiroDaFila() throws Exception {
		Queue<Integer> fila = new LinkedList<Integer>();
		
		fila.add(1);
		fila.add(2);
		fila.add(3);
		//volta e não remove
		fila.poll();
		//remove
//		fila.remove();
		
		assertTrue("[2, 3]".equals(fila.toString()));
	}
	
	@Test
	public void testArrayListType() throws Exception {
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(new Double(9.0));
		System.out.println(list);
	}
	
	@Test
	public void testQueueVoltaERemoveOPrimeiroDaFila2() throws Exception {
		Queue<Integer> fila = new LinkedList<Integer>();
		
		fila.add(1);
		fila.add(2);
		fila.add(3);
		//volta e não remove
//		fila.poll();
		//remove
		fila.remove();
//		
		assertTrue("[2, 3]".equals(fila.toString()));
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
