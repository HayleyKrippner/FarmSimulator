package generalStore;

import animals.Chicken;
import animals.Cow;
import animals.Sheep;
import crops.Apple;
import crops.Blueberry;
import crops.Cherry;
import crops.Grape;
import crops.Orange;
import crops.Strawberry;
import main.GameManager;
import main.PreGame;
import crops.Crop;
import animals.Animal;

/**
 * This class implements all the methods for the GeneralStore in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class GeneralStore {
	/**
	 * The name of the item.
	 */
	private String item;
	/**
	 * The PreGame in the farm simulator.
	 */
	private PreGame preGame;
	/**
	 * The GameManager in the farm simulator
	 */
	private GameManager gameManager;

	/**
	 * This method creates a GeneralStore.
	 * @param preGame The PreGame in farm simulator.
	 * @param gameManager The GameManager in farm simulator.
	 */
	public GeneralStore(PreGame preGame, GameManager gameManager) {
		this.gameManager = gameManager;
		this.preGame = gameManager.getPreGame();
	}
	
	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * This method purchases an animal based on selection input.
	 */
	public void purchaseAnimal() {
		if (getItem() == "Cow") {
			Cow cow = new Cow();
			preGame.getSelectedFarm().getFarmAnimalsArray().add(cow);
			deductAnimalPurchase(cow);
		} else if (getItem() == "Sheep") {
			Sheep sheep = new Sheep();
			preGame.getSelectedFarm().getFarmAnimalsArray().add(sheep);
			deductAnimalPurchase(sheep);
		}else if (getItem() == "Chicken") {
			Chicken chicken = new Chicken();
			preGame.getSelectedFarm().getFarmAnimalsArray().add(chicken);
			deductAnimalPurchase(chicken);
		}
	}
	
	/**
	 * This method purchases a crop based on selection input.
	 */
	public void purchaseCrop() {
		if (getItem() == "Apple") {
			Apple apple = new Apple();
			preGame.getSelectedFarm().getFarmCropsArray().add(apple);
			deductCropPurchase(apple);
		} else if (getItem() == "Cherry") {
			Cherry cherry = new Cherry();
			preGame.getSelectedFarm().getFarmCropsArray().add(cherry);
			deductCropPurchase(cherry);
		} else if (getItem()== "Grape") {
			Grape grape = new Grape();
			preGame.getSelectedFarm().getFarmCropsArray().add(grape);
			deductCropPurchase(grape);
		} else if (getItem() == "Blueberry") {
			Blueberry blueberry = new Blueberry();
			preGame.getSelectedFarm().getFarmCropsArray().add(blueberry);
			deductCropPurchase(blueberry);
		} else if (getItem() == "Orange") {
			Orange orange = new Orange();
			preGame.getSelectedFarm().getFarmCropsArray().add(orange);
			deductCropPurchase(orange);
		} else if (getItem() == "Strawberry") {
			Strawberry strawberry = new Strawberry();
			preGame.getSelectedFarm().getFarmCropsArray().add(strawberry);
			deductCropPurchase(strawberry);
		}
	}
	
	/**
	 * This method purchases an item based on selection input.
	 */
	public void purchaseItem() {
		if (getItem() == "Shovel") {
			Shovel shovel = new Shovel();
			preGame.getSelectedFarm().getFarmItemsArray().add(shovel);
			deductItemPurchase(shovel);
		} else if (getItem() == "Tractor") {
			Tractor tractor = new Tractor();
			preGame.getSelectedFarm().getFarmItemsArray().add(tractor);
			deductItemPurchase(tractor);
		} else if (getItem() == "Animal Feed") {
			AnimalFeed animalFeed = new AnimalFeed();
			preGame.getSelectedFarm().getFarmItemsArray().add(animalFeed);
			deductItemPurchase(animalFeed);
		} else if (getItem()== "Animal Treat") {
			AnimalTreat animalTreat = new AnimalTreat();
			preGame.getSelectedFarm().getFarmItemsArray().add(animalTreat);
			deductItemPurchase(animalTreat);
		} else if (getItem() == "Growth Fertiliser") {
			GrowthFertiliser growthFertiliser = new GrowthFertiliser();
			preGame.getSelectedFarm().getFarmItemsArray().add(growthFertiliser);
			deductItemPurchase(growthFertiliser);
		} else if (getItem() == "Profit Fertilser") {
			ProfitFertiliser profitFertiliser = new ProfitFertiliser();
			preGame.getSelectedFarm().getFarmItemsArray().add(profitFertiliser);
			deductItemPurchase(profitFertiliser);
		}
	}
	
	/**
	 * This method deducts money after an animal is purchased.
	 * @param animal The animal being purchased
	 */
	public void deductAnimalPurchase(Animal animal) {
		double currentMoney = preGame.getSelectedFarm().getFarmMoney();
		double cost = animal.getPurchasePrice();
		double newMoney = currentMoney - cost;
		preGame.getSelectedFarm().setFarmMoney(newMoney);
	}
	
	/**
	 * This method deducts money after a crop is purchased.
	 * @param crop The crop being purchased.
	 */
	public void deductCropPurchase(Crop crop) {
		double currentMoney = preGame.getSelectedFarm().getFarmMoney();
		double cost = crop.getPurchasePrice();
		double newMoney = currentMoney - cost;
		preGame.getSelectedFarm().setFarmMoney(newMoney);
	}
	
	/**
	 * This method deducts money after an item is purchased.
	 * @param item The item being purchased.
	 */
	public void deductItemPurchase(Item item) {
		double currentMoney = preGame.getSelectedFarm().getFarmMoney();
		double cost = item.getPurchasePrice();
		double newMoney = currentMoney - cost;
		preGame.getSelectedFarm().setFarmMoney(newMoney);
	}
	
	/**
	 * This method converts farm crops inventory array list into an array of string type so it can
	 * be used to display crops in inventory.
	 * @return cropsArray
	 */
	public String[] displayFarmCrops() {
		String[] cropsArray = new String[preGame.getSelectedFarm().getFarmCropsInventory().size()];
		preGame.getSelectedFarm().getFarmCropsInventory().toArray(cropsArray);
		return cropsArray;
	}
	
	/**
	 * This method converts farm animals inventory array list into an array of string type so it can
	 * be used to display animals in inventory.
	 * @return animalsArray
	 */
	public String[] displayFarmAnimals() {
		String [] animalsArray = new String[preGame.getSelectedFarm().getFarmAnimalsInventory().size()];
		preGame.getSelectedFarm().getFarmAnimalsInventory().toArray(animalsArray);
		return animalsArray;
	}
	
	/**
	 * This method converts farm items inventory array list into an array of string type so it can
	 * be used to display items in inventory.
	 * @return itemsArray
	 */
	public String[] displayFarmItems() {
		String [] itemsArray = new String[preGame.getSelectedFarm().getFarmItemsInventory().size()];
		preGame.getSelectedFarm().getFarmItemsInventory().toArray(itemsArray);
		return itemsArray;
	}

	
}