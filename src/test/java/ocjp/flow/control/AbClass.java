package ocjp.flow.control;

import java.util.Set;
import java.util.TreeSet;

public class AbClass {
	
	
	
	public static void main(String[] args) {
		Set<AbClass> s = new TreeSet<AbClass>();
		s.add(new AbClass());
		s.add(new AbClass());
		s.add(new AbClass());
		s.add(new AbClass());
		s.add(new AbClass());
		
		for (AbClass abClass : s) {
			System.err.println(abClass);
		}
		
	}
	
	@Override
	public String toString() {
		return "AB";
	}

}
