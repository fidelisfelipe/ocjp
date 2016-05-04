package ocjp.collections.generic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import org.junit.Test;
class GenericDeclarations<T>{
//	static T getOb(){//não pode criar generic para uso static por trabalhar em tempo de execução
//		return null;
//	}
	T getOb(){
		return null;
	}
}
class GenericOne{
	
}
class GenericTwo extends GenericOne{
	
}

class A{
	int a = 200;
	A(int b){
		this.a = b;
	}
}

class Testar{
	static void a1(int a){
		a =-1;
	}
	static void a1(A a){
		a.a = -1;
	}
}

public class GenericsTest {
	
	@Test
	public void testLinkedDeclaration() throws Exception {
//		List<Object> lista = new LinkedList<String>(); não compila se os tipos forem diferentes
		
	}
	
	@Test
	public void testName() throws Exception {
		Set<String> list = new HashSet<String>();
		assertTrue(list.size() == 0);
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
	
	@Test
	public void test3() throws Exception {
		class Super{}
		class Sub extends Super{}
		class Sub2 extends Sub{}
		ArrayList a = new ArrayList();
		a.add(new Super());
		a.add(new Sub());
		a.add(new Sub2());
		
		for (Object object : a) {
			System.out.println(object);
		}
		
	}
	
	@Test
	public void testCast() throws Exception {
		Integer n1 = new Integer(0);
		Byte n2 = new Byte((byte)0);
		System.out.println(n1.equals(n2));
	}
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
	public void testDeclarationWarning(){
		ArrayList list = new ArrayList();
		list.add(new GenericOne());
		list.add(new GenericTwo());
		for (Object object : list) {
			assertTrue(object.getClass() == GenericOne.class 
					|| object.getClass() == GenericTwo.class);
		}
	}
	
	@Test
	public void testGenericCast() throws Exception {
		Integer n1 = new Integer(0);
		Byte n2 = new Byte((byte)0);
		assertFalse(n1.equals(n2));
		assertTrue(n1.intValue() == n2.intValue());
	}
	
}

