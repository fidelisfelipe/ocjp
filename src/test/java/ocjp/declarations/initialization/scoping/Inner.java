package ocjp.declarations.initialization.scoping;

class Inner {
	public static void main(String[] args) {
		Inner inner = new Inner();
		inner.new Outer().innerMethod();
	}
	final int num = 2399;
	class Outer{
		int num = 9932;
		void innerMethod(){
//			System.out.println("----------");
			//deve imprimir 2399
			System.err.println(Inner.this.num);
//			System.err.println(super.num);
		}
	}
}
