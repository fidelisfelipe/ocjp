package ocjp.ooconcept;

import static org.junit.Assert.*;

import org.junit.Test;
class Pai{
	/**
	 * methodo
	 * @return
	 */
	Pai methodo(){System.out.println("Pai.methodo()");;return this;}
}
class Filho extends Pai{
	/**
	 * @see ocjp.ooconcept.Pai#methodo()
	 */
	@Override
	Filho methodo() throws RuntimeException{System.out.println("Filho.methodo()");return this;}
}
public class OOTest {
	
	@Test(expected = ClassCastException.class)
	public void testCastClass() {
		Pai Pai = new Pai();
		Filho Filho = new Filho();
		Filho = (Filho)Pai;//não pode converter o pai pro filho
	}
	@Test
	public void testCastClassSuccess() {
		Pai Pai = new Pai();
		Filho Filho = new Filho();
		Pai = (Pai)Filho;//pode converter o filho pro pai
	}
	
	@Test
	public void testCast() throws Exception {
		Pai filho = new Filho();
		filho.methodo();
		Pai pai = new Pai();
		pai.methodo();
		Pai outroPai = (Pai)(Filho)filho; 
		outroPai.methodo();
		Pai outroPai2 = (Pai)filho;
		outroPai2.methodo();
		Pai novoPai = filho;
		novoPai.methodo();
		
	}

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
