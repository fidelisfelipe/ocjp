package ocjp.io;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import org.junit.Test;

public class FileTest {

	@Test
	public void testPathEmpty(){
		String pathnameEmpty = "";
		File file = new File(pathnameEmpty);
		assertTrue("se o pathname for vazio, não lança exception ",file.getPath() == pathnameEmpty);
	}
	
	@Test
	public void testFile() throws Exception {
		Writer w = new BufferedWriter(new FileWriter("teste.txt"));
	}
	
}
