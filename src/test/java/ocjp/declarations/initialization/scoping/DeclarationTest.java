package ocjp.declarations.initialization.scoping;

import static org.junit.Assert.*;

import org.junit.Test;

import ocjp.declarations.initialization.UmaClasse.UmEnum;

//dá preferência aos tipos simples
//compila sem nenhum erro
class DeclarationMethod{
	String set(int x, int y){return "args";};
	String set(int... x){return "varArgs";};
	void set(String... args){}
	protected void set(String s){System.out.println("DeclarationMethod.set()");}
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

public class DeclarationTest {
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
}
