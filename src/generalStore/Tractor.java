package generalStore;

/**
 * This class implements all the methods for the tractor in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Tractor extends Item {
	
	/**
	 * This method creates a Tractor which has a purchasing price of $10 and cleans a plot of land completely.
	 * It can only be used on a LandPlot.
	 */
	public Tractor() {
		super("tractor", 100, "Cleans a plot of land completely.");
	}
}
