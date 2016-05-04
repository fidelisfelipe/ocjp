package ocjp.declarations.initialization;

//import ocjp.declarations.initialization.scoping.A.B.*;//fail
import ocjp.declarations.initialization.scoping.A.B;//ok
//import static ocjp.declarations.initialization.scoping.A.*;//ok
//import static ocjp.declarations.initialization.scoping.A.B;//ok
//import static ocjp.declarations.initialization.scoping.A.B.*;//fail

//import java.io;
//static import java.lang.Math;
import java.lang.Math;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.Math.*;

import java.io.IOException;
//static import java.lang.Math.*;

class Neus{
	String method = "Neus";
	public Neus() {
		
	}
	public float get() throws 
	Exception{
		return 2.7f;
	}
}

class Old extends Neus{
	String method = "Old";
	public Old() {
		
	}
	@Override
	public float get() throws IOException{
		return 7.2f;
	}
}

public class Test extends Thread{
	
	public Test() {
		System.out.println("oia");
	}
	
	public String toString() {return "Test";};
	Integer flag = 0;
	public void aMethod(){
		boolean debug = false;
		assert debug = true: "Raise Error";
		Integer num = 10;
		int result = num + 100;
		System.out.println("Result"+result);
	}
	
	public static void main(String[] args) throws Exception {

		
		Neus a = new Old();
		System.out.println(a.method);
		System.err.println(a.get());
		
		
	}
}