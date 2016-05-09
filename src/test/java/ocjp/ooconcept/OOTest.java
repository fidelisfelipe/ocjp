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
	
	@Test
	public void testCasting() throws Exception {
		Filho filho = new Filho();
		Pai pai = new Pai();
		
		assertTrue("filho é um pai ",filho instanceof Pai);
		assertFalse("pai não é filho ", pai instanceof Filho);
		
		//não compila
		//filho = pai;//pai é um filho
		
		boolean lancaException = false;
		try{
			filho = (Filho)pai;//pai não conhece o filho
		}catch(ClassCastException e){
			//pai não conhece o filho, mas para compilação pode ser explicito o cast
			//mesmo assim o pai ainda nao conhece o filho
			
			lancaException = true;
			
		}
		
		assertTrue("o pai lança exception pois ele não conhece o filho", lancaException);
		
		//passando o filho para o pai
		//o filho é parte do pai
		//o filho conhece o pai
		pai = filho;//filho é um pai
		pai = (Filho)filho;//filho é um filho 
		pai = (Pai)filho;//filho é um pai
	}
	
	@Test(expected = ClassCastException.class)
	public void testCastClass() {
		Pai Pai = new Pai();
		Filho Filho = new Filho();
		Filho = (Filho)Pai;//não pode converter o pai pro filho
		
//		Filho = Pai; 
//		Filho = (Pai)Pai;
		Filho = (Filho) Pai;
		Pai = (Filho)Filho;
		Pai = Filho;
		Pai = (Pai)Filho;
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

