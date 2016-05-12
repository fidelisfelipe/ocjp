package ocjp.declarations.initialization.scoping;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import org.junit.Test;

import ocjp.declarations.initialization.UmaClasse;
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

class OutraClasse extends UmaClasse{
}
interface ITestandoModificador{//only public & abstract are permitted
	
}
abstract class OlhaOPega{
	public void print(){}
}


class Subb{
	Object get(){
		return "Sub";
	}
}
class Superr extends Subb{
	@Override
	protected String get(){
		return "Super";
	}
}
class Uma{
	String method = "Uma";
	String getMethod(){
		return method;
	}
	float a(){return 1.2f;}
}
class Outra extends Uma{
	String method = "Outra";
	String getMethod() throws RuntimeException{
		return method;
	}
//	Float a(){return 1.2f;}//não compila 
}
enum Month{
	JAN{void test(){}},
	MAY{void test(){}},
	JUN{void test(){}};
	abstract void test();
//	void test();//not compile
}
public class DeclarationTest extends Customer{
	
	final String s = "JAVA";
	
	class InnerDeclar{
		String s = "Java7";
		void print(){
			System.out.println(DeclarationTest.this.s);
		}
	}
	
	static String name1 = "Java";
	
	@Test(expected = ClassCastException.class)
	public void testException() throws Exception {
		Object number = new Object();
		float f = ((Number)number).floatValue();//java.lang.Object cannot be cast to java.lang.Number

	}
	
	@Test
	public void testDeclarationInvalidA() throws Exception {
		String str = "10";
		int a = new Integer(10);
//		boolean b = str == a;//incompatible operand types String and int
	}
	@Test
	public void testDeclarationInvalidB() throws Exception {
		String str = "10";
		Integer a = 10;
		boolean b = str == a.toString();//incompatible operand types String and int
	}
	@Test
	public void testDeclarationInvalidC() throws Exception {
		String str = "10";
		Integer a = 10;
		boolean b = str == a+"";//incompatible operand types String and int
	}
	@Test
	public void testDeclarationValid() throws Exception {
		String str = "10";
		int a = new Integer(10);
//		str += a;//incompatible operand types String and int
	}
	
	@Test
	public void testIntegerParseLong()  {
		Integer.parseInt("123l");
	}
	
	@Test
	public void testlongLongArray() throws Exception {
		Long arr[] = {2l,1l,0l};
//		print(arr);//in the type DeclarationTest is not applicable for the arguments (Long[])
	}
	
	private void print(long... arr){}
	@Test
	public void testToArrayVector() throws Exception {
		Vector<String> set = new Vector<String>();
//		String [] arr = set.toArray();//return object: Type mismatch: cannot convert from Object[] to String[]
	}
	@Test
	public void testCastFloat() throws Exception {
		float f = (float)23.0;
	}
	@Test
	public void testIlegalDeclarators() throws Exception {
//		String arr[200];//Syntax error on token "2", delete this token
//		String arrr[2] = new String[]{};Syntax error on token "2", delete this token
		String arr [] = null;
	}
	
	@Test
	public void testMonth() throws Exception {
		//Month may = new Month();//não instancia enum
		assertTrue(Month.values()[0] == Month.JAN);
		assertTrue(Month.JAN.ordinal() == 0);
		assertTrue(Month.JAN.name() == "JAN");
		assertFalse(Month.JAN.equals("JAN"));
		assertTrue(Month.JAN.name().equals("JAN"));
		
	}
	
	@Test
	public void testLongArrayList() throws Exception {
		ArrayList list = new ArrayList<Long>();
		list.add(new Integer(223));
		list.add(223l);
		list.add(new Integer(223));
	}
	
	@Test
	public void testModIntDouble() throws Exception {
		int num = -50;
		System.out.println((num % 25.0));
		assertTrue((num % 25.0) == 2);
	}
	
	@Test
	public void testArrayLenght() throws Exception {
		String args[] = {"java","Test"};
		assertTrue(args.length == 2);
		assertTrue(args[0].length() == 2);
		
	}
	
