package farm;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * This class implements the tests for the Farmer class in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
class FarmerTests {

	private Farmer testFarmer1;
	private Farmer testFarmer2;
	private Farmer testFarmer3;
	private Farmer testFarmer4;
	
	@BeforeEach
	public void init() {
		testFarmer1 = new Farmer("Gregory", 37);
		testFarmer2 = new Farmer("Bethany", 10);
		testFarmer3 = new Farmer("Zack", 0);
		testFarmer4 = new Farmer("Mary", 99);

	}
	
	//----------------------------------------------- toString() Tests ---------------------------------------------------
	
	@Test
	/**
	 * This test tests that the Farmer's name and age are displayed properly.
	 */
	public void toStringTest() {
		assertEquals("Farmer Name: Gregory, Farmer Age: 37", testFarmer1.toString());
		assertEquals("Farmer Name: Bethany, Farmer Age: 10", testFarmer2.toString());
		assertEquals("Farmer Name: Zack, Farmer Age: 0", testFarmer3.toString());
		assertEquals("Farmer Name: Mary, Farmer Age: 99", testFarmer4.toString());

	}
	
}
