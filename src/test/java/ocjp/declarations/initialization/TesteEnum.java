package ocjp.declarations.initialization;

import static org.junit.Assert.*;

import org.junit.Test;

enum AccountType{
	SILVER{double interestRate(){return 10.0;}},
	GOLD{double interestRate(){return 20.0;}},
	DIAMOND{double interestRate(){return 30.0;}};
	
	abstract double interestRate();
}
public class TesteEnum {
	@Test
	public void testEnum() throws Exception {
		for (AccountType iterable_element : AccountType.values()) {
			System.out.println(iterable_element.interestRate());
		}
	}
}
