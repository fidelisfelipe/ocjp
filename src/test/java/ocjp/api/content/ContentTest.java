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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.junit.Test;

public class ContentTest {
	Number Float = 99.455f;
	
	@Test
	public void testWrited() throws Exception {
		Writer w = new BufferedWriter(new FileWriter("OPA"));
	}
	
	@Test
	public void testPattern() throws Exception {
		Pattern p = Pattern.compile("Java Tiger Great");
		Matcher m = p.matcher("great");
		boolean find = false;
		
		if(m.find())
			find = true;
		assertFalse(find);	
	}
	
	@Test
	public void testStringBuffer() throws Exception {
		String string = new String("java");
		StringBuffer sb = new StringBuffer("java");
		
		assertFalse(string.equals(sb));
		assertTrue(string.equals(sb.toString()));
	}
	@Test
	public void testStringBuffer2() throws Exception {
		String string = new String("java");
		StringBuffer sb = new StringBuffer("java");
		
		assertTrue(sb.toString().equals(string));
	}

	@Test
	public void test(){
		Scanner scanner = new Scanner(System.in);
	}

	@Test
	public void testPattner() throws Exception {
		String regex = "\\d";
		String input = "Java1is2object3oriented4language";
		Pattern p = Pattern.compile(regex);
		String[] items = p.split(input);
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}
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
	
	@Test
	public void testConceptStringBuilderBuffer() throws Exception {
		
//		StringBuilder
//*		z = 'start';
//*		z.append("le"); startle
//*		z.insert(4,"le"); starlet
//*		A mutable sequence of characters. 
//*		This class provides an API compatible with StringBuffer, but with no guarantee of synchronization. 
//		This class is designed for use as a drop-in replacement for StringBuffer in places where the string buffer was being used by a single thread (as is generally the case). 
//*		Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations. 
//		The principal operations on a StringBuilder are the append and insert methods, which are overloaded so as to accept data of any type. 
//		Each effectively converts a given datum to a string and then appends or inserts the characters of that string to the string builder. 
//*		The append method always adds these characters at the end of the builder; 
//*		the insert method adds the characters at a specified point. 
//		For example, if z refers to a string builder object whose current contents are "start", 
//*		then the method call z.append("le") would cause the string builder to contain "startle", 
//*		whereas z.insert(4, "le") would alter the string builder to contain "starlet". 
//		In general, if sb refers to an instance of a StringBuilder, then sb.append(x) has the same effect as sb.insert(sb.length(), x). 
//		Every string builder has a capacity. 
//		As long as the length of the character sequence contained in the string builder does not exceed the capacity, 
//		it is not necessary to allocate a new internal buffer. If the internal buffer overflows, it is automatically made larger. 
//*		Instances of StringBuilder are not safe for use by multiple threads. 
//*		If such synchronization is required then it is recommended that java.lang.StringBuffer be used. 

//		StringBuffer
//*		A thread-safe, mutable sequence of characters. 
//*		A string buffer is like a String, but can be modified. 
//		At any point in time it contains some particular sequence of characters, 
//		but the length and content of the sequence can be changed through certain method calls. 
//*		String buffers are safe for use by multiple threads. 
//*		The methods are synchronized where necessary so that all the operations on any particular instance behave as if they occur in some serial 
//		order that is consistent with the order of the method calls made by each of the individual threads involved. 
//		The principal operations on a StringBuffer are the append and insert methods, which are overloaded so as to accept data of any type. 
//		Each effectively converts a given datum to a string and then appends or inserts the characters of that string to the string buffer. 
//		The append method always adds these characters at the end of the buffer; the insert method adds the characters at a specified point. 
//		For example, if z refers to a string buffer object whose current contents are "start", then the method call z.append("le") would cause the string buffer to contain "startle", 
//		whereas z.insert(4, "le") would alter the string buffer to contain "starlet". 
//		In general, if sb refers to an instance of a StringBuffer, then sb.append(x) has the same effect as sb.insert(sb.length(), x). 
//		Whenever an operation occurs involving a source sequence (such as appending or inserting from a source sequence)
//*		this class synchronizes only on the string buffer performing the operation, not on the source. 
//		Every string buffer has a capacity. As long as the length of the character sequence contained in the string buffer does not exceed the capacity,
//*		it is not necessary to allocate a new internal buffer array. If the internal buffer overflows, it is automatically made larger. 
//*		As of release JDK 5, this class has been supplemented with an equivalent class designed for use by a single thread, StringBuilder. 
//*		The StringBuilder class should generally be used in preference to this one, as it supports all of the same operations but it is faster, as it performs no synchronization.
		
	}
}

