package java.lang;

public class MyObject extends java.lang.Object{
	String name = "nome";
	@Override
	protected void finalize() throws Throwable {
		name = null;
	}
	public static void main(String[] args) throws Throwable {
		Object object = new MyObject();
		object.finalize();
		System.out.println(object);
	}
}
