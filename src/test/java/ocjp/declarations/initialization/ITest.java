package ocjp.declarations.initialization;

class ITest implements MyInterface{

	@Override
	long add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	public static void main(String[] args) {
		ITest ob = new ITest();
		System.out.println(ob.add(10, 10));
	}
}

interface MyInterface{
	long add(int a, int b);
}
