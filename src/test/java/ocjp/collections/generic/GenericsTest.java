package ocjp.collections.generic;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import org.junit.Test;

public class GenericsTest {

	@Test
	public void testSetNotContainsItensRepeated(){
		int sizeExpected = 3;
		Set<Integer> list = new HashSet<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		
		assertEquals("não deve conter itens repetivos ", sizeExpected, list.size());
	}
	
	@Test
	public void test(){
		Vector<String> string = new Vector<String>();
		Vector<Integer> integer = new Vector<Integer>();
		Vector<Object> objects = new Vector<Object>();
		
		System.out.println("String: "+string.getClass());
		System.out.println("Integer: "+integer.getClass());
		System.out.println("Objetcs: "+objects.getClass());
		assertTrue(string.getClass() == integer.getClass());
		assertTrue(string.equals(objects));
		assertTrue(string.getClass() == objects.getClass());
		assertTrue(integer.equals(objects));
		
	}
	
	@Test
	public void test2() throws Exception {
		Integer studentRollNo = 145;
		Object num1 = new String("145");
		Object num2 = studentRollNo;
		studentRollNo = null;
		Object num4 = num2.toString();
		System.out.println(num1.equals(num4));
	}
	
}
