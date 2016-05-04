package ocjp.declarations.initialization.scoping;

class A1 {
	static String name = "";
	public A1() {
		
	}
	String getName(){
		return name;
	}
}
class B1 extends A1{
	public String getName() throws RuntimeException{
		return "outro";
	}
}

public class A {
	public enum B{A,B,C}
}

