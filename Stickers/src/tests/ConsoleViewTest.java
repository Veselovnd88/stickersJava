package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import view.ConsoleView;

public class ConsoleViewTest {
	private ConsoleView cv = new ConsoleView();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	InputStream backUp = System.in;
	
	
	
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testYesOrNo() {
		String yes = "y";
		String no = "n";
		ByteArrayInputStream bis = new ByteArrayInputStream(yes.getBytes());
		
		assertEquals(true,cv.YesOrNo());
		System.setIn(bis);
		bis = new ByteArrayInputStream(no.getBytes());
		
		assertEquals(false, cv.YesOrNo());
		System.setIn(bis);
	}

	@Test
	public void testReadOp() {
		
	}

	@Test
	public void testReadArt() {
		
	}

	@Test
	public void testReadPos() {
		
	}

	@Test
	public void testReadSerial() {
	
	}

	@Test
	public void testAskOperation() {
		
	}

}
