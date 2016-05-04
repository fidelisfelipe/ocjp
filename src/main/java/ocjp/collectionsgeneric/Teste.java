package ocjp.collectionsgeneric;

import java.util.PriorityQueue;

/**
 * @author Fidelis
 *
 */
public class Teste {
	public static void main(String[] args) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		for (int i = 0; i < 5; i++) {
			p.add(new Integer(i));
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(p.size());
		}
		
		for (int i = 0; i < 1; i++) {
			System.out.println(p.poll());
		}
	}
}
