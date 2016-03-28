package ocjp.declarations.initialization.scoping;

import org.junit.Test;

public class ScopeTest {
	@Test
	public void test(){
		class Test{
			void aMethod(String arg){
				
			}
		}
		class TestCustom extends Test{
			void aMethod(int arg) {};
//			String aMethod(String arg) {};//alterando só o retorno não compila
//			private void aMethod(String arg) {};//restringindo mais o modificador não compila
			protected void aMethod(String arg) throws IndexOutOfBoundsException {};//ampliou o modificador e lançou exception
		}
	}
}
