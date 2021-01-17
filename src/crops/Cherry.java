package crops;

/**
 * This class extends from the Crop class and creates a Cherry tree in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Cherry extends Crop{

	/**
	 * This method creates a Cherry tree.
	 * A Cherry tree gives a profit of $200, has a purchasing price of $20 and takes 3 days to grow.
	 */
	public Cherry() {
		super("cherry tree", 200, 20, 3);
	}

}

