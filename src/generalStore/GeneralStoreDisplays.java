package generalStore;

import main.GameManager;
import main.PreGame;

/**
 * This class implements all the methods for the GeneralStoreDisplays in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class GeneralStoreDisplays {
	
	/**
	 * The GameManager in farm simulator.
	 */
	private GameManager gameManager;
	/**
	 * The PreGame in farm simulator.
	 */
	private PreGame preGame;
	/**
	 * The array that displays crops available to purchase.
	 */
	String[] generalStoreCropArray = {"Apple","Blueberry", "Cherry", "Grape", "Orange", "Strawberry"};
	/**
	 * The array that displays animals available to purchase.
	 */
	String[] generalStoreAnimalArray = {"Chicken", "Cow", "Sheep"};
	/**
	 * The array that displays items available to purchase.
	 */
	String[] generalStoreItemArray = {"Animal Feed", "Animal Treat", "Growth Fertiliser", "Profit Fertiliser", "Shovel", "Tractor"};
	
	/**
	 * This method creates a GeneralStoreDisplays.
	 * @param preGame The PreGame in farm simulator.
	 * @param gameManager The GameManager in farm simulator.
	 */
	public GeneralStoreDisplays(PreGame preGame, GameManager gameManager) {
		this.gameManager = gameManager;
		this.preGame = gameManager.getPreGame();
	}

	public String[] getGeneralStoreCropArray() {
		return generalStoreCropArray;
	}
	public String[] getGeneralStoreAnimalArray() {
		return generalStoreAnimalArray;
	}
	public String[] getGeneralStoreItemArray() {
		return generalStoreItemArray;
	}
	
	public String getGeneralStoreItems() {
		return 
				"Cow"  + "\n" + "\n" +
				"Sheep"  + "\n" + "\n" +
				"Chicken" + "\n" + "\n" +
				"Apple" + "\n" + "\n" +
				"Grape" + "\n" + "\n" +
				"Cherry"+ "\n" + "\n" +
				"Orange" + "\n" + "\n" +
				"Blueberry" + "\n" + "\n" +
				"Strawberry" + "\n" + "\n" +
				"Shovel" + "\n" + "\n" +
				"Tractor " + "\n" + "\n" +
				"Animal Feed" + "\n" + "\n" +
				"Animal Treat" + "\n" + "\n" +
				"Growth Fertiliser" + "\n" + "\n" +
				"Profit Fertiliser";
	}
	
	public String getGeneralStorePrices() {
		return  "Purchase Price: $40" + "\n" + "\n" +
				"Purchase Price: $30" + "\n" + "\n" +
				"Purchase Price: $10" + "\n" + "\n" +
				"Purchase Price: $20" + "\n" + "\n" +
				"Purchase Price: $30" + "\n" + "\n" +
				"Purchase Price: $20"  + "\n" + "\n" +
				"Purchase Price: $30" + "\n" + "\n" +
				"Purchase Price: $10" + "\n" + "\n" +
				"Purchase Price: $10" + "\n" + "\n" +
				"Purchase Price: $20" + "\n" + "\n" +
				"Purchase Price: $100" + "\n" + "\n" +
				"Purchase Price: $20"  + "\n" + "\n" +
				"Purchase Price: $10" + "\n" + "\n" +
				"Purchase Price: $20" + "\n" + "\n" +
				"Purchase Price: $15";

	}
	
	public String getGeneralStoreSellingPrices() {
		return  "Selling Price: $80"  + "\n" + "\n" +
				"Selling Price: $100"  + "\n" + "\n" +
				"Selling Price: $20"  + "\n" + "\n" +
				"Selling Price: $170"  + "\n" + "\n" +
				"Selling Price: $100" + "\n" + "\n" +
				"Selling Price: $40";
	}
	
	public String getGeneralStoreGrowingTimes() {
		return  "Total Growing Time: 2 Days" + "\n" + "\n" +
				"Total Growing Time: 3 Days" + "\n" + "\n" +
				"Total Growing Time: 3 Days" + "\n" + "\n" +
				"Total Growing Time: 2 Days" + "\n" + "\n" +
				"Total Growing Time: 3 Days" + "\n" + "\n" +
				"Total Growing Time: 1 Day";
	}
	
	public String getGeneralStoreBenefits() {
		return  "Benefit: Allows the selected crop to be instantly harvested." + "\n" + "\n" +
				"Benefit: Cleans a plot of land completely." + "\n" + "\n" +
				"Benefit: Increases animal's health by 20 points." + "\n" + "\n" +
				"Benefit: Increases the animal happiness by 20 points." + "\n" + "\n" +
				"Benefit: Reduces the crop growing time by 1 day." + "\n" + "\n" +
				"Benefit: Increases crop profit by 20%.";
	}

}
