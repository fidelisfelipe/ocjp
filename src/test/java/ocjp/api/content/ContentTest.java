package ocjp.api.content;

import static org.junit.Assert.*;

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
	
	@Test
	public void testLocalo2() throws Exception {
		Locale locale = Locale.JAPAN;
		//language lowercase two-letter ISO-639 code.
		//country uppercase two-letter ISO-3166 code.

		Locale locale1 = new Locale("ja", "JP");
		
		assertEquals(locale, locale1);
	}
	
}
