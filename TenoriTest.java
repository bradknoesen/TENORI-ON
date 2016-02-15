import javax.swing.*;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import TenoriOn.Tenori.*;
import static org.junit.Assert.*;

/**
 * 
 * @author David Olagunju
 * @author Presley Kode
 *
 */
public class TenoriTest {
	public Tenori GUI;
	
	
	@Before
	public void setUp() throws Exception {
		GUI = new Tenori();
	}

	@After
	public void tearDown() throws Exception {
		GUI = null;
	}
	
	/*
	 * Test of populate method, of class Tenori
	 */
	@Test
	public void testPopulate() {
		System.out.println("Populate");
		GUI.populate();
		//the name of the sound buttons in the matrix should follow the format btn_row_column
		assertEquals("The name of the sound be btn_row_column where matrix[row][column]", "btn_0_0", GUI.matrix[0][0].name);
		assertEquals("The name of the sound be btn_row_column where matrix[row][column]", "btn_15_15", GUI.matrix[15][15].name);
	}

	/*
	 * Test of clear method, of class Tenori
	 */
	@Test
	public void testClear() {
		System.out.println("Clear");		
		//the name of the image for sound when selected should be different before and after selection
		GUI.populate();
		assertFalse("The name of the images should be different", GUI.matrix[0][0].getIcon() == GUI.matrix[0][0].getSelectedIcon());
	}

	/*
	 * Test of L1 method, of class Tenori
	 */
	@Test
	public void testL1() {
		System.out.println("L1");		
		//A button should not be null if it has been created
		ModeButton L1 =  GUI.btn_L1;
		assertFalse("If the L1 button has been created it should not be null", L1 == null);

	}
	
}
