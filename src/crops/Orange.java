package crops;

/**
 * This class extends from the Crop class and creates a Orange tree in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Orange extends Crop {

	/**
	 * This method creates an Orange tree.
	 * A Orange tree gives a profit of $170, has a purchasing price of $30 and takes 2 days to grow.
	 */
	public Orange() {
		super("orange tree", 170, 30, 2);
	}

}