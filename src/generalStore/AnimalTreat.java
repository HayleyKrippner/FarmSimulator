package generalStore;

/**
 * This class implements all the methods for AnimalTreat in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class AnimalTreat extends Item {
	
	/**
	 * This method creates an AnimalTreat which has a purchasing price of $10 and increases animal's happiness by 20 points.
	 * It can only be used on an Animal.
	 */
	public AnimalTreat() {
		super("animal treat", 10, "Increases the animal happiness by 20 points.");
	}

}