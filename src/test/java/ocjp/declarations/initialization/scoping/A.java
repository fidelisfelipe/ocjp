<<<<<<< HEAD
package ocjp.declarations.initialization.scoping;

class A {
	static String name = "";
	public A() {
		
	}
	String getName(){
		return name;
	}
}
class B extends A{
	public String getName() throws RuntimeException{
		return "outro";
	}
}
=======
package ocjp.declarations.initialization.scoping;

public class A {
	public enum B{A,B,C}
}
>>>>>>> fed9ffc4680653b996d711858a35673039b897e7
