package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import view.ConsoleView;

public class ConsoleViewTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	//TODO замена инпут стримов для позвовывания в консоль вью
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testYesOrNo() {
		assertEquals(true,new ConsoleView().YesOrNo());
	}

	@Test
	public void testReadOp() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testReadArt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testReadPos() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testReadSerial() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAskOperation() {
		fail("Not yet implemented"); // TODO
	}

}
