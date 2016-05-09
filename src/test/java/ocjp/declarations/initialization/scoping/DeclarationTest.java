package ocjp.declarations.initialization.scoping;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

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

interface IAccount{
	String getAccountNumber();
}

abstract class Account implements IAccount{
	public abstract String getAccountNumber();
}
class Account2 implements IAccount{
	public String getAccountNumber(){
		return "";
	}
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


abstract class Customer{
	String custName;
	abstract Object getCusName();
}



public class DeclarationTest extends Customer{
	static String name1 = "Java";
	
	@Test
	public void testStringCompare() throws Exception {
		String name2 = "Java";
		String name3 = new String(name1);
		
		assertTrue("termo static",name1 == name2);
		assertTrue("termo static", name1.equals(name2));
		assertFalse("criou um novo objeto",name3 == name1);
		assertTrue("mesmo valor ",name3.equals(name1));
	}
	
	
	@Test
	public void testVectorObject() throws Exception {
		Vector vect = new Vector();
		vect.add(new Object());
		vect.add(new DeclarationTest());
	}
	
	@Override
	Object getCusName() {
		return custName;
	}
	
	@Test
	public void testHerancaPacote(){
		DeclarationTest jon = new DeclarationTest();
		jon.custName = "Jonh";
		System.out.println(jon.getCusName());
	}
	
	private synchronized static void testSincronyzed(){}
	
	int val;
	
	@Test
	public void testIntInteger2() throws Exception {
		String str = "10";
		int a  = new Integer(10);
//		boolean b = str == a;//not compile pois os tipos são incompatíveis
	}
	@Test
	public void testIntInteger() throws Exception {
		String str = "10";
		int a  = new Integer(10);
		str += a;
	}
	@Test
	public void testIntInteger3() throws Exception {
		String str = "10";
		int a  = new Integer(10);
		boolean b = str == a+"";
	}
	
	@Test
	public void testDeclarArray() throws Exception {
		int[] arr1 = new int[]{};
		String[] arr2 = new String[]{};
		boolean isObject = false;
		if(arr1 instanceof Object){
			isObject = true;
		}
		assertTrue(isObject);
	}
	
	@Test
	public void testDeclareVargs() throws Exception {
		Integer arr[] = {2,1,0};
//		print(arr);deve ser integer e não int
	}
	
	private void print(int... arr) {
		for (int i : arr) {
			System.out.println(i);
		}		
	}

	@Test
	public void testAndBitBit() throws Exception {
		Integer a = 123;
		float b = 123f;
		boolean c = false;
		
		boolean assertTest = false;
		if(c & a == b){
			assertTest = true;
		}
		assertFalse(assertTest);
	}
	
	@Test
	public void testBitBitDeclarate() throws Exception {
		assertTrue((4&4) == 4);
	}
	
	@Test
	public void testBitBitCast() throws Exception {
		int value = testHashCode(val);
		assertTrue(value == 5);
	}

	private int testHashCode(int val) {
		return (int)val ^ 5;
	}
	
	@Test
	public void testIntegerfordouble() throws Exception {
		List<Integer> list = new ArrayList<Integer>();
		list.add(90);
//		list.add(9.0);not compile double for integer
	}
	
	@Test
	public void testDeclarefloat() throws Exception {
		int in = 16;
//		float fl = in/0.5;not compile, cast for float the double
//		
	}
	
	@Test
	public void testStringNulaNoObject() throws Exception {
		String num = "";
		num = null;
		
		boolean isObject = false;
		if(num instanceof Object){
			isObject = true;
		}
		assertFalse(isObject);
	}
	
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
