package generalStore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class implements the tests for the Item class in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
class ItemTests {

	private Tractor testTractor;
	private Shovel testShovel;
	private AnimalFeed testAnimalFeed;
	private AnimalTreat testAnimalTreat;
	private ProfitFertiliser testProfitFertiliser;
	private GrowthFertiliser testGrowthFertiliser;
	
	@BeforeEach
	public void init() {
		testTractor = new Tractor();
		testShovel = new Shovel();
		testAnimalFeed = new AnimalFeed();
		testAnimalTreat = new AnimalTreat();
		testProfitFertiliser = new ProfitFertiliser();
		testGrowthFertiliser = new GrowthFertiliser();
	}

	//----------------------------------------------- toString() Tests ---------------------------------------------------
	
//	@Test
//	/**
//	 * This test tests that each Item is displayed properly.
//	 */
//	public void toStringTest() {
//		assertEquals("tractor", testTractor.toString());
//		assertEquals("animal feed", testAnimalFeed.toString());
//		assertEquals("animal treat", testAnimalTreat.toString());
//		assertEquals("growth fertiliser", testGrowthFertiliser.toString());
//		assertEquals("profit fertiliser", testProfitFertiliser.toString());
//		assertEquals("shovel", testShovel.toString());
//	}
	
}
