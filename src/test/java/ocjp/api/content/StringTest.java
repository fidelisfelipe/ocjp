package ocjp.api.content;

import static org.junit.Assert.*;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.junit.Test;

public class StringTest {

	@Test
	public void test() throws Exception {
		String string = new String();
		String regex = "";
		string.split(regex );
//		string.concat(str);
//		string.charAt(index);
//		string.codePointAt(index);
//		string.codePointBefore(index);
//		string.codePointCount(beginIndex, endIndex);
//		string.compareTo(anotherString);
//		string.contains(s);
//		string.contentEquals(cs);
//		string.contentEquals(sb);
		string.matches(regex);
//		string.length();
		//methods contains in String and Pattner class
		//
		Pattern pattner = Pattern.compile("");
		CharSequence input = "C";
		pattner.matcher(input );
		pattner.split(input);
		Pattern.matches(regex, input);
		
	}
	
}
