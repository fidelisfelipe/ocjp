package ocjp.concurrency;

public class Test {

	public static void main(String[] args) throws Exception {
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread);
		synchronized (myThread) {
			thread.start();
			Thread.sleep(100);
			myThread.name = "Pop";
		}
	}
	
}
