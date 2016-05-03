package ocjp.concurrency;

import static org.junit.Assert.*;

import org.junit.Test;
class Tarefa extends Thread{
	@Override
	public void run() {
		System.out.println("run");
		try{
			this.wait(2000);
		}catch(Exception e){
			
		}
	}
}


class OutraTarefa extends Thread implements Runnable{
	@Override
	public void run() {
		System.out.println("OutraTarefa.run()");
	}
}

class MinhaTarefa implements Runnable{
	String name = "Fidelis";
	
	@Override
	public void run() {
		synchronized (this) {
			System.out.println(name);
		}
	}
}

public class ConcurrencyTest {
	@Test
	public void testSyncronize() throws Exception {
		MinhaTarefa minhaTarefa = new MinhaTarefa();
		Thread t = new Thread(minhaTarefa);
		synchronized (minhaTarefa) {
			t.start();
			Thread.sleep(100);
			minhaTarefa.name = "Felipe";
		}
		assertTrue(minhaTarefa.name.equals("Felipe"));
	}
	
	@Test
	public void testOutraTarefa() throws Exception {
		new OutraTarefa().start();
		Runnable tarefa = new OutraTarefa();
		tarefa.run();//neste momento ela é uma Runnable que não tem start e sim run
	}

	@Test(expected = IllegalMonitorStateException.class)
	public void testTarefa() throws Exception {
		Thread tarefa = new Tarefa();
		tarefa.start();
		tarefa.notify();
	}
	
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
