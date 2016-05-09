package ocjp.fundmentals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
class RefObject{
	String name = "name";
	RefObject(){
		name = "new name";
	}
	static void set(Object name){name = null;}
}

//Sobrescrita do método finalize

// quando o objeto é eleito ao coletor, o metodo finalize é chamado
// então se for sobrescrito e for chamado o gc ele vai fazer o que foi delegado no momento da execução, chamado do metodo e chamará o metodo novamente ao limpar o objeto
class TestThread extends Thread{
	public void run(int i) {
		System.out.println("TestThread.run()");
	}
}

class Print{
	int i;
	Print(int i){this.i = i;}
	protected void finalize(){
		System.out.println(i);
		System.out.println("matei o objeto...");
	}
}

class AA{
	int a = 200;
	AA(int b){
		this.a = b;
	}
}
class Testar{
	static void a1(int a){
		a = -1;
	}
	
	static void a1(AA a){
		a.a = -1;
	}
	
}

public class FundamentalsTest {
	
	@Test
	public void testValorReferencia() throws Exception {
		int a = 100;
		Testar.a1(a);
		AA b = new AA(400);
		Testar.a1(b);
		assertTrue(a == 100);
		assertTrue(b.a == -1);
		
	}
	
	@Test
	public void testDeclaratorListNotCompile() throws Exception {
//		List<Object> list = new LinkedList<String>();
	}
	
	@Test
	public void testMap() throws Exception {
		HashMap mapa = new LinkedHashMap();
		assertTrue("é um Map",mapa instanceof Map);
		assertFalse("não é um Collection",mapa instanceof Collection);
		assertTrue("é um HashMap",mapa instanceof HashMap);
		assertFalse("não é um List",mapa instanceof List);
	}
	
	@Test
	public void testCompare() throws Exception {
		Integer num1 = 0;
		Float num2 = -0.0F;
		
		assertTrue(num1.intValue() == num2);
	}
	
	@Test
	public void testCastIntegerInt() throws Exception {
		try {
			String[] args = {};
			int num = new Integer(args[0]);
		} catch (RuntimeException e) {
			// TODO: handle exception
		}// catch (NumberFormatException e) {//está exception é runtime, então deve ser capturada primeiro
				// TODO: handle exception
		//}
		
	}
	
	@Test
	public void testBiBit() throws Exception {
		boolean b1 = true;
		boolean b2 = false;
		
		int result = 1 ^ -1;
		boolean condicaoTrue = false;
		if(b1 ^ b2){//retorna 1 se os bits forem diferentes e 0 caso contrário
			condicaoTrue = true;
			System.out.println(result);
		}else{
			System.out.println("false");
		}
		
		assertTrue(condicaoTrue && result == -2);
	}
	
	@Test
	public void testThread() throws Exception {
		new TestThread().start();
		//não imprime nada pois run não pode ter parametro
	}
	
	@Test
	public void teste(){
		int num = 2;
//		long result = num*0.5;
	}
	
	
	@Test
	public void test(){
		RefObject a = new RefObject();
		a.set(a);
		assertTrue(a.name == "new name");
	}
	
	@Test
	public void testFundamentalImprimeApenasNum5() throws Exception {
		Print a1 = new Print(5);
		a1.finalize();
		Print a2 = new Print(10);
		a1 = null; a2 = null;
		System.gc();
	}
	@Test
	public void testFundamentalImprimeNum5_10_5() throws Exception {
		Print a1 = new Print(5);
		a1.finalize();
		Print a2 = new Print(10);
		a1 = null; a2 = null;
		System.gc();
	}
	@Test
	public void testFundamentalImprimeNum() throws Exception {
		Print a1 = new Print(5);
		a1.finalize();
		a1 = null;
		System.gc();
	}
	
	@Test
	public void testString() throws Exception {
		String name = "123";
		name += 4;
		assertTrue(name.equals("1234"));
	}
	
	@Test
	public void testInt() throws Exception {
		int num = 2;
//		long res = num*0.5;//cannot convert from double to long
	}
	
}


