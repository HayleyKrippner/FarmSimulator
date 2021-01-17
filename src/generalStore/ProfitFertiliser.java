package generalStore;

/**
 * This class implements all the methods for ProfitFertiliser in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class ProfitFertiliser extends Item {

	/**
	 * This method creates a ProfitFertiliser which has a purchasing price of $15 and increases crop profit by 20%.
	 * It can only be used on a Crop.
	 */
	public ProfitFertiliser() {
		super("profit fertiliser", 15, "Increases crop profit by 20%.");
	}

}