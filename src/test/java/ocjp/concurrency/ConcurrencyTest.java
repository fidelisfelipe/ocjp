package ocjp.concurrency;

import static org.junit.Assert.*;

import java.lang.Thread.State;
import java.util.LinkedList;
import java.util.Queue;

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

class UmaTarefa extends Thread{
	String name = "";
	@Override
	public void run() {
		name = "Java";
		this.yield();
		name += "Tiger";
	}
}
/**
 * 
 * Only one thread at a time may acquire a monitor
 * When the thread exits a synchronized block, it releases the monitor
 * 
 * When a thread encounters a synchronized block, 
 * it must acquire the monitor associated with some Object before proceeding into the block. 
 * When the thread exits a synchronized block, it releases the monitor. 
 * Only one thread at a time may acquire a monitor, 
 * which guarantees that there will never be more than one thread at a time inside the block. 
 * If several blocks of code synchronize on the same object, 
 * then only one thread can be in the entire set of blocks.
 * 
 */
public class ConcurrencyTest extends Thread{
	@Override
	public void run() {
		System.out.println("TarefaTest.run()");
		this.start();
	}
	@Test(expected = IllegalThreadStateException.class)
	public void testTarefaTest() throws Exception {
		ConcurrencyTest t = new ConcurrencyTest();
		t.start();
	}
	
	@Test
	public void testConstructorsThread() throws Exception {
		Runnable runnabled = null;
		ThreadGroup group = null;
		long stackSize = 1;

		Thread t = new Thread();

		t = new Thread("name");
		
		t = new Thread(runnabled);
		
		t = new Thread(runnabled, "name");
		
		t = new Thread(group, runnabled);
		
		t = new Thread(group, runnabled, "name");
		
		t = new Thread(group, runnabled, "name", stackSize);
		
		
	}
	
	
	@Test
	public void testThreadParaTemporariamenteParaExecucaoOutrasMasVoltaAExecutar() throws Exception {
		UmaTarefa tarefa = new UmaTarefa();
		tarefa.run();
		assertTrue(tarefa.name.equals("JavaTiger"));
	}
	
	@Test
	public void testQueueConcept() throws Exception {
		Queue queue = new LinkedList<String>();
		//Retrieves, but does not remove, the head of this queue, returning null id this queue provide additional
		queue.peek();
		
		//Retrieves and removes the head of this queue, or null if this queue is empty
		queue.poll();
		
		//Retrieves and remove the head of this queue
		queue.remove();
		
		
	}
	
	@Test
	public void testInterruptConcept() throws Exception {
		//Interrupted method returns true if the current thread has been interrupted; false otherwise.
		//Interrupted method clear the interrupted status of the thread
	}
	
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

