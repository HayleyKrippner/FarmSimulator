package crops;

/**
 * This class implements the methods for a Crop in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Crop{
	
	/**
	 * The type of Crop.
	 */
	private String farmObjectType;
	/**
	 * The time until the Crop can be harvested.
	 */
	private int timeUntilHarvest;
	/**
	 * The total growing time of the Crop.
	 */
	private int totalGrowingTime;
	/**
	 * The water level of the Crop.
	 */
	private int waterLevel;
	/**
	 * The purchase price of the Crop in dollars.
	 */
	private int purchasePrice;
	/**
	 * The price the fully grown Crop sells for in dollars.
	 */
	private double sellingPrice;
	
	/**
	 * This creates a crop constructor.
	 */
	public Crop() {
	}
	
	/**
	 * This method creates a Crop.
	 * The Crop's water level is set to the maximum level of 100.
	 * The Crop's time until harvest is set to the total growing time.
	 * @param farmObjectType This is the type of Crop.
	 * @param sellingPrice This is the price the fully grown Crop sells for in dollars.
	 * @param purchasePrice This is the price the fully grown Crop sells for in dollars.
	 * @param totalGrowingTime This is the total growing time of the Crop.
	 */
	public Crop (String farmObjectType, float sellingPrice, int purchasePrice, int totalGrowingTime) {
		this.farmObjectType = farmObjectType;
		this.sellingPrice = sellingPrice;
		this.purchasePrice = purchasePrice;
		this.timeUntilHarvest = totalGrowingTime;
		this.totalGrowingTime = totalGrowingTime;
		this.waterLevel = 100;
	}
	
	public double getSellingPrice() {
		return sellingPrice;
	}
	
	public void setSellingPrice(double newSellingPrice) {
		sellingPrice = newSellingPrice;
	}
	
	public int getPurchasePrice() {
		return purchasePrice;
	}
	
	public int getTimeUntilHarvest() {
		return timeUntilHarvest;
	}
	
	public void setTimeUntilHarvest(int newTimeUntilHarvest) {
		timeUntilHarvest = newTimeUntilHarvest;
	}
	
	public int getTotalGrowingTime() {
		return totalGrowingTime;
	}
	
	public int getWaterLevel() {
		return waterLevel;
	}
	
	/**
	 * This method displays the type of Crop.
	 * @return farmObjectType The type of Crop.
	 */
	public String toString() {
		return this.farmObjectType;
	}
	
	/**
	 * This method gets the length of the type of Crop.
	 * @return int The length of the type of Crop.
	 */
	public int getLength() {
		return toString().length();
	}

	/**
	 * This method reduces the water level of the Crop by 10 units, ensuring that the minimum water level of 0 is not breached.
	 */
	public void reduceWaterLevel() {
		if (waterLevel - 10 < 0) {
			waterLevel = 0;
		} else {
			waterLevel -= 10;
		}
	}
	
	/**
	 * This method reduces the Crop's harvest time by 1 day, provided that it
	 * is not already ready to harvest.
	 */
	public void reduceTimeUntilHarvest() {
		if (timeUntilHarvest > 0) {
			timeUntilHarvest -= 1; 
		} 
	}
	
	/**
	 * This method hydrates the Crop by increasing its water level by 10 units, provided that
	 * it is not already at its maximum water level.
	 */
	public void hydrate() {
		if (waterLevel == 100) {
			System.out.println("Crop has enough water");
		} else {
			waterLevel += 10;
			System.out.println("Crop has been watered");
		}	
	}

}
