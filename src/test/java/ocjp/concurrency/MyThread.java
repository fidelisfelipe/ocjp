package ocjp.concurrency;

public class MyThread implements Runnable {

	String name = "Joe";
	
	@Override
	public void run() {
		synchronized (this) {
			System.out.println(name);
		}

	}

}
