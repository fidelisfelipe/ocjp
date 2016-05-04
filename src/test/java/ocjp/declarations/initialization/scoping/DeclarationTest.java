package ocjp.declarations.initialization.scoping;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;

import ocjp.declarations.initialization.UmaClasse.UmEnum;

//dá preferência aos tipos simples
//compila sem nenhum erro
class DeclarationMethod{
	String set(int x, int y){return "args";};
	String set(int... x){return "varArgs";};
	void set(String... args){}
	protected void set(String s){System.out.println("DeclarationMethod.set()");}
	
//	int getNumber(short num){return num*2;}
	long getNumber(long num){return num*3;}
//	float getNumber(float num){return num*4;}
	double getNumber(double num){return num*5;}
}
class ThreadTest extends Thread{
	
	public void run(int i) {
		System.out.println("não é o method run de runnabled");
	}
}
class DeclarationMethodChild extends DeclarationMethod{
	
	@Override
	public void set(String o) {
		super.set(o);
	}
}
class TesterDeclaration{
	final Object obj;
	
	TesterDeclaration() {
		obj = null;
		assertFalse(obj instanceof Object);//não há instancia
		
		Integer i = new Integer("1");
		
//		obj = i; //não pode dar outro valor por ser final
		
		
	}
	
}

public class DeclarationTest {
	
	/**
	 * short não aceita integer
	 * double e long aceitan integer
	 * long tem prioridade sobre o double
	 * boolean = 1bit true or false
	 * byte = -128 a 127
	 * short = -32768 a 32767
	 *> int = -2147483648 a 2147483647
	 *> long = -9223372036854775808 a 9223372036854775807
	 *> double = -4.94065645841256533e-324 a 1.79769313486231570e+308
	 *> float = -1.40239846e-45 a 3.40282347e+38
	 * char = uoooo a ufff
	 * 
	 * @throws Exception
	 */
	@Test
	public void testParameterTypePriority() throws Exception {
		DeclarationMethod a = new DeclarationMethod();
		Integer num = 10;
		assertTrue(a.getNumber(num) == 30);
	}
	
	@Test
	public void testEnumDeclare() throws Exception {
		for(UmEnum object: UmEnum.values()){
			assertTrue(object.name().equals("A")
					|| object.name().equals("B")
					|| object.name().equals("C"));
		}
	}
	
	
	@Test
	public void testDeclarationMethod() throws Exception {
		DeclarationMethod d = new DeclarationMethod();
		assertTrue(d.set(1) == "varArgs");
		assertTrue(d.set(1,2) == "args");
		assertTrue(d.set(1,2,3) == "varArgs");
	}
	
	@Test
	public void testMethodInvoke() throws Exception {
		DeclarationMethod declaration = new DeclarationMethod();
		declaration.set(new String[]{"","",""});
		declaration.set("X");
		declaration.set("X","Y");
	}
	
	@Test
	public void testObjectTester() throws Exception {
		new TesterDeclaration();
	}
	
	@Test
	public void testArrayInt() throws Exception {
		int [][] arr = {{1, new Integer(2)},{1,2}};
		assertTrue(arr[1].length == 2);
	}
	
	@Test
	public void testAssert() throws Exception {
		assert true;
	}
	
	@Test
	public void testThread() throws Exception {
		ThreadTest t = new ThreadTest();
		t.start();
	}
	
	@Test
	public void testString() throws Exception {
		String name = "Java Tiger ";
		System.out.println(name + " " +hashCode());
		change(name);
		System.out.println(name + " " +hashCode());
	}
	
	@Test
	public void testCondition() throws Exception {
		Integer num = 0;
		Float num2 = 0.0F;
		if(num.intValue() == num2)
			System.out.println("yes");	
		else
			System.out.println("no");
		
		System.gc();
	}
	
	private static void change(String name){
		name = name.substring(0,  name.length()-3);
	}
	
	@Test
	public void testDeclarationPega() throws Exception {
		Number Float = 99.455f;
	}
	
	@Test
	public void testLocate() throws Exception {
		Locale loc = Locale.US;
	}
	
}
