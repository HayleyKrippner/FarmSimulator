package generalStore;

/**
 * This class implements all the methods for the shovel in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Shovel extends Item {
	
	/**
	 * This method creates a Shovel which has a purchasing price of $20 and allows for selected crop to be instantly harvested.
	 * It can only be used on a Crop.
	 */
	public Shovel() {
		super("shovel", 20, "Allows the selected crop to be instantly harvested.");
	}

}
