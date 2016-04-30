package ocjp.flow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class FileTest {

	@Test
	public void test() throws Exception {
		try {
			File file = new File("fist file");
			throw new FileNotFoundException();
		} catch (RuntimeException e) {
			// TODO: handle exception
		}catch (FileNotFoundException e) {
			// TODO: handle exception
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		class A{}
		class B extends A{}
		
		A B = new A();
		B A = new B();
		A = (B)B;
		
		try{
			
		}
		
	}
	
}
