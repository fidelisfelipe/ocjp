package ocjp.flow;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;
class A3{}
class B extends A3{}
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
		
		
		A3 B = new A3();
		B A3 = new B();
		A3 = (B)B;
		
		
	}
	
}
