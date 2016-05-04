package ocjp.concurrency;

class A1 extends Thread{
	@Override
	public void run() {
		try {
			this.wait(2000);
		} catch (Exception e) {
			
		}
	}
	
}
class Teste<Ob>{
	public static void main(String args[]) {
		Thread t = new A1();
		t.start();
		t.notify();
	}
	
	public Ob test(){
		return null;
	}
}
