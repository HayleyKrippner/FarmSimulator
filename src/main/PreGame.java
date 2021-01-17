package main;

import farm.Farm;
import farm.Farmer;

/**
 * This class implements the methods for the PreGame in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class PreGame {
	/**
	 * The farmer's name.
	 */
	private String farmerName;
	/**
	 * The farmer's age.
	 */
	private int farmerAge;
	/**
	 * The farm's name.
	 */
	private String farmName;
	/**
	 * The farm type.
	 */
	private int farmType;
	/**
	 * The amount of money in the farm.
	 */
	private int farmMoney;
	/**
	 * The amount of days the game will be played over.
	 */
	private int gameDuration;
	/**
	 * The selected farm.
	 */
	private Farm selectedFarm;
	/**
	 * The farmer.
	 */
	private Farmer farmer;
	/**
	 * The array that displays age choices for farmer.
	 */
	String[] farmerAgeArray = {"10", "11", "12", "13","14", "15", "16", "17", "18", "19",
			"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
			"30", "31", "32", "33", "34", "35", "36", "37", "38", "39", 
			"40", "41", "42", "43", "44", "45", "46", "47", "48", "49", 
			"50", "51", "52", "53", "54", "55", "56", "57", "58", "59", 
			"60", "61", "62", "63", "64", "65", "66", "67", "68", "69", 
			"70", "71", "72", "73", "74", "75", "76", "77", "78", "79", 
			"80", "81", "82", "83", "84", "85", "86", "87", "88", "89", 
			"90", "91", "92", "93", "94", "95", "96", "97", "98", "99", };
	/**
	 * The array that displays farm type choices for farmer.
	 */
	String[] farmTypeArray = {"1", "2", "3", "4"};
	/**
	 * The array that displays game duration choices for farmer.
	 */
	String[] gameDurationArray = {"5", "6", "7", "8", "9", "10"};

	/**
	 * This creates PreGame.
	 */
	public PreGame() {
	}

	public String greetUser() {
		return "Welcome to Farm Simulator!";
	}
	
	public String askFarmerName() {
		return "What is your name?";
	}
	
	public String askFarmerAge() {
		return "What is your age?";
	}
	
	public String askFarmName() {
		return "What would you like to name your farm?";
	}
	
	public String askGameDuration() {
		return "How many days would you like to play?";
	}
	
	public String askFarmType() {
		return "Please select your farm";
	}
	
	public String[] getFarmerAgeArray() {
		return farmerAgeArray ;
	}
	
	public String[] getGameDurationArray() {
		return gameDurationArray;
	}
	
	public String[] getFarmTypeArray() {
		return farmTypeArray;
	}
	/**
	 * Displays the four farm types' info.
	 * @return String The string with farm description.
	 */
	public String getFarmTypeInfo() {
		return "\nFarm 1: Start with double the money\n\nFarm 2: Get a profit bonus for crops\n\nFarm 3: Happier Animals\n\nFarm 4: 20% Cheaper Animal Feed";

	}
	/**
	 * Creates a Farmer based on the chosen user input.
	 */
	public void createFarmer() {
		Farmer farmer = new Farmer(getFarmerName(), getFarmerAge());
		setFarmer(farmer);
		
	}
	/**
	 * Creates a Farm based on the chosen type of Farm.
	 */
	public void createFarm() {	
		if (getFarmType() == 1) {
			Farm farm = new Farm(getFarmName(), getGameDuration(), getFarmType(), 400.00, 1.00, 1.00, 1.00);
			setSelectedFarm(farm);
		} else if (farmType == 2) {
			Farm farm = new Farm(getFarmName(), getGameDuration(), getFarmType(), 200.00, 2.00, 1.00, 1.00);
			setSelectedFarm(farm);
		} else if (farmType == 3) {
			Farm farm = new Farm(getFarmName(), getGameDuration(), getFarmType(), 200.00, 1.00, 0.50, 1.00);
			setSelectedFarm(farm);
		} else if (farmType == 4) {
			Farm farm = new Farm(getFarmName(), getGameDuration(), getFarmType(), 200, 1.00, 1.00, 0.80);
			setSelectedFarm(farm);
		}
		
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public int getFarmerAge() {
		return farmerAge;
	}

	public void setFarmerAge(int farmerAge) {
		this.farmerAge = farmerAge;
	}

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public int getFarmType() {
		return farmType;
	}

	public void setFarmType(int farmType) {
		this.farmType = farmType;
	}

	public int getFarmMoney() {
		return farmMoney;
	}

	public void setFarmMoney(int farmMoney) {
		this.farmMoney = farmMoney;
	}

	public int getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(int gameDuration) {
		this.gameDuration = gameDuration;
	}
	public Farm getSelectedFarm() {
		return selectedFarm;
	}
	public void setSelectedFarm(Farm selectedFarm) {
		this.selectedFarm = selectedFarm;
	}
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

}
