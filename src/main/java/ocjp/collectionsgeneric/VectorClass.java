package ocjp.collectionsgeneric;

import java.util.*;

public class VectorClass {
	
	public static void main(String[] args) {
		Vector<String> strings = new Vector<String>();
		Vector<Integer> integes = new Vector<Integer>();
		Vector<Object> objects = new Vector<Object>();
		System.out.println(strings.getClass().toString());
		System.out.println(strings.getClass() == integes.getClass());
		System.out.println(strings.getClass().equals(integes.getClass()));
		System.out.println(strings.getClass() == objects.getClass());
		System.out.println(strings.getClass().equals(objects.getClass()));
	}
}
