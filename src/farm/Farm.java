package farm;

import java.util.ArrayList;

import animals.Animal;
import animals.Cow;
import crops.Crop;
import generalStore.Item;

/**
 * This class implements the methods for the Farm in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class Farm {
	/**
	 * The name of the Farm.
	 */
	private String farmName;
	/**
	 * The duration of the game.
	 */
	private int gameDuration;
	/**
	 * The type of Farm.
	 */
	private int farmType;
	/**
	 * The money in the Farm.
	 */
	private double farmMoney;
	/**
	 * The Farm's daily bonus.
	 */
	private double dailyFarmBonus;
	/**
	 * The current day in the farm adventure.
	 */
	private int currentDay;
	/**
	 * The number of actions remaining for the current day.
	 */
	private int numOfActions;
	/**
	 * The ArrayList which holds the Animals the Farm has.
	 */
	private ArrayList<Animal> farmAnimalsArray;
	/**
	 * The ArrayList which holds the Crops the Farm has.
	 */
	private ArrayList<Crop> farmCropsArray;
	/**
	 * The ArrayList which holds the Items the Farm has.
	 */
	private ArrayList<Item> farmItemsArray;
	/**
	 * The ArrayList which holds the Animals inventory.
	 */
	private ArrayList<String> farmCropsInventory;
	/**
	 * The ArrayList which holds the Crops inventory.
	 */
	private ArrayList<String> farmAnimalsInventory;
	/**
	 * The ArrayList which holds the Items inventory.
	 */
	private ArrayList<String> farmItemsInventory;
	/**
	 * The Crop bonus.
	 */
	private double cropBonus;
	/**
	 * Whether the Farm has an Animal happiness level bonus applied to it.
	 */
	private double happinessBonus;
	/**
	 * The Animal Feed bonus.
	 */
	private double animalFeedBonus;
	/**
	 * The total profit the Farm has made so far in the game.
	 */
	private double totalProfit;
	/**
	 * The final score when the game ends.
	 */
	private double finalScore;
	
	/**
	 * This creates the farm constructor
	 */
	public Farm() {}
	
	/**
	 * This method creates a Farm.
	 * The current day is initialised to day 1.
	 * The number of daily actions is initialised to 2.
	 * The Farm begins with $0 total profit.
	 * The farm type perk is applied.
	 * @param farmName The name of the Farm
	 * @param gameDuration The duration of the game 
	 * @param farmType The type of Farm
	 * @param farmMoney The money of the Farm
	 * @param cropBonus The Crop bonus
	 * @param happinessBonus Whether the Farm has Animal happiness bonus
	 * @param animalFeedBonus The Animal Feed bonus applied in the generalStore
	 **/
	public Farm(String farmName, int gameDuration, int farmType, double farmMoney, double cropBonus, double happinessBonus, double animalFeedBonus) {
		this.setFarmName(farmName);
		this.setGameDuration(gameDuration);
		this.setFarmType(farmType);
		this.setFarmMoney(farmMoney);
		this.setCurrentDay(1);
		this.setNumOfActions(2);
		this.setFarmAnimalsArray(new ArrayList<Animal>());
		this.setFarmCropsArray(new ArrayList<Crop>());
		this.setFarmItemsArray(new ArrayList<Item>());
		this.setFarmAnimalsInventory(new ArrayList<String>());
		this.setFarmCropsInventory(new ArrayList<String>());
		this.setFarmItemsInventory(new ArrayList<String>());
		this.setCropBonus(cropBonus);
		this.setHappinessBonus(happinessBonus);
		this.setAnimalFeedBonus(animalFeedBonus);
		this.getFarmAnimalsArray().add(new Cow());
		this.getFarmAnimalsInventory().add("Cow");
	}
	
	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public int getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(int gameDuration) {
		this.gameDuration = gameDuration;
	}

	public int getFarmType() {
		return farmType;
	}

	public void setFarmType(int farmType) {
		this.farmType = farmType;
	}

	public double getFarmMoney() {
		return farmMoney;
	}

	public void setFarmMoney(double farmMoney) {
		this.farmMoney = farmMoney;
	}

	public double getDailyFarmBonus() {
		return dailyFarmBonus;
	}

	public void setDailyFarmBonus(double dailyFarmBonus) {
		this.dailyFarmBonus = dailyFarmBonus;
	}

	public int getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}
	
	/**
	 * This method updates what day it is in the farming adventure.
	 */
	public void updateCurrentDay() {
		currentDay += 1;
	}
	

	public int getNumOfActions() {
		return numOfActions;
	}

	public void setNumOfActions(int numOfActions) {
		this.numOfActions = numOfActions;
	}
	
	/**
	 * This method reduces the number of daily actions remaining when one is used.
	 */
	public void reduceNumofActions() {
		numOfActions -= 1;
	}
	
	/**
	 * This method resets the number of daily actions.
	 */
	public void resetNumOfActions() {
		numOfActions = 2;
	}

	public ArrayList<Animal> getFarmAnimalsArray() {
		return farmAnimalsArray;
	}

	public void setFarmAnimalsArray(ArrayList<Animal> farmAnimalsArray) {
		this.farmAnimalsArray = farmAnimalsArray;
	}

	public ArrayList<Crop> getFarmCropsArray() {
		return farmCropsArray;
	}

	public void setFarmCropsArray(ArrayList<Crop> farmCropsArray) {
		this.farmCropsArray = farmCropsArray;
	}
	
	public ArrayList<Item> getFarmItemsArray() {
		return farmItemsArray;
	}

	public void setFarmItemsArray(ArrayList<Item> farmItemsArray) {
		this.farmItemsArray = farmItemsArray;
	}

	public double getCropBonus() {
		return cropBonus;
	}

	public void setCropBonus(double cropBonus) {
		this.cropBonus = cropBonus;
	}

	public double getHappinessBonus() {
		return happinessBonus;
	}

	public void setHappinessBonus(double happinessBonus) {
		this.happinessBonus = happinessBonus;
	}

	public double getAnimalFeedBonus() {
		return animalFeedBonus;
	}

	public void setAnimalFeedBonus(double animalFeedBonus) {
		this.animalFeedBonus = animalFeedBonus;
	}
	
	/**
	 * This method displays Farm name, game duration, type and money in dollars.
	 * @return The Farm name, game duration, type and money.
	 */
	public String toString() {
		return "Farm Name: " + this.getFarmName() + "\n" + "\n" + "Current Day: " + this.getCurrentDay() + " of " + this.getGameDuration() + " days"  + "\n" + "\n"
				+ "Actions Remaining: " + this.getNumOfActions() + "\n" + "\n" +"Money: $" +  String.format("%.02f",  this.getFarmMoney());
	}
	
	/*
	 * This method ends the day and updates the Animal and Crop characteristics. It
	 * ends the farming day even if actions have not all be used up. The farm bonus
	 * is applied and the daily summary is displayed.
	 */
	public void nextDay() {
		for (int index = 0; index < getFarmAnimalsArray().size(); index++) {
			Animal animal = getFarmAnimalsArray().get(index);
			animal.reduceAnimalHappiness();
			animal.reduceAnimalHealth();
		}
		for (int index = 0; index < getFarmCropsArray().size(); index++) {
			getFarmCropsArray().get(index).reduceWaterLevel();
			getFarmCropsArray().get(index).reduceTimeUntilHarvest();
		}
		resetNumOfActions();
		updateCurrentDay();
		calculateDailyFarmBonus();
		double newFarmMoney = getFarmMoney() + getDailyFarmBonus();
		setFarmMoney(newFarmMoney);
	}	
	
	/**
	 * This method calculates the DailyFarmBonus at the end of the day based on the
	 * happiness and health level of the Animals and the number of Animals.
	 */
	public void calculateDailyFarmBonus() {
		double cumulativeAnimalHappinessAverage = 0;
		double cumulativeAnimalHealthAverage = 0;
		int numOfAnimals = getFarmAnimalsArray().size();

		for (int animalIndex = 0; animalIndex < numOfAnimals; animalIndex++) {
			Animal animal = getFarmAnimalsArray().get(animalIndex);
			cumulativeAnimalHappinessAverage += animal.getHappiness();
			cumulativeAnimalHealthAverage += animal.getHealth();
		}

		cumulativeAnimalHappinessAverage = cumulativeAnimalHappinessAverage / numOfAnimals;
		double newDailyFarmBonus = (cumulativeAnimalHappinessAverage + cumulativeAnimalHealthAverage) / 2;
		setDailyFarmBonus(newDailyFarmBonus);
	}


	public ArrayList<String> getFarmCropsInventory() {
		return farmCropsInventory;
	}


	public void setFarmCropsInventory(ArrayList<String> farmCropsInventory) {
		this.farmCropsInventory = farmCropsInventory;
	}


	public ArrayList<String> getFarmAnimalsInventory() {
		return farmAnimalsInventory;
	}


	public void setFarmAnimalsInventory(ArrayList<String> farmAnimalsInventory) {
		this.farmAnimalsInventory = farmAnimalsInventory;
	}


	public ArrayList<String> getFarmItemsInventory() {
		return farmItemsInventory;
	}


	public void setFarmItemsInventory(ArrayList<String> farmItemsInventory) {
		this.farmItemsInventory = farmItemsInventory;
	}
	
	/**
	 * This method cleans the land in the farm simulator.
	 * This increases the farm money.
	 */
	public void cleanLand() {
		double newFarmMoney = getFarmMoney();
		newFarmMoney += 10;
		setFarmMoney(newFarmMoney);
	}
	
	/**
	 * This method calculates the total profit at the end of the game.
	 * This is based on the starting money and finishing money.
	 */
	public void calculateTotalProfit() {
		if (this.farmType == 1) {
			this.totalProfit = this.getFarmMoney() - 400;
		} else {
			this.totalProfit = this.getFarmMoney() - 400;
		}
	}
	
	
	public double getTotalProfit() {
		return totalProfit;
		
	}
	
	/**
	 * This method calculates the final score at the end of the game.
	 * This is the sum of all inventory items multiplied by the game
	 * duration plus the total profit.
	 */
	public void calculateFinalScore() {
		double numOfAnimals = this.getFarmCropsArray().size();
		double numOfCrops = this.getFarmAnimalsArray().size();
		double numOfItems = this.getFarmItemsArray().size();
		double gameDuration = this.getGameDuration();
		double totalProfit = this.getTotalProfit();
		this.finalScore = (numOfAnimals + numOfCrops + numOfItems) * gameDuration + totalProfit;
	}
	
	public double getFinalScore() {
		return finalScore;
	}
	
	/**
	 * This method displays Farm name, game duration, total profit and final score.
	 * @return The Farm name, game duration, total profit and final score.
	 */
	public String toStringEndGameStats() {
		return "Farm Name: " + this.getFarmName() + "\n" + "\n" + "Game Duration: " + this.getGameDuration() + " days" + "\n" + "\n" + 
				"Total Profit: $" + String.format("%.02f",this.getTotalProfit()) + "\n" + "\n" + "Final Score: " + String.format("%.02f",getFinalScore()); 
	}
}
