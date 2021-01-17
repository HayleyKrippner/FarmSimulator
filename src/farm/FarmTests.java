package farm;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import animals.Animal;
import commandLineApp.FarmObject;

import org.junit.jupiter.api.BeforeEach;

/**
 * This class implements the tests for the Farm class in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
class FarmTests {

	private Farm testFarm1;
	private Farm testFarm2;
	private Farm testFarm3;
	private Farm testFarm4;
	
	@BeforeEach
	public void init() {
		testFarm1 = new Farm();
//		testFarm2 = new Farm("Bethany's Farm", 5, 2, 200.00, 2.00, false, 1.00);
//		testFarm3 = new Farm("Zack's Fun Farm", 8, 3, 200.00, 1.00, true, 1.00);
//		testFarm4 = new Farm("My Farm", 10, 4, 200.00, 1.00, false, 0.80);
		new ArrayList<Animal>();
		new ArrayList<FarmObject>();
	}

	
	//----------------------------------------------- reduceNumofActions() Tests ---------------------------------------------------
	
	@Test
	/**
	 * This test tests that the number of daily actions gets reduced by 1 when there are max number of 2 actions.
	 */
	public void maxReduceNumofActionsTest() {
		testFarm1.setNumOfActions(2);
		testFarm1.reduceNumofActions();
		assertEquals(1, testFarm1.getNumOfActions());
	}
	
	//----------------------------------------------- reduceNumofActions() Tests ---------------------------------------------------

	@Test
	/**
	 * This test tests that the number of daily actions does not get reduced by 1 when there are min number of 0 actions.
	 */
	public void resetNumOfActionsTest() {
		testFarm1.setNumOfActions(0);
		testFarm1.resetNumOfActions();
		assertEquals(2, testFarm1.getNumOfActions());
	}
	
	//----------------------------------------------- updateCurrentDay() Tests ---------------------------------------------------
	
	@Test
	/**
	 * This test tests that the current day does get increased by 1 when there are min number of 1 days.
	 */
	public void minUpdateCurrentDayTest() {
		testFarm1.setCurrentDay(1);
		testFarm1.updateCurrentDay();
		assertEquals(2, testFarm1.getCurrentDay());
	}
	
	@Test
	/**
	 * This test tests that the current day does get increased by 1 when there are number of 7 days.
	 */
	public void midUpdateCurrentDayTest() {
		testFarm1.setCurrentDay(7);
		testFarm1.updateCurrentDay();
		assertEquals(8, testFarm1.getCurrentDay());
	}
	
}