package ocjp.api.content;

import java.util.Locale;
import java.util.Scanner;

import org.junit.Test;

public class ContentTest {

	@Test
	public void test(){
		Scanner scanner = new Scanner(System.in);
	}
	
	@Test
	public void testLocale(){
		Locale[] locales = Locale.getAvailableLocales();
		System.out.println(locales.toString());
	}
	
}