	@Test
	public void testStringListComInteger() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
//		list.add(new Integer(2));//não compila
	}
	
	@Test
	public void testCharEqualsCharacter() throws Exception {
		Character a = 65;
		char c = 65;
		if(c == a){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
	@Test
	public void testVector() throws Exception {
		Object a = new String("Java Tiger");
		Object b = 99;
		Object c = new Vector<String>();
		Object d = a;
		a = c;
		c = b;
		b = a;
	}
	
	@Test
	public void testEqualsStringBuffer() throws Exception {
		StringBuffer sb = new StringBuffer("java");
		StringBuffer sb2 = new StringBuffer("java");
		assertFalse(sb == sb2);
		assertFalse(sb.equals(sb2));
	}
	
	@Test
	public void testUmaOutra() throws Exception {
		Uma a = new Outra();
		assertTrue(a.method.equals("Uma"));
		assertTrue(a.getMethod().equals("Outra"));
	}
	
	@Test
	public void testLaco() throws Exception {
		Integer num = 0;
		for(int i=0; i<0;i++)
			for(int j=0; j<10;j++)
			  num = 10-(i+j);
		int num2 = num;
		System.out.println(num2);
	}
	
	@Test
	public void testOperations() throws Exception {
		byte b1 = ~5+1;//inverte e incrementa
//		byte b2 = +b1;
		System.out.println(b1);
	}
	
	@Test
	public void testPrecisaoDouble() throws Exception {
		double a = 7.77;
		double b = 8.67;
		double c = 9.97;
		System.out.printf("%.1f %.1f %.1f ",a,b,c);
	}
	
	@Test
	public void testGHenerics() throws Exception {
		List<String> strings = new Vector<String>();
		List<?> sub = strings;
	}
	
	@Test
	public void testCondition2() throws Exception {
		boolean b1 = true;
		Boolean b2 = false;
		if(b2||b1 == false){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
	@Test
	public void testCovariante() throws Exception {
		Subb sub = new Subb();
		Subb sup = new Superr();
		System.out.println(sub.get()+" - "+sup.get());
	}
	
	@Test
	public void testCommandLine() throws Exception {
		String[]args = {"x7+y8-z9=4P","[4789][+-=]"};
		assertTrue((args[0].split(args[1])).length == 4);
	}
	
	@Test
	public void testNaoPerdePrecisao() throws Exception {
		double doubleNum = 999.3550;
		System.out.printf("%.2f",doubleNum);
	}
	
	@Test
	public void testValores() throws Exception {
		Integer x,y,z;
		for(x =10, y=11,z=12; x<y && x<z; x++,y--,z++){
			assertTrue(x == 10);
			assertTrue(y == 11);
			assertTrue(z == 12);
		}
	}
	
	@Test
	public void testConditions() throws Exception {
		Integer a = 123; 
		float b = 123f;
		boolean c = false;
		boolean testFalse = false;
		
		if(c & a == b){//& retorna 1 se forem ambos bits iguais e retorna 0 se forem diferentes
			testFalse = true;
		}
		
		assertFalse(testFalse);
	}
	
	@Test
	public void testStringandStringBuffer() throws Exception {
		String a = new String("Java");
		StringBuffer sb = new StringBuffer("Tiger");
		String result = appender(a,sb);
		assertTrue(result.equals("JavaTiger"));
	}
	
	private String appender(Object... stringObjects){
		String string = "";
		
		for(Object out: stringObjects){
			string += out.toString();
		}
		
		return string;
	}
	
	@Test
	public void testWrapperPrimitivesAssociate() throws Exception {
		int a = new Integer("1");
		char b = new Character(Character.MIN_VALUE);//não confunir Char(NÃO EXISTE) com Character
		float c = new Float(1.0);
		double d = new Double(2.0);
		long e = new Long(12345);
	}
	
	@Test
	public void testProtected() throws Exception {
		new UmaClasse();
		new OutraClasse();
	}
	
	@Test
	public void testStringCompare() throws Exception {
		String name2 = "Java";
		String name3 = new String(name1);
		
		assertTrue("termo static",name1 == name2);
		assertTrue("termo static", name1.equals(name2));
		assertFalse("criou um novo objeto",name3 == name1);
		assertTrue("mesmo valor ",name3.equals(name1));
	}
	int b;
	Integer a;
	@Test
	public void testIntegerIntPodemSerUtilizadosSemInicializarAssumindoValoresPadraoNullEZero() throws Exception {
		assertTrue(a == null);
		assertTrue(b == 0);
	}
	@Test
	public void testIntegerIntDevemSerInicializadosNoScopoMethodo() throws Exception {
		int b;
		Integer a;
//		assertTrue(a == null); The local variable a may not have been initialized
//		assertTrue(b == 0); The local variable a may not have been initialized
	}
	
	@Test
	public void testConcatIntComString() throws Exception {
		int a = 1;
		String b = "2";
		
		b += a;
		
		assertTrue(b.equals("21"));
	}
	
	@Test
	public void testAndBitbitCidadoComTiposDiferentesPedindoComparacaoObjeto() throws Exception {
		Integer a = 123;
		float b = 123f;
		boolean c = false;
//		if(c & (a == c)){//The operator == is undefined for the argument type(s) int, boolean
//		if(c | (a == c))////The operator == is undefined for the argument type(s) int, boolean
//		}
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
