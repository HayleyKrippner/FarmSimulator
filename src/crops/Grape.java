package crops;

/**
 * This class extends from the Crop class and creates a Grape vine in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Grape extends Crop {

	/**
	 * This method creates a Grape vine.
	 * A Grape vine gives a profit of $70, has a purchasing price of $30 and takes 1 days to grow.
	 */
	public Grape() {
		super("grape vine", 70, 30, 1);
	}

}
