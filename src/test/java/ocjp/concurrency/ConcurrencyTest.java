package ocjp.concurrency;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConcurrencyTest {

	//Causes the currently executing thread object to temporarily pause 
	//and allow other threads to execute
	@Test
	public void test() throws InterruptedException{
		
//		class Test implements Runnable{
//			String name;
//			
//			public Test(String name) {
//				this.name = name;
//			}
//			
//			@Override
//			public void run() {
//				System.out.println(name);
//			}
//		}
		
//		Thread t1 = new Thread(new Test("t1"));
//		Thread t2 = new Thread(new Test("t2"));
//		
//		t1.run();
//		t2.run();
		
	}
	
	@Test
	public void testThread() throws Exception {
		Thread t = new Thread();
		t.interrupted();
	}
	
}
