package ocjp.declarations.initialization;

class Parent {
	void aMethod(String string){}
}

class Child extends Parent{
//	protected void aMethod(String a) throws IndexOutOfBoundsException{}
//	private void aMethod(String a){} não pode ter a mesma assinatura com modificador mais restritvo
	void aMethod(int a){}//não é sobrescrita, é um novo metodo
//	String aMethod(String a){}//retorno é diferente do pai
	
}
