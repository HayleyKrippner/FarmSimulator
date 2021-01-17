package generalStore;

import main.GameManager;
import main.PreGame;

/**
 * This class implements all the methods for using the items in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class ItemsActionManager {

	/**
	 * The game manager in farm simulator.
	 */
	private GameManager gameManager;
	/**
	 * The pre game in farm simulator.
	 */
	private PreGame preGame;
	/**
	 * The index of a selected crop.
	 */
	private int cropInt;
	/**
	 * The index of a selected animal.
	 */
	private int animalInt;
	/**
	 * The name of an item.
	 */
	private String item;

	/**
	 * This creates the itemsActionManager.
	 * @param preGame The preGame in farm simulator
	 * @param gameManager The GameManager in farm simulator
	 */
	public ItemsActionManager(PreGame preGame, GameManager gameManager) {
		this.gameManager = gameManager;
		this.preGame = gameManager.getPreGame();
	}
	
	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public int getCropInt() {
		return cropInt;
	}
	public void setCropInt(int cropInt) {
		this.cropInt = cropInt;
	}
	
	public int getAnimalInt() {
		return animalInt;
	}
	public void setAnimalInt(int animalInt) {
		this.animalInt = animalInt;
	}
	
	/**
	 * This method uses growth fertiliser on a chosen crop.
	 */
	public void useGrowthFertiliser() {
		preGame.getSelectedFarm().getFarmCropsArray().get(getCropInt()).reduceTimeUntilHarvest();
		preGame.getSelectedFarm().reduceNumofActions();
	}
	
	/**
	 * This method uses profit fertiliser on a chosen crop.
	 */
	public void useProfitFertiliser() {
		double sellingPrice = preGame.getSelectedFarm().getFarmCropsArray().get(getCropInt()).getSellingPrice();
		sellingPrice = 1.2 * sellingPrice;
		preGame.getSelectedFarm().getFarmCropsArray().get(getCropInt()).setSellingPrice(sellingPrice);
		preGame.getSelectedFarm().reduceNumofActions();
	}
	
	/**
	 * This method uses the shovel on a chosen crop.
	 */
	public void useShovel() {
		double sellingPrice = preGame.getSelectedFarm().getFarmCropsArray().get(getCropInt()).getSellingPrice();
		double currentMoney = preGame.getSelectedFarm().getFarmMoney();
		currentMoney += sellingPrice;
		preGame.getSelectedFarm().setFarmMoney(currentMoney);
		preGame.getSelectedFarm().getFarmCropsArray().remove(getCropInt());
		preGame.getSelectedFarm().getFarmCropsInventory().remove(getCropInt());
		preGame.getSelectedFarm().reduceNumofActions();
	}
	
	/**
	 * This method uses animal feed on a chosen animal.
	 */
	public void useAnimalFeed() {
		preGame.getSelectedFarm().getFarmAnimalsArray().get(getAnimalInt()).feed();
		preGame.getSelectedFarm().reduceNumofActions();
	}
	
	/**
	 * This method uses animal treat on a chosen animal.
	 */
	public void useAnimalTreat() {
		int happiness = preGame.getSelectedFarm().getFarmAnimalsArray().get(getAnimalInt()).getHappiness();
		happiness += 20;
		preGame.getSelectedFarm().getFarmAnimalsArray().get(getAnimalInt()).setHappiness(happiness);
		preGame.getSelectedFarm().reduceNumofActions();
	}
	
	/**
	 * This method uses a tractor on the land.
	 */
	public void useTractor() {
		double currentMoney = preGame.getSelectedFarm().getFarmMoney();
		currentMoney += 50;
		preGame.getSelectedFarm().setFarmMoney(currentMoney);
		preGame.getSelectedFarm().reduceNumofActions();
	}

}