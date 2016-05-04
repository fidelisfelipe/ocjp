package ocjp.fundmentals;

import static org.junit.Assert.*;

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
class Print{
	int i;
	Print(int i){this.i = i;}
	protected void finalize(){
		System.out.println(i);
		System.out.println("matei o objeto...");
	}
}
public class FundamentalsTest {
	
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


