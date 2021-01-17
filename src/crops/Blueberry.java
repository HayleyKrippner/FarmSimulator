package crops;

/**
 * This class extends from the Crop class and creates a Blueberry bush in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Blueberry extends Crop {

	/**
	 * This method creates a Blueberry bush.
	 * A Blueberry bush gives a profit of $100, has a purchasing price of $10 and takes 3 days to grow.
	 */
	public Blueberry() {
		super("blueberry bush", 100, 10, 3);
	}

}
