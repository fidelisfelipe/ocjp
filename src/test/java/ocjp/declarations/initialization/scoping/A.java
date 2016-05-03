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
