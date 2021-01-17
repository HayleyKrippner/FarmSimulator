package main;

/**
 * This class implements all the methods for the GameRules in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class GameRules {
	
	/**
	 * This creates a GameRules
	 */
	public GameRules() {}
	
	public String getGameRulesTitle() {
		return "Farm Simulator Rules";
	}
	
	public String getGameRules() {
		return "Your goal is the make as much profit as possible in your farming adventure.\n\nPurchase crops and animals, "
				+ "keep them happy and tend to your farm.\n\nThe happier and healtier your crops and animals, the more successful "
				+ "you will be.\n\nSpend your money in the country's general store to buy items, crops and animals for your farm.\n\nVisit "
				+ "your farm, vist the store and view your farm's statisitcs in the main screen.\n\nYou have two actions each day and can skip "
				+ "the day in the main screen.\n\nEnjoy your farming adventure!";
	}
}