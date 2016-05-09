package ocjp.flow.control;

import static org.junit.Assert.*;

import org.junit.Test;

class Testando{
	public Testando() {
	}
	
	void get(short num){System.out.println("Testando.get(short)");}
	void get(double num){System.out.println("Testando.get(double)");}
	void get(long num){System.out.println("Testando.get(long)");}
	
	void testMethod(){
		try{
			System.out.println("Java");
			return;
		}finally{
			System.exit(0);
			System.out.println("Tiger");
		}
		
	}
}




public class FlowControlTest {
	static final int TV = 0;
	static final int LIGTH = 1;
	static int DVD = 2;
	
	
	public Boolean isValid(int i){
		if(i < 1 || i > 12)
			return new Boolean("incorrect value");
		else
			return new Boolean(true);
	}
	
	private void testValue(int val){
		assert isValid(val) : "Out of range value";
	}
	
	
	
	@Test
	public void testSampleAssert(){
		FlowControlTest test = new FlowControlTest();
		test.testValue(22);
	}
	
	@Test
	public void test() throws Exception {
		new Testando().testMethod();
	}
	
	@Test
	public void testarInstance(){
		Integer i = 0;
		if(i instanceof Object){
			System.err.println(true);
		}else{
			System.out.println(false);
		}
	}
	
	@Test
	public void testSwitch() {
			int arg = 10;
			
			String result = "";
			String expected = "JSPEJBJMSJNDI";
			
			switch (arg) {
			case 0:  result = result.concat("Java");
			case 10: result = result.concat("JSP");
			case 20: result = result.concat("EJB");
			case 30: result = result.concat("JMS");
			case 40: result = result.concat("JNDI"); break;

			default: result = result.concat("None");
			}
			
			assertEquals("deve conter a string esperada",expected, result);
			
		}
	
	@Test
	public void testAssertsDeclaration() throws Exception {
		String name = null;
		assert (name != null);
		
//		int i = 10; assert(i=15+i++);declaração incorreta pois não retorna boolean
		
		boolean flag = false;
		assert(flag = true);
		
		String string = null;
		assert false: string;
		
	}
	
	@Test
	public void testSwitch2() throws Exception {
		Integer arg = 20;
		//Sim, pode se declarar assim
		switch (arg) {
		default:
			System.err.println("no defined");
		case 10:
			System.out.println("ok is 100");
		case 20:
			System.out.println("ok is 200");

		}
	}
	
	@Test
	public void testSobrecarga() throws Exception {
		Integer num = new Integer(20);
		Testando t = new Testando();
		t.get(num);
	}
	
	
	@Test
	public void testSwitchFlow() throws Exception {
		String [] args = {"0"};
		
		on(Integer.parseInt(args[0]));
	}

	private void on(int args) {
		switch (args) {
		case LIGTH:
			System.out.println("LIGTH");
			break;
		case TV:
			System.out.println("TV");
			break;
//		case DVD://deve ser final
//			System.out.println("DVD");
//			break;

		default:
			break;
		}		
	}
}

