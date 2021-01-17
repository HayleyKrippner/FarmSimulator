package main;

import generalStore.GeneralStore;
import generalStore.GeneralStoreDisplays;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.SystemColor;
/**
 * This class implements all the methods for GeneralStoreScreen in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class GeneralStoreScreen {

	/**
	 * Frame for farm simulator GeneralStoreScreen.
	 */
	private JFrame frmFarmSimulatorGeneral;
	/**
	 * The GameManager in farm simulator.
	 */
	private GameManager gameManager;
	/**
	 * The PreGame in farm simulator.
	 */
	private PreGame preGame;
	/**
	 * The GeneralStore in farm simulator.
	 */
	private GeneralStore generalStore;
	/**
	 * The GeneralStoreDisplays in farm simulator.
	 */
	private GeneralStoreDisplays generalStoreDisplays;
	/**
	 * ComboBox for selecting animal to purchase.
	 */
	private JComboBox<String> animalComboBox;
	/**
	 * ComboBox for selecting crop to purchase.
	 */
	private JComboBox<String> cropComboBox;
	/**
	 * ComboBox for selecting item to purchase.
	 */
	private JComboBox<String> itemComboBox;


	/**
	 * Create the application
	 * @param gameManager The GameManager in farm simulator.
	 * @param preGame The PreGame in farm simulator.
	 * @param generalStore The GeneralStore in farm simulator.
	 * @param generalStoreDisplays The GeneralStoreDisplays in farm simulator.
	 */
	public GeneralStoreScreen(GameManager gameManager, PreGame preGame, GeneralStore generalStore, GeneralStoreDisplays generalStoreDisplays) {
		this.gameManager = gameManager;
		this.preGame = gameManager.getPreGame();
		this.generalStore = gameManager.getGeneralStore();
		this.generalStoreDisplays = gameManager.getGeneralStoreDisplays();
		initialize();
		frmFarmSimulatorGeneral.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFarmSimulatorGeneral = new JFrame();
		frmFarmSimulatorGeneral.getContentPane().setFont(new Font("Arial", Font.PLAIN, 20));
		frmFarmSimulatorGeneral.setTitle("Farm Simulator General Store");
		frmFarmSimulatorGeneral.setBounds(100, 100, 1280, 800);
		frmFarmSimulatorGeneral.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFarmSimulatorGeneral.getContentPane().setLayout(null);
		
		JButton mainMenuButton = new JButton("Main Menu");
		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		mainMenuButton.setFont(new Font("Arial", Font.PLAIN, 18));
		mainMenuButton.setBounds(1052, 693, 193, 54);
		frmFarmSimulatorGeneral.getContentPane().add(mainMenuButton);
		
		JLabel farmMoneyLabel = new JLabel("");
		farmMoneyLabel.setFont(new Font("Arial", Font.PLAIN, 28));
		farmMoneyLabel.setBounds(31, 19, 435, 41);
		frmFarmSimulatorGeneral.getContentPane().add(farmMoneyLabel);
		double farmMoney = Double.valueOf(preGame.getSelectedFarm().getFarmMoney());
		farmMoneyLabel.setText("Current Farm Money: $" + String.format("%.02f",farmMoney));
		
		JButton purchaseAnimalButton = new JButton("Purchase Animal");
		purchaseAnimalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String animalPurchase = (String) animalComboBox.getSelectedItem();
				generalStore.setItem(animalPurchase);
				preGame.getSelectedFarm().getFarmAnimalsInventory().add(animalPurchase);
				generalStore.purchaseAnimal();
				double farmMoney = Double.valueOf(preGame.getSelectedFarm().getFarmMoney());
				farmMoneyLabel.setText("Current Farm Money: $" + String.format("%.02f", farmMoney));
				animalComboBox.setSelectedIndex(-1);
			}
		});
		purchaseAnimalButton.setFont(new Font("Arial", Font.PLAIN, 18));
		purchaseAnimalButton.setBounds(31, 693, 171, 54);
		frmFarmSimulatorGeneral.getContentPane().add(purchaseAnimalButton);
		
		JButton viewInventoryButton = new JButton("View Inventory");
		viewInventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindowToInventory();
			}
		});
		viewInventoryButton.setFont(new Font("Arial", Font.PLAIN, 18));
		viewInventoryButton.setBounds(790, 693, 183, 54);
		frmFarmSimulatorGeneral.getContentPane().add(viewInventoryButton);
		
		JLabel purchaseCropLabel = new JLabel("Select Crop To Purchase");
		purchaseCropLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		purchaseCropLabel.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseCropLabel.setBounds(506, 91, 243, 46);
		frmFarmSimulatorGeneral.getContentPane().add(purchaseCropLabel);
		
		JLabel purchaseItemLabel = new JLabel("Select Item To Purchase");
		purchaseItemLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		purchaseItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseItemLabel.setBounds(902, 91, 243, 41);
		frmFarmSimulatorGeneral.getContentPane().add(purchaseItemLabel);
		
		JLabel purchaseAnimalLabel = new JLabel("Select Animal To Purchase");
		purchaseAnimalLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		purchaseAnimalLabel.setBounds(31, 91, 311, 41);
		frmFarmSimulatorGeneral.getContentPane().add(purchaseAnimalLabel);
		
		animalComboBox = new JComboBox(generalStoreDisplays.getGeneralStoreAnimalArray());
		animalComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		animalComboBox.setBounds(31, 137, 260, 27);
		frmFarmSimulatorGeneral.getContentPane().add(animalComboBox);
		animalComboBox.setSelectedIndex(-1);
		
		cropComboBox = new JComboBox(generalStoreDisplays.getGeneralStoreCropArray());
		cropComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		cropComboBox.setBounds(506, 139, 243, 27);
		frmFarmSimulatorGeneral.getContentPane().add(cropComboBox);
		cropComboBox.setSelectedIndex(-1);
		
		itemComboBox = new JComboBox(generalStoreDisplays.getGeneralStoreItemArray());
		itemComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		itemComboBox.setBounds(897, 139, 259, 27);
		frmFarmSimulatorGeneral.getContentPane().add(itemComboBox);
		itemComboBox.setSelectedIndex(-1);
		
		JTextArea generalStoreItemsTextArea = new JTextArea();
		generalStoreItemsTextArea.setBackground(SystemColor.window);
		generalStoreItemsTextArea.setBounds(121, 192, 138, 481);
		frmFarmSimulatorGeneral.getContentPane().add(generalStoreItemsTextArea);
		generalStoreItemsTextArea.setText(generalStoreDisplays.getGeneralStoreItems());
		
		JTextArea generalStorePricesTextArea = new JTextArea();
		generalStorePricesTextArea.setBackground(SystemColor.window);
		generalStorePricesTextArea.setBounds(271, 192, 199, 481);
		frmFarmSimulatorGeneral.getContentPane().add(generalStorePricesTextArea);
		generalStorePricesTextArea.setText(generalStoreDisplays.getGeneralStorePrices());
		
		JTextArea sellingPricesTextArea = new JTextArea();
		sellingPricesTextArea.setBackground(SystemColor.window);
		 sellingPricesTextArea.setBounds(482, 287, 252, 176);
		frmFarmSimulatorGeneral.getContentPane().add( sellingPricesTextArea);
		 sellingPricesTextArea.setText(generalStoreDisplays.getGeneralStoreSellingPrices());
		
		JTextArea benefitsTextArea = new JTextArea();
		benefitsTextArea.setBackground(SystemColor.window);
		benefitsTextArea.setBounds(482, 475, 471, 196);
		frmFarmSimulatorGeneral.getContentPane().add(benefitsTextArea);
		benefitsTextArea.setText(generalStoreDisplays.getGeneralStoreBenefits());
		
		JTextArea growingTimeTextArea = new JTextArea();
		growingTimeTextArea.setBackground(SystemColor.window);
		growingTimeTextArea.setBounds(873, 287, 368, 176);
		frmFarmSimulatorGeneral.getContentPane().add(growingTimeTextArea);
		growingTimeTextArea.setText(generalStoreDisplays.getGeneralStoreGrowingTimes());
		
		JButton purchaseCropButton = new JButton("Purchase Crop");
		purchaseCropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cropPurchase = (String) cropComboBox.getSelectedItem();
				generalStore.setItem(cropPurchase);
				preGame.getSelectedFarm().getFarmCropsInventory().add(cropPurchase);
				generalStore.purchaseCrop();
				double farmMoney = Double.valueOf(preGame.getSelectedFarm().getFarmMoney());
				farmMoneyLabel.setText("Current Farm Money: $" + String.format("%.02f", farmMoney));
				cropComboBox.setSelectedIndex(-1);
			}
		});
		purchaseCropButton.setFont(new Font("Arial", Font.PLAIN, 18));
		purchaseCropButton.setBounds(266, 692, 171, 56);
		frmFarmSimulatorGeneral.getContentPane().add(purchaseCropButton);
		
		JButton purchaseItemButton = new JButton("Purchase Item");
		purchaseItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemPurchase = (String) itemComboBox.getSelectedItem();
				generalStore.setItem(itemPurchase);
				preGame.getSelectedFarm().getFarmItemsInventory().add(itemPurchase);
				generalStore.purchaseItem();
				double farmMoney = Double.valueOf(preGame.getSelectedFarm().getFarmMoney());
				farmMoneyLabel.setText("Current Farm Money: $" + String.format("%.02f", farmMoney));
				itemComboBox.setSelectedIndex(-1);
			}
		});
		purchaseItemButton.setFont(new Font("Arial", Font.PLAIN, 18));
		purchaseItemButton.setBounds(517, 693, 171, 54);
		frmFarmSimulatorGeneral.getContentPane().add(purchaseItemButton);
	}
	/**
	 * This method closes GeneralStoreScreen.
	 */
	public void closeWindow() {
		frmFarmSimulatorGeneral.dispose();
	}
	/**
	 * This method gives control back to the game manager.
	 */
	public void finishedWindow() {
		gameManager.closeGeneralStoreScreen(this);
	}
	/**
	 * This method closes GeneralStoreScreen.
	 */
	public void closeWindowToInventory() {
		frmFarmSimulatorGeneral.dispose();
	}

	/**
	 * This method gives control back to the game manager.
	 */
	public void finishedWindowToInventory() {
		gameManager.closeGeneralStoreScreenToInventory(this);
	}
}
