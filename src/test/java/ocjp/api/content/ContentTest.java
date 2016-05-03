<<<<<<< HEAD
package ocjp.api.content;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;

import org.junit.Test;

public class ContentTest {

	@Test
	public void test(){
		Scanner scanner = new Scanner(System.in);
	}
	
	@Test
	public void testDateShow12hrs() throws Exception {
		Formatter f = new Formatter();
		Calendar c = Calendar.getInstance();
		f.format("%tr %tZ", c, c);//04:18:38 PM BRT
		System.out.println(f.toString());
		
		f.format("%tF %tZ", c, c);//04:20:40 PM BRT2016-05-03 BRT
		System.out.println(f.toString());
		
		f.format("%tC %tZ", c, c);//04:20:40 PM BRT2016-05-03 BRT20 BRT
		System.out.println(f.toString());
		
		f.format("%tD %tZ", c, c);//04:20:40 PM BRT2016-05-03 BRT20 BRT05/03/16 BRT
		System.out.println(f.toString());
		
		f.close();//good practice
	}
	
	@Test
	public void testLocale(){
		Locale[] locales = Locale.getAvailableLocales();
		System.out.println(locales.toString());
		
		Locale japan = Locale.JAPAN;
		Locale jp = new Locale("ja","JP");
		assertTrue(jp.getLanguage() == "ja");
		assertTrue(jp.getLanguage() == japan.getLanguage());
		
	}
	
	@Test
	public void testLocalo2() throws Exception {
		Locale locale = Locale.JAPAN;
		//language lowercase two-letter ISO-639 code.
		//country uppercase two-letter ISO-3166 code.

		Locale locale1 = new Locale("ja", "JP");
		
		assertEquals(locale, locale1);
	}
	
	@Test
	public void testFileWriteAndBufferedWriter() throws IOException{
		Writer w = new BufferedWriter(new FileWriter("File.txt"));
	}
	//TODO: se liga nessa pegadinha
	@Test
	public void testFileRename(){
		File dir = new File("dir");
		try{
		dir.mkdir();
		File f = new File(dir,"f");
		f.createNewFile();
		}catch(Exception e){;}
		File newDir = new File("newDir");
		dir.renameTo(newDir);
	}
	
	@Test
	public void testGetClassAndEquals() throws Exception {
		Vector<String> strings = new Vector<String>();
		Vector<Integer> integers = new Vector<Integer>();
		Vector<Object> objects = new Vector<Object>();
		assertTrue("é um Vector", strings.getClass() == Vector.class);
		
		assertTrue("são vetores", strings.getClass() == integers.getClass());
		
		assertTrue("ambos são vetores de 10 posições", strings.equals(integers));
		
		assertTrue("são vetores", strings.getClass() == objects.getClass());
		
		assertTrue("ambos são vetores de 10 posições", strings.equals(objects));
		
	}
	
	/**
	 * Sobrescrita de metodo que lança exception
	 * O metodo que sobrescreve deve...
	 * Sobre Exceptions:
	 * lançar exception filha
	 * lançar a mesma exception
	 * lançar uma exception não verificada
	 * 
	 * Sobre modificadores e retornos:
	 * ser mais restritivo
	 * ter os mesmos argumentos
	 * ter o mesmo retorno
	 * 
	 */
	@Test
	public void testMethodExceptionOverrides(){
		class A{
			void aMethod() {}
		}
		class B extends A{
			protected void aMethod () throws IndexOutOfBoundsException{}
		}
	}
	
	@Test(expected = PatternSyntaxException.class)
	public void testRegexSplit() {
		String string = "Java*JSP";
		System.out.println(string.split("*", -2));
	}
	
	@Test
	public void testBooleanUnCaseSensitive() throws Exception {
		Boolean a = new Boolean("TrUe");
		Boolean b = true;
		Boolean c = a && b;
		assertTrue(c);
	}
	
	@Test
	public void testScopes(){
		class A{
			String accountNumber = "";
			void aMethod() {}
		}
		class B extends A{
			protected void aMethod () throws IndexOutOfBoundsException{}
		}
		
		
	}
	
	@Test
	public void testFile(){
		String name = "a.txt";
		try{
			
			Scanner scanner = new Scanner(new File(name));
			scanner.useDelimiter("\n");
			while(scanner.hasNext()){
				System.out.println(scanner.next());
			}
			scanner.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPrintWriteMethods() throws Exception {
		File file = new File("PrintFile.txt");
		file.createNewFile();
		Writer out = new FileWriter(file);
		PrintWriter print = new PrintWriter(out);
		print.printf("%d", 1);
		print.println();
		print.printf("%d", 2);
		print.flush();
		print.close();
	}
	
	@Test
	public void testBufferedReader() throws Exception {
		Reader file = new FileReader("File.txt");
//		Reader outroFile = new Reader("File.txt");//não se cria instancia de class abstract
		Reader in = new BufferedReader(file);
//		Reader in2 = new BufferedReader(new Reader(file));
	}
	
	
}
=======
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
>>>>>>> fed9ffc4680653b996d711858a35673039b897e7
