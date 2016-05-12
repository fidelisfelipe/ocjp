package ocjp.declarations.initialization.scoping;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestInnerClass {
	
	public static String stringPublic = "stringPublic";
	static String stringDefault = "stringDefault";
	protected static String stringProtected = "stringProtected";
	private static String stringPrivate = "stringPrivate";
	
	@Test
	public void testUmaStaticInnerClassAcessaTodosCamposDaClassQueElaEstaInclusa() throws Exception {
		new InnerClass();
	}
	
	static class InnerClass{
		
		public InnerClass() {
			getAccessFieldPublic();
			getAccessFieldDefault();
			getAccessFieldProtected();
			getAccessFieldPrivate();
		}

		public void getAccessFieldPublic(){
				assertTrue(stringPublic.equals("stringPublic"));		
		}
		public void getAccessFieldDefault(){
			assertTrue(stringDefault.equals("stringDefault"));		
		}
		public void getAccessFieldProtected(){
			assertTrue(stringProtected.equals("stringProtected"));		
		}
		public void getAccessFieldPrivate(){
			assertTrue(stringPrivate.equals("stringPrivate"));		
		}
	}
}
