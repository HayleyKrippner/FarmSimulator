package animals;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class implements the tests for the Animal class in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
class AnimalTests {
	
	private Animal testAnimal;
	
	@BeforeEach
	public void init() {
		testAnimal = new Animal("Cow", 20);
	}
	
	//----------------------------------------------- reduceAnimalHappiness() Tests ---------------------------------------------------

	@Test
	/**
	 * This test tests that the Animals' happiness gets reduced by 10 units, when it currently has max happiness.
	 */
	public void reduceAnimalHappinessMaxHappinessTest() {
		testAnimal.reduceAnimalHappiness();
		assertEquals(90, testAnimal.getHappiness());
	}
	
	@Test
	/**
	 * This test tests that the Animals' happiness gets reduced by 10 units, when it currently has 50 units happiness.
	 */
	public void reduceAnimalHappinessMidHappinessTest() {
		testAnimal.setHappiness(50);
		testAnimal.reduceAnimalHappiness();
		assertEquals(40, testAnimal.getHappiness());
	}

	
	//----------------------------------------------- reduceAnimalHealth() Tests ---------------------------------------------------
	
	@Test
	/**
	 * This test tests that the Animals' health gets reduced by 10 units, when it currently has max health.
	 */
	public void reduceAnimalHealthMaxHealthTest() {
		testAnimal.reduceAnimalHealth();
		assertEquals(90, testAnimal.getHealth());
	}
	
	@Test
	/**
	 * This test tests that the Animals' health gets reduced by 10 units, when it currently has 50 units health.
	 */
	public void reduceAnimalHealthMidHealthTest() {
		testAnimal.setHealth(50);
		testAnimal.reduceAnimalHealth();
		assertEquals(40, testAnimal.getHealth());
	}
	
	/**
	 * This test tests that the Animals' health does not get reduced by 10 units, when it currently has 0 units health.
	 */
	public void reduceAnimalHealthMinHealthTest() {
		testAnimal.setHealth(0);
		testAnimal.reduceAnimalHealth();
		assertEquals(0, testAnimal.getHealth());
	} 

	//----------------------------------------------- feed() Tests ---------------------------------------------------
	
	@Test
	/**
	 * This test tests that you cannot feed an Animal if its health is already at the maximum level of 100 
	 */
	public void maxHealthFeedTest() {
		testAnimal.feed();
		assertEquals(100, testAnimal.getHealth());
	}
	
	@Test
	/**
	 * This test tests that you can feed an Animal if its health is at 50 units.
	 */
	public void midHealthFeedTest() {
		testAnimal.setHealth(50);
		testAnimal.feed();
		assertEquals(70, testAnimal.getHealth());
	}
	
	@Test
	/**
	 * This test tests that you can feed an Animal if its health is at 0 units.
	 */
	public void minHealthFeedTest() {
		testAnimal.setHealth(0);
		testAnimal.feed();
		assertEquals(20, testAnimal.getHealth());
	}

	
	//----------------------------------------------- play() Tests ---------------------------------------------------

	
	@Test
	/**
	 * This test tests that you cannot play with an Animal if its happiness is already at the maximum level of 100
	 */
	public void maxHappinessPlayTest() {
		testAnimal.play();
		assertEquals(100, testAnimal.getHappiness());
	}
	
	@Test
	/**
	 * This test tests that you can feed an Animal if its health is at 50 units.
	 */
	public void midHappinessPlayTest() {
		testAnimal.setHappiness(50);
		testAnimal.play();
		assertEquals(60, testAnimal.getHappiness());
	}
	
	@Test
	/**
	 * This test tests that you can feed an Animal if its health is at 0 units.
	 */
	public void minHappinessPlayTest() {
		testAnimal.setHappiness(0);
		testAnimal.play();
		assertEquals(10, testAnimal.getHappiness());
	}

}
