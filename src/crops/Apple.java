package crops;

/**
 * This class extends from the Crop class and creates an Apple tree in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Apple extends Crop {

	/**
	 * This method creates an Apple tree.
	 * An Apple tree gives a profit of $80, has a purchasing price of $20 and takes 2 days to grow.
	 */
	public Apple() {
		super("apple tree", 80, 20, 2);
	}

}
