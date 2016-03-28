package ocjp.collections.generic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author Fidelis
 *
 */
public class ArraysTest {

	@Test
	public void testAsListSuccess(){
		Integer num = 10;
		//converte Array ou Object para list
		List<Integer> result1 = Arrays.asList(num);
		assertTrue("a lista deve conter um objeto", result1.size() == 1);
		
		String [] arrayChar= {"valor a", "valor b"};
		List<String> result2 = Arrays.asList(arrayChar);
		
		assertTrue("a lista deve conter "+arrayChar.length+" objetos", result2.size() == arrayChar.length);
		
		Integer [] array = {1,2,3};
		List<Integer> result3 = Arrays.asList(array);
		assertTrue("a lista deve conter "+array.length+" objetos", result3.size() == array.length);
		
	}

	@Test(expected = NullPointerException.class)
	public void testAsListFail(){
		//lançará nullpointerexception
		Arrays.asList(null);
	}

	@Test
	public void testBinarySearchSuccess(){
		Integer[] arrayInt = new Integer[]{4,6};
		//retorna o indice encontrado ou -1
		int key = 4;
		int result = Arrays.binarySearch(arrayInt, key);
		assertTrue("deve retornar o indice 0 ",result == 0);
	}

	@Test
	public void testDeepEqualsSuccess(){
		String[] a1 = {"valor a"};
		String[] a2 = {"valor a"};
		boolean result = Arrays.deepEquals(a1, a2);
		assertTrue("deve retornar true ", result);
	}

	@Test
	public void testCopyOfRangeSuccess(){
		String [] array = {"a","b"};
		int de = 0;
		int para = 1;
		//copia o intervalo "exclusivo" para
		String [] result = Arrays.copyOfRange(array, de, para);
		
		String [] expected = {"a"};
		assertEquals("deve retornar arrays esperado ", expected, result);
	}

	@Test
	public void testCopyOfSuccess(){
		String [] origem = {"a","b"};
		//copia array para novo array de tamanho informado
		//trunka as informações
		int newLength = 1;
		String [] result = Arrays.copyOf(origem, newLength);
		
		assertEquals("deve retornar arrays esperado ", result.length, newLength);
		assertEquals("deve retornar arrays esperado ", "[a]", Arrays.toString(result));
	}

	@Test
	public void testFillSuccess(){
		Integer[] array = {1,2,3};
		//atribui valor a todos os campos do array
		Arrays.fill(array, 0);
		Integer[] esperado = {0,0,0};
		assertEquals("deve ter atribuido zero para todos os elementos", Arrays.toString(esperado), Arrays.toString(array));
	}

	@Test
	public void testFillRangeSuccess(){
		int de = 0;
		int ate = 2;
		
		Integer[] array = {1,2,3};
		//atribui valor a todos os campos do array "exclusivo"
		Arrays.fill(array, de, ate, 0);
		
		Integer[] esperado = {0,0,3};
		assertEquals("deve ter atribuido zero para range do array", Arrays.toString(esperado), Arrays.toString(array));
	}
	
	@Test
	public void testSortAllSuccess(){
		
		Integer[] array = {3,1,2};
		//atribui ordernar todo o array
		Arrays.sort(array);
		
		Integer[] esperado = {1,2,3};
		assertEquals("deve ordenar o array", Arrays.toString(esperado), Arrays.toString(array));
	}
	
	@Test
	public void testSortAllStringSuccess(){
		
		String[] array = {"01","03","02"};
		//atribui ordernar todo o array
		Arrays.sort(array);
		
		String[] esperado = {"01","02","03"};
		assertEquals("deve ordenar o array string ", Arrays.toString(esperado), Arrays.toString(array));
	}
	@Test
	public void testSortRangeSuccess(){
		int de = 1;
		int ate = 3;
		
		String[] array = {"04","03","02"};
		//atribui ordernar todo o array
		Arrays.sort(array, de, ate);
		
		String[] esperado = {"04","02","03"};
		assertEquals("deve ordenar o array string apenas range especificado", Arrays.toString(esperado), Arrays.toString(array));
	}
	
	@Test(expected = ClassCastException.class)
	public void testSortFail(){
		int de = 0;
		int ate = 3;
		
		Object[] array = {1,"2","0"};
		//atribui ordernar todo o array
		Arrays.sort(array, de, ate);

		assertTrue("deve lançar ClassCastException ", false);
	}
	
	//--
	
	
	
	
	
}
