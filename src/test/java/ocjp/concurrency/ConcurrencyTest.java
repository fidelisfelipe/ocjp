package ocjp.concurrency;

import static org.junit.Assert.*;

import java.lang.Thread.State;

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

class OutraThread extends Thread{
	int i;
	@Override
	public void run() {
		i++;
	}
}

public class ConcurrencyTest {
	
	@Test
	public void testOutraThreadChamandoStart2x(){
		OutraThread t = new OutraThread();
		t.run();
		assertTrue(t.i == 1);
		t.start();//a thread já executou e finalizou por isso não executará run 2 x
		assertFalse(t.getState() == State.TERMINATED);
		assertTrue(t.i == 1);
	}
	
	@Test
	public void testNotify() throws Exception {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}});
		
		//espera uma notificação
		t.start();
		
		Thread t0 = new Thread(){
			@Override
			public void run() {
				this.notify();
				
			}
		};
		//notifica a thread anterior com notfy
		t0.start();
		
		assertFalse(t.isInterrupted());
	}
	
	@Test
	public void testNotifyAll() throws Exception {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}});
		
		//espera uma notificação
		t.start();
		
		Thread t0 = new Thread(){
			@Override
			public void run() {
				this.notifyAll();
				
			}
		};
		//notifica a thread anterior com notfy
		t0.start();
		
		assertFalse(t.isInterrupted());
	}
	
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
	
	
	@Test
	public void testThread() throws Exception {
		Thread t = new Thread();
		t.interrupted();
	}
	
}

