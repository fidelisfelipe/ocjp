package ocjp.declarations.initialization;

//import ocjp.declarations.initialization.scoping.A.B.*;//fail
import ocjp.declarations.initialization.scoping.A.B;//ok
//import static ocjp.declarations.initialization.scoping.A.*;//ok
//import static ocjp.declarations.initialization.scoping.A.B;//ok
//import static ocjp.declarations.initialization.scoping.A.B.*;//fail

public class Test {
	public static void main(String[] args) {
		for (B string : B.values()) {
			
		}
	}
}
