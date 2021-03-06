package ocjp.declarations.initialization.scoping;

import static org.junit.Assert.*;

import org.junit.Test;
enum TestAbstracMethod{
	A{double getVal(){return 10.0;}},
	B{double getVal(){return 20.0;}},
	C{double getVal(){return 30.0;}};
	abstract double getVal();
}
interface C{
	void getValue();
}
class D{
	protected void getNewVal(){}
}

class TestCustom {
	void aMethod(int arg) {};
//	String aMethod(String arg) {};//alterando só o retorno não compila
//	private void aMethod(String arg) {};//restringindo mais o modificador não compila
	protected void aMethod(String arg) throws IndexOutOfBoundsException {};//ampliou o modificador e lançou exception
}

interface ITestar{
	String show();
}
class TestarImpl extends java.lang.Object implements ITestar{
	String name = "DEFAULT VALUE";
	@Override
	public String show() {
		return null;
	}

	@Override
	protected void finalize(){
		name = null;
	}
	
}

public class ScopeTest extends D implements C{
	@Test
	public void test(){
		for(TestAbstracMethod a: TestAbstracMethod.values()){
			assertTrue(a.getVal() == 10 || a.getVal() == 20 || a.getVal() == 30);
		}
	}
	//-----------------------------------------------------------------
//Sobrescrita de metodos deve ter um modificador menos restritivo(só pode sobrescrever se aumentar o acesso, nunca reduzindo o acesso)
//inválido pois por default metodo da interface é public
//	@Override
//	protected void getValue(){}

	//Cannot reduce the visibility of the inherited method from
	//Not less accessible
	@Override
	public void getValue() {
		// TODO Auto-generated method stub
	}
//-----------------------------------------------------------------	
//inválido pois restringiu para default
//	@Override
//	void getNewVal(){}
	@Override
	public void getNewVal(){}
	
	@Test
	public void testDeclarationScope() throws Exception {
		final String varOne;
//		static String varTwo; // não pode ser declarada como final
//		private String varOne;// não pode ter modificador
//		public String varTwo;//nem mesmo public
	}
	
	@Test
	public void testFinalize() throws Exception {
		Object object = new TestarImpl();
//		object.finalize(); //não compila pois não é acessivel pela instancia
		System.out.println(object);
	}
	
}

