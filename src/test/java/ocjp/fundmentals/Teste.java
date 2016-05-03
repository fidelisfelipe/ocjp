package ocjp.fundmentals;
/**
 * @author Fidelis
 * Qnts objetos são eleitos pelo gc após a execução de f()?
 */
class X{
	void print(){}
}
public class Teste {
	private static void f(){}

	public static void main(String[] args){
		
		X a = new X();
		X b = new X();
		X c = new X();
		
		a = b;
		b = c;
		
		f();
		
	}

}

