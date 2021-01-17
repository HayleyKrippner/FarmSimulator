package generalStore;

/**
 * This class implements all the methods for GrowthFertiliser in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class GrowthFertiliser extends Item {
	
	/**
	 * This method creates a GrowthFertiliser which has a purchasing price of $20 and reduces the crop growing time by 1 day.
	 * It can only be used on a Crop.
	 */
	public GrowthFertiliser() {
		super("growth fertiliser", 20, "Reduces the crop growing time by 1 day.");
	}

}