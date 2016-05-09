package ocjp.flow;

import org.junit.Test;

class MyException extends Exception{
	private static final long serialVersionUID = 1L;}
class MyException2 extends MyException{
	private static final long serialVersionUID = 1L;}
class MyException3 extends RuntimeException{
	private static final long serialVersionUID = 1L;}

public class ExceptionTest {

	@Test
	public void testExceptionHier() throws Exception {
		try{
			String name = "oia";
			if(name == "oia")
				throw new MyException2();
			else
				throw new MyException3();
			
		}catch(MyException2 e1){
			
		}catch(MyException e2){
			
		}catch(MyException3 e3){
			
		}catch (Exception e) {

		}
	}
	
}
