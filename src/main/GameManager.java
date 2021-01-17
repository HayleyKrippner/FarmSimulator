package main;

import java.util.ArrayList;
import animals.Animal;
import crops.Crop;
import farm.Farm;
import generalStore.GeneralStore;
import generalStore.GeneralStoreDisplays;
import generalStore.ItemsActionManager;

/**
 * This class implements the methods for the GameManager in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class GameManager {
	/**
	 * The PreGame in farm simulator.
	 */
	private PreGame preGame;
	/**
	 * The GameRules in farm simulator.
	 */
	private GameRules gameRules;
	/**
	 * The Farm in farm simulator.
	 */
	private Farm farm;
	/**
	 * The ArrayList which holds the Animals the Farm has.
	 */
	private ArrayList<Animal> farmAnimalsArray;
	/**
	 * The ArrayList which holds the Crops the Farm has.
	 */
	private ArrayList<Crop> farmCropsArray;
	/**
	 * The GeneralStore in farm simulator.
	 */
	private GeneralStore generalStore;
	/**
	 * The Crop in farm simulator.
	 */
	private Crop crop;
	/**
	 * The General Store Display in farm simulator.
	 */
	private GeneralStoreDisplays generalStoreDisplays;
	/**
	 * The ItemsActionManager in farm simulator.
	 */
	private ItemsActionManager itemsActionManager;
	
	/**
	 * This creates a GameManager.
	 */
	public GameManager() {
		
	}
	
	/**
	 * This the entry point for the farm simulator.
	 * @param args The argument.
	 */
	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		gameManager.launchPreGameScreen();
	}
	
	/**
	 * This method creates the PreGameScreen and creates a PreGame.
	 */
	public void launchPreGameScreen() {
		this.preGame = new PreGame();
		PreGameScreen preGameScreen = new PreGameScreen(this, preGame);
	}

	/**
	 * This method closes PreGameScreen and launches GameRulesScreen.
	 * @param preGameScreen The PreGameScreen in farm simulator.
	 */
	public void closePreGameScreen(PreGameScreen preGameScreen) {
		preGameScreen.closeWindow();
		launchGameRulesScreen();
	}
	
	/**
	 * This method creates the GameRulesScreen and creates GameRules.
	 */
	public void launchGameRulesScreen() {
		this.gameRules = new GameRules();
		GameRulesScreen gameRulesScreen = new GameRulesScreen(this, gameRules);
	}

	/**
	 * This method closes GameRulesScreen and launches MainScreen.
	 * @param gameRulesScreen The GameRulesScreen in farm simulator.
	 */
	public void closeGameRulesScreen(GameRulesScreen gameRulesScreen) {
		gameRulesScreen.closeWindow();
		launchMainScreen();
	}
	
	/**
	 * This method creates the MainScreen and creates ItemsActionManager.
	 */
	public void launchMainScreen() {
		this.itemsActionManager = new ItemsActionManager(preGame, this);
		MainScreen mainScreen = new MainScreen(this, preGame);
	}
	
	/**
	 * This method closes MainScreen and launches EndGameScreen.
	 * @param mainScreen The MainScreen in farm simulator.
	 */
	public void closeMainScreen(MainScreen mainScreen) {
		mainScreen.closeWindow();
		launchEndGameScreen();
	}
	
	/**
	 * This method closes Main Screen and launches GeneralStoreScreen.
	 * @param mainScreen The MainScreen in farm simulator.
	 */
	public void closeMainScreenToGeneralStore(MainScreen mainScreen) {
		mainScreen.closeWindowToGeneralStore();
		launchGeneralStoreScreen();
	}

	/**
	 * This method closes MainScreen and launches FarmScreen.
	 * @param mainScreen The MainScreen in farm simulator.
	 */
	public void closeMainScreenToFarm(MainScreen mainScreen) {
		mainScreen.closeWindowFarm();
		launchFarmScreen();
	}
	
	/**
	 * This method creates the FarmScreen and the Crop.
	 */
	public void launchFarmScreen() {
		this.generalStore = new GeneralStore(preGame, this);
		this.crop = new Crop();
		FarmScreen farmScreen = new FarmScreen(this, preGame, generalStore, itemsActionManager);
	}
	
	/**
	 * This method closes the FarmScreen and launches MainScreen.
	 * @param farmScreen The FarmScreen in farm simulator.
	 */
	public void closeFarmScreen(FarmScreen farmScreen) {
		farmScreen.closeWindow();
		launchMainScreen();
	}
	
	/**
	 * This method creates GeneralStoreDisplays, GeneralStore and GeneralStoreScreen.
	 */
	public void launchGeneralStoreScreen() {
		this.generalStoreDisplays = new GeneralStoreDisplays(preGame, this);
		this.generalStore = new GeneralStore(preGame, this);
		GeneralStoreScreen generalStoreScreen = new GeneralStoreScreen(this, preGame, generalStore, generalStoreDisplays);
	}
	/**
	 * This method closes GeneralStoreScreen and launches MainScreen.
	 * @param generalStoreScreen The GeneralStoreScreen in farm simulator.
	 */
	public void closeGeneralStoreScreen(GeneralStoreScreen generalStoreScreen) {
		generalStoreScreen.closeWindow();
		launchMainScreen();
	}
	/**
	 * This method closes GeneralStoreScreen and launches InventoryScreen.
	 * @param generalStoreScreen The GeneralStoreScreen in farm simulator.
	 */
	public void closeGeneralStoreScreenToInventory(GeneralStoreScreen generalStoreScreen) {
		generalStoreScreen.closeWindow();
		launchInventoryScreen();
	}
	/**
	 * This method creates InventoryScreen.
	 */
	public void launchInventoryScreen() {
		InventoryScreen inventoryScreen = new InventoryScreen(this, preGame, generalStore);
	}
	/**
	 * This method closes InventoryScreen and launches GeneralStoreScreen.
	 * @param inventoryScreen The InventoryScreen in farm simulator.
	 */
	public void closeInventoryScreen(InventoryScreen inventoryScreen) {
		inventoryScreen.closeWindow();
		launchGeneralStoreScreen();
	}
	/**
	 * This method creates EndGameScreen.
	 */
	public void launchEndGameScreen() {
		EndGameScreen endGameScreen = new EndGameScreen(this, preGame);
	}
	/**
	 * This method closes EndGameScreen.
	 * @param endGameScreen The EndGameScreen in farm simulator.
	 */
	public void closeEndGameScreen(EndGameScreen endGameScreen) {
		endGameScreen.closeWindow();
	}

	public PreGame getPreGame() {
		return this.preGame;
	}
	
	public GameRules getGameRules() {
		return this.gameRules;
	}
	
	public Farm getFarm() {
		return this.farm;
	}


	public ArrayList<Animal> getFarmAnimalsArray() {
		return farmAnimalsArray;
	}

	public ArrayList<Crop> getFarmCropsArray() {
		return farmCropsArray;
	}

	public GeneralStore getGeneralStore() {
		// TODO Auto-generated method stub
		return this.generalStore;
	}
	
	public GeneralStoreDisplays getGeneralStoreDisplays() {
		return this.generalStoreDisplays;
	}

	public Crop getCrop() {
		return this.crop;
	}

	public ItemsActionManager getItemsActionManager() {
		return this.itemsActionManager;
	}
	
}
