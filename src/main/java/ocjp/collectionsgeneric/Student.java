package ocjp.collectionsgeneric;

public class Student {

	public static void main(String[] args) {
		Integer a = 145;
		Object num1 = new String("145");
		Object num2 = a;
		a = null;
		Object result = num2.toString();
		System.out.println(num1.equals(result));
	}
	
}
