package ocjp.declarations.initialization;

//import ocjp.declarations.initialization.scoping.A.B.*;//fail
import ocjp.declarations.initialization.scoping.A.B;//ok
//import static ocjp.declarations.initialization.scoping.A.*;//ok
//import static ocjp.declarations.initialization.scoping.A.B;//ok
//import static ocjp.declarations.initialization.scoping.A.B.*;//fail
import java.lang.Math;
interface A{String a = "A";}
public class Test extends Thread{
	String $testando = ""; 
	public static void main(String[] args) {
		Object test = new Object();
		
	}
	class Testando implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}
	
}
