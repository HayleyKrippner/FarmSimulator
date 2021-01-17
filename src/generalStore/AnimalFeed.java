package generalStore;

/**
 * This class implements all the methods for AnimalFeed in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class AnimalFeed extends Item {
	
	/**
	 * This method creates an AnimalFeed which has a purchasing price of $20 and increases animal's health by 20 points.
	 * It can only be used on an Animal.
	 */
	public AnimalFeed() {
		super("animal feed", 20, "Increases animal's health by 20 points.");
	}
}