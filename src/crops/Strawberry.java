package crops;

/**
 * This class extends from the Crop class and creates a Strawberry bush in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Strawberry extends Crop {
	
	/**
	 * This method creates a Strawberry bush.
	 * A Strawberry bush gives a profit of $40, has a purchasing price of $10 and takes 1 days to grow.
	 */
	public Strawberry() {
		super("strawberry bush", 40, 10, 1);
	}

}
