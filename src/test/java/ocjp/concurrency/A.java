package ocjp.concurrency;

class A extends Thread implements Runnable{
	@Override
	public void run() {
		System.out.println("inside run method");
	}
	
	public static void main(String[] args) {
		new A().start();
		Runnable r = new A();
		r.start();
	}
	
}
