package ocjp.concurrency;

class A extends Thread{
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
		Thread t = new A();
		t.start();
		t.notify();
	}
	
	public Ob test(){
		return null;
	}
}
