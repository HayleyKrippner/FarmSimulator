package crops;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class implements the tests for the Crop class in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
class CropTests {
	
	private Crop testCrop;
	
	@BeforeEach
	public void init() {
		testCrop = new Crop("Apple", 20, 10, 2);
	}
	
	//----------------------------------------------- toString() Tests ---------------------------------------------------

	@Test
	/**
	 * This test tests that the Crop's type is displayed properly.
	 */
	public void toStringTest() {
		assertEquals("Apple", testCrop.toString());
	}
	
	
	//----------------------------------------------- hydrate() Tests ---------------------------------------------------	
	
	@Test
	/**
	 * This test tests that the Crop's water level does not get increased by 10 units, when currently has max water.
	 */
	public void maxWaterHydrateTest() {
		testCrop.hydrate();
		assertEquals(100, testCrop.getWaterLevel());
	}
	
	
	//----------------------------------------------- reduceTimeUntilHarvest() Tests ---------------------------------------------------

	@Test
	/**
	 * This test tests that the Crop's time until harvest does not get decreased by 1 units, when currently ready to harvest .
	 */
	public void harvestableReduceTimeUntilHarvestTest() {
		testCrop.setTimeUntilHarvest(0);
		testCrop.reduceTimeUntilHarvest();
		assertEquals(0, testCrop.getTimeUntilHarvest());
	}
	
	@Test
	/**
	 * This test tests that the Crop's time until harvest does get decreased by 1 units, when 1 unit off time being ready to harvest .
	 */
	public void almostHarvestableReduceTimeUntilHarvestTest() {
		testCrop.setTimeUntilHarvest(1);
		testCrop.reduceTimeUntilHarvest();
		assertEquals(0, testCrop.getTimeUntilHarvest());
	}
	
	@Test
	/**
	 * This test tests that the Crop's time until harvest does get decreased by 1 units, when 3 units off time being ready to harvest .
	 */
	public void notHarvestableReduceTimeUntilHarvestTest() {
		testCrop.setTimeUntilHarvest(3);
		testCrop.reduceTimeUntilHarvest();
		assertEquals(2, testCrop.getTimeUntilHarvest());
	}

	@Test
	public void reduceTimeUntilHarvestTest() {
		testCrop.reduceTimeUntilHarvest();
		assertEquals(1, testCrop.getTimeUntilHarvest());
	}
	
	//----------------------------------------------- reduceWaterLevel() Tests ---------------------------------------------------
	
	@Test
	/**
	 * This test tests that the Crop's water level does get decreased by 1 units, when it has 100 water level .
	 */
	public void maxReduceWaterLevelTest() {
		testCrop.reduceWaterLevel();
		assertEquals(90, testCrop.getWaterLevel());
	}

}
