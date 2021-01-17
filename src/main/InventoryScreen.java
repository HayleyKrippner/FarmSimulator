package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import generalStore.GeneralStore;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

/**
 * This class implements the methods for the InventoryScreen in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class InventoryScreen {

	/**
	 * Frame for farm simulator InventoryScreen.
	 */
	private JFrame frmFarmSimulatorInventory;
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
	 * ComboBox for viewing animals in inventory.
	 */
	private JComboBox<String> animalInventory;
	/**
	 * ComboBox for viewing crops in inventory.
	 */
	private JComboBox<String> cropInventory;
	/**
	 * ComboBox for viewing items in inventory.
	 */
	private JComboBox<String> itemsInventory;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Create the application.
	 * @param gameManager The Game Manager in farm simulator.
	 * @param preGame The PreGame in farm simulator.
	 * @param generalStore The GeneralStore.
	 */
	public InventoryScreen(GameManager gameManager, PreGame preGame, GeneralStore generalStore) {
		this.gameManager = gameManager;
		this.preGame = gameManager.getPreGame();
		this.generalStore = gameManager.getGeneralStore();
		initialize();
		frmFarmSimulatorInventory.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFarmSimulatorInventory = new JFrame();
		frmFarmSimulatorInventory.setTitle("Farm Simulator Inventory");
		frmFarmSimulatorInventory.setBounds(100, 100, 1280, 800);
		frmFarmSimulatorInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFarmSimulatorInventory.getContentPane().setLayout(null);
		
		JButton generalStoreButton = new JButton("General Store");
		generalStoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		generalStoreButton.setBounds(1043, 692, 188, 59);
		frmFarmSimulatorInventory.getContentPane().add(generalStoreButton);
		
		animalInventory = new JComboBox(generalStore.displayFarmAnimals());
		animalInventory.setBounds(34, 78, 238, 27);
		frmFarmSimulatorInventory.getContentPane().add(animalInventory);
		
		cropInventory = new JComboBox(generalStore.displayFarmCrops());
		cropInventory.setBounds(428, 78, 263, 27);
		frmFarmSimulatorInventory.getContentPane().add(cropInventory);
		
		itemsInventory = new JComboBox(generalStore.displayFarmItems());
		itemsInventory.setBounds(862, 78, 283, 27);
		frmFarmSimulatorInventory.getContentPane().add(itemsInventory);
		
		lblNewLabel = new JLabel("View Animals Inventory");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(34, 39, 227, 27);
		frmFarmSimulatorInventory.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("View Crops Inventory");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(428, 39, 263, 23);
		frmFarmSimulatorInventory.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("View Items Inventory");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(862, 39, 283, 27);
		frmFarmSimulatorInventory.getContentPane().add(lblNewLabel_2);
	}
	
	/**
	 * This method closes the InventoryScreen.
	 */
	public void closeWindow() {
		frmFarmSimulatorInventory.dispose();
	}
	/**
	 * This method gives control back to the game manager.
	 */
	public void finishedWindow() {
		gameManager.closeInventoryScreen(this);
	}

}
