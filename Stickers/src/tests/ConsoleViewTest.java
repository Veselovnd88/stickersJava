package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import command.Operation;
import view.ConsoleView;

public class ConsoleViewTest {

	
	private static InputStream STDIN = System.in;
	private static ByteArrayInputStream bis;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testYesOrNo() {
		String testingString ="y\nfail\nfail\nn";//
		bis = new ByteArrayInputStream(testingString.getBytes());
		System.setIn(bis);
		ConsoleView cv = new ConsoleView();
		assertEquals(true,cv.YesOrNo());
		assertEquals(false,cv.YesOrNo());
	}
	
	@Test
	public void testReadArt() {
		String testingString = "\n1\n2\n3\n4\nfail\0\n5\n1";
		bis = new ByteArrayInputStream(testingString.getBytes());
		System.setIn(bis);
		ConsoleView cv = new ConsoleView();
		assertEquals((Integer)1,cv.readArt());
		assertEquals((Integer)2,cv.readArt());
		assertEquals((Integer)3,cv.readArt());
		assertEquals((Integer)4,cv.readArt());
		assertEquals((Integer)1,cv.readArt());
	}
	
	
/*	
	@Test
	public void testReadOp() {
		String testingString = "\n1\n2\n3\n4\nfail\0\n5\n1";
		bis = new ByteArrayInputStream(testingString.getBytes());
		System.setIn(bis);
		ConsoleView cv = new ConsoleView();
		assertEquals((Integer)1,cv.readOp());
		assertEquals((Integer)2,cv.readOp());
		assertEquals((Integer)3,cv.readOp());
		assertEquals((Integer)4,cv.readOp());
		assertEquals((Integer)1,cv.readOp());
	}



	@Test
	public void testReadPos() {
		String testingString = "\n1\n2\n3\n4\nfail\0\n5\n1\n12\n11\n10\n9\n8\n7\n6\n5\n19\nfail\n1";
		bis = new ByteArrayInputStream(testingString.getBytes());
		System.setIn(bis);
		ConsoleView cv = new ConsoleView();
		assertEquals((Integer)1,cv.readPos());
		assertEquals((Integer)2,cv.readPos());
		assertEquals((Integer)3,cv.readPos());
		assertEquals((Integer)4,cv.readPos());
		assertEquals((Integer)5,cv.readPos());
		assertEquals((Integer)1,cv.readPos());
		assertEquals((Integer)12,cv.readPos());
		assertEquals((Integer)11,cv.readPos());
		assertEquals((Integer)10,cv.readPos());
		assertEquals((Integer)9,cv.readPos());
		assertEquals((Integer)8,cv.readPos());
		assertEquals((Integer)7,cv.readPos());
		assertEquals((Integer)6,cv.readPos());
		assertEquals((Integer)5,cv.readPos());
		assertEquals((Integer)1,cv.readPos());
	}
*/
	@Test
	public void testReadSerial() {
		String testingString = "123\n321\n\n567\nHello\nfail\n";
		bis = new ByteArrayInputStream(testingString.getBytes());
		System.setIn(bis);
		ConsoleView cv = new ConsoleView();
		assertEquals("123",cv.readSerial());
		assertEquals("321",cv.readSerial());
		assertEquals("567",cv.readSerial());
		assertEquals("Hello",cv.readSerial());
		assertEquals("fail",cv.readSerial());
	}



}
