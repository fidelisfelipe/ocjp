package ocjp.flow.control;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Testando{
	public Testando() {
	}
	
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
	@Test
	public void test() throws Exception {
		new Testando().testMethod();
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
}
