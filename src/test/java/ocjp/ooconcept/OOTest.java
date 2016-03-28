package ocjp.ooconcept;

import org.junit.Test;

public class OOTest {

	@Test
	public void test(){
		class Test{
			public void test(){}
		}
		class TestCustom extends Test{
//			public void test() throws Exception{
				//a subclasse não pode ser mais restritiva que a superclass
//			}
		}
		
	}
	
	@Test
	public void testSuper(){
		class Test{
			public void test(){}
		}
		class TestCustom extends Test{
			public void test() {super.test();};
		}
	}
	
}
