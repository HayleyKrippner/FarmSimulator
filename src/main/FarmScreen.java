package main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import generalStore.GeneralStore;
import generalStore.ItemsActionManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * This class implements the methods for the FarmScreen in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class FarmScreen {

	/**
	 * Frame for farm simulator EndGameScreen.
	 */
	private JFrame frmFarmSimulatorFarm;
	/**
	 * The GameManager in the farm simulator.
	 */
	private GameManager gameManager;
	/**
	 * The PreGame in the farm simulator.
	 */
	private PreGame preGame;
	/**
	 * The GeneralStore in the farm simulator.
	 */
	private GeneralStore generalStore;
	/**
	 * The text area for showing the farm status.
	 */
	private JTextArea statusTextArea;
	/**
	 * The ItemsActionManager in farm simulator.
	 */
	private ItemsActionManager itemsActionManager;
	/**
	 * The label to display farm money when deductions and increaments are made.
	 */
	private JLabel farmMoneyLabel;
	/**
	 * The label to display farm actions remaining when actions are completed.
	 */
	private JLabel remainingActionsLabel;

	/**
	 * Create the application.
	 * @param gameManager The gameManager in farm simulator.
	 * @param preGame The preGame in farm simulator.
	 * @param generalStore The generalStore in farm simulator.
	 * @param itemsActionManager The itemsActionManager in farm simulator.
	 */
	public FarmScreen(GameManager gameManager, PreGame preGame, GeneralStore generalStore, ItemsActionManager itemsActionManager) {
		this.gameManager = gameManager;
		this.preGame = gameManager.getPreGame();
		this.generalStore = gameManager.getGeneralStore();
		this.itemsActionManager = gameManager.getItemsActionManager();
		initialize();
		frmFarmSimulatorFarm.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFarmSimulatorFarm = new JFrame();
		frmFarmSimulatorFarm.setTitle("Farm Simulator Farm");
		frmFarmSimulatorFarm.setBounds(100, 100, 1280, 800);
		frmFarmSimulatorFarm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFarmSimulatorFarm.getContentPane().setLayout(null);
		
		JButton mainMenuButton = new JButton("Main Menu");
		mainMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		mainMenuButton.setFont(new Font("Arial", Font.PLAIN, 22));
		mainMenuButton.setBounds(1031, 692, 227, 62);
		frmFarmSimulatorFarm.getContentPane().add(mainMenuButton);
	
		JComboBox selectCropComboBox = new JComboBox(generalStore.displayFarmCrops());
		selectCropComboBox.setBounds(497, 74, 247, 27);
		frmFarmSimulatorFarm.getContentPane().add(selectCropComboBox);
		selectCropComboBox.setSelectedIndex(-1);
		
		JButton viewCropStatusButton = new JButton("View Crop Status");
		viewCropStatusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedCrop = selectCropComboBox.getSelectedIndex();
				String cropType = (String) selectCropComboBox.getSelectedItem();
				int timeUntilHarvest = preGame.getSelectedFarm().getFarmCropsArray().get(selectedCrop).getTimeUntilHarvest();
				int waterLevel = preGame.getSelectedFarm().getFarmCropsArray().get(selectedCrop).getWaterLevel();
				statusTextArea.setText("Crop Type: " + cropType + "\n" + "\n" + "Time Until Harvest: " + timeUntilHarvest + "\n" + "\n" + "Water Level: " + waterLevel);
				selectCropComboBox.setSelectedIndex(-1);
			}
		});
		viewCropStatusButton.setFont(new Font("Arial", Font.PLAIN, 22));
		viewCropStatusButton.setBounds(169, 138, 247, 69);
		frmFarmSimulatorFarm.getContentPane().add(viewCropStatusButton);
		
		JButton waterButton = new JButton("Water");
		waterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedCrop = selectCropComboBox.getSelectedIndex();
				if (preGame.getSelectedFarm().getFarmCropsArray().get(selectedCrop).getWaterLevel() < 100) {
					preGame.getSelectedFarm().getFarmCropsArray().get(selectedCrop).hydrate();
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Crop has been watered");
				} else {
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Crop has enough water");
				}
				selectCropComboBox.setSelectedIndex(-1);
			}
		});
		waterButton.setFont(new Font("Arial", Font.PLAIN, 22));
		waterButton.setBounds(503, 138, 241, 69);
		frmFarmSimulatorFarm.getContentPane().add(waterButton);
		
		JButton harvestButton = new JButton("Harvest");
		harvestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preGame.getSelectedFarm().getNumOfActions() > 0) {
					int selectedCrop = selectCropComboBox.getSelectedIndex();
					if (preGame.getSelectedFarm().getFarmCropsArray().get(selectedCrop).getTimeUntilHarvest() == 0) {
						double sellingPrice = preGame.getSelectedFarm().getFarmCropsArray().get(selectedCrop).getSellingPrice();
						double currentMoney = preGame.getSelectedFarm().getFarmMoney();
						currentMoney += sellingPrice;
						preGame.getSelectedFarm().setFarmMoney(currentMoney);
						preGame.getSelectedFarm().reduceNumofActions();
						JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Crop has been harvested.");
						preGame.getSelectedFarm().getFarmCropsArray().remove(selectedCrop);
						preGame.getSelectedFarm().getFarmCropsInventory().remove(selectedCrop);
					} else {
						JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Crop cannot yet be harvested.");
					}
				} else {
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You're out of actions. Skip to next day or perform free action");
				}
				selectCropComboBox.setSelectedIndex(-1);
				double farmMoney = Double.valueOf(preGame.getSelectedFarm().getFarmMoney());
				farmMoneyLabel.setText("Current Farm Money: $" + String.format("%.02f", farmMoney));
				String daysRemaining = String.valueOf(preGame.getSelectedFarm().getNumOfActions());
				remainingActionsLabel.setText("Action Remaining: " + daysRemaining);
			}
		});
		harvestButton.setFont(new Font("Arial", Font.PLAIN, 22));
		harvestButton.setBounds(169, 267, 247, 69);
		frmFarmSimulatorFarm.getContentPane().add(harvestButton);
		
		JButton cleanLandButton = new JButton("Clean Land");
		cleanLandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preGame.getSelectedFarm().getNumOfActions() > 0) {
					preGame.getSelectedFarm().cleanLand();
					preGame.getSelectedFarm().reduceNumofActions();
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Land has been cleaned");
				} else {
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You're out of actions. Skip to next day or perform free action");
				}
				double farmMoney = Double.valueOf(preGame.getSelectedFarm().getFarmMoney());
				farmMoneyLabel.setText("Current Farm Money: $" + String.format("%.02f", farmMoney));
				String daysRemaining = String.valueOf(preGame.getSelectedFarm().getNumOfActions());
				remainingActionsLabel.setText("Action Remaining: " + daysRemaining);
			}
		});
		cleanLandButton.setFont(new Font("Arial", Font.PLAIN, 22));
		cleanLandButton.setBounds(169, 390, 247, 69);
		frmFarmSimulatorFarm.getContentPane().add(cleanLandButton);
		
		JComboBox selectAnimalBox = new JComboBox(generalStore.displayFarmAnimals());
		selectAnimalBox.setBounds(819, 74, 247, 27);
		frmFarmSimulatorFarm.getContentPane().add(selectAnimalBox);
		selectAnimalBox.setSelectedIndex(-1);
		
		JButton playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedAnimal = selectAnimalBox.getSelectedIndex();
				if (preGame.getSelectedFarm().getFarmAnimalsArray().get(selectedAnimal).getHappiness() < 100) {
					preGame.getSelectedFarm().getFarmAnimalsArray().get(selectedAnimal).play();
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You have just played with an animal");
				} else {
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Animal is at max happiness");
				}
				selectCropComboBox.setSelectedIndex(-1);
				selectAnimalBox.setSelectedIndex(-1);
			}
		});
		playButton.setFont(new Font("Arial", Font.PLAIN, 22));
		playButton.setBounds(825, 138, 241, 69);
		frmFarmSimulatorFarm.getContentPane().add(playButton);
		
		JButton viewAnimalStatusButton = new JButton("View Animal Status");
		viewAnimalStatusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedAnimal = selectAnimalBox.getSelectedIndex();
				String animalType = (String) selectAnimalBox.getSelectedItem();
				int happiness = preGame.getSelectedFarm().getFarmAnimalsArray().get(selectedAnimal).getHappiness();
				int health = preGame.getSelectedFarm().getFarmAnimalsArray().get(selectedAnimal).getHealth();
				statusTextArea.setText("Animal Type: " + animalType + "\n" + "\n" + "Animal Happiness: " + happiness + "\n" + "\n" + "Animal Health: " + health);
				selectCropComboBox.setSelectedIndex(-1);
				selectAnimalBox.setSelectedIndex(-1);
			}
		});
		viewAnimalStatusButton.setFont(new Font("Arial", Font.PLAIN, 22));
		viewAnimalStatusButton.setBounds(825, 267, 247, 69);
		frmFarmSimulatorFarm.getContentPane().add(viewAnimalStatusButton);
		
		statusTextArea = new JTextArea();
		statusTextArea.setBackground(SystemColor.window);
		statusTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
		statusTextArea.setBounds(503, 625, 247, 129);
		frmFarmSimulatorFarm.getContentPane().add(statusTextArea);
		
		JButton useTractorButton = new JButton("Use Tractor");
		useTractorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preGame.getSelectedFarm().getNumOfActions() > 0) {
					if (preGame.getSelectedFarm().getFarmItemsInventory().contains("Tractor") == true) {
						itemsActionManager.useTractor();
						int itemToBeRemoved = preGame.getSelectedFarm().getFarmItemsInventory().indexOf("Tractor");
						preGame.getSelectedFarm().getFarmItemsArray().remove(itemToBeRemoved);
						preGame.getSelectedFarm().getFarmItemsInventory().remove("Tractor");
						JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Tractor has been used");
					} else {
						JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You have no tractors to use.");
					}
				} else {
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You're out of actions. Skip to next day or perform free action");
				}
				selectCropComboBox.setSelectedIndex(-1);
				selectAnimalBox.setSelectedIndex(-1);
				double farmMoney = Double.valueOf(preGame.getSelectedFarm().getFarmMoney());
				farmMoneyLabel.setText("Current Farm Money: $" + String.format("%.02f", farmMoney));
				String daysRemaining = String.valueOf(preGame.getSelectedFarm().getNumOfActions());
				remainingActionsLabel.setText("Action Remaining: " + daysRemaining);
			}
		});
		useTractorButton.setFont(new Font("Arial", Font.PLAIN, 22));
		useTractorButton.setBounds(825, 390, 247, 69);
		frmFarmSimulatorFarm.getContentPane().add(useTractorButton);
		
		JButton animalFeedButton = new JButton("Feed Animal");
		animalFeedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preGame.getSelectedFarm().getNumOfActions() > 0) {
					if (preGame.getSelectedFarm().getFarmItemsInventory().contains("Animal Feed") == true) {
						int animalInt = selectAnimalBox.getSelectedIndex();
						if (preGame.getSelectedFarm().getFarmAnimalsArray().get(animalInt).getHealth() < 100) {
							itemsActionManager.setAnimalInt(animalInt);
							itemsActionManager.useAnimalFeed();
							int itemToBeRemoved = preGame.getSelectedFarm().getFarmItemsInventory().indexOf("Animal Feed");
							preGame.getSelectedFarm().getFarmItemsArray().remove(itemToBeRemoved);
							preGame.getSelectedFarm().getFarmItemsInventory().remove("Animal Feed");
							JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Animal has been fed");
						} else {
							JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Animal is at max health");
						}
					} else {
						JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You have no animal feed.");
					}
				} else {
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You're out of actions. Skip to next day or perform free action");
				}
				selectCropComboBox.setSelectedIndex(-1);
				selectAnimalBox.setSelectedIndex(-1);
				String daysRemaining = String.valueOf(preGame.getSelectedFarm().getNumOfActions());
				remainingActionsLabel.setText("Action Remaining: " + daysRemaining);
			}
		});
		animalFeedButton.setFont(new Font("Arial", Font.PLAIN, 22));
		animalFeedButton.setBounds(503, 267, 241, 69);
		frmFarmSimulatorFarm.getContentPane().add(animalFeedButton);
		
		JLabel selectCropLabel = new JLabel("Select Crop");
		selectCropLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		selectCropLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectCropLabel.setBounds(503, 29, 241, 33);
		frmFarmSimulatorFarm.getContentPane().add(selectCropLabel);
		
		JLabel selectAnimalLabel = new JLabel("Select Animal");
		selectAnimalLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		selectAnimalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectAnimalLabel.setBounds(819, 28, 247, 33);
		frmFarmSimulatorFarm.getContentPane().add(selectAnimalLabel);
		
		JButton useAnimalTreatButton = new JButton("Use Animal Treat");
		useAnimalTreatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preGame.getSelectedFarm().getNumOfActions() > 0) {
					if (preGame.getSelectedFarm().getFarmItemsInventory().contains("Animal Treat") == true) {
						int animalInt = selectAnimalBox.getSelectedIndex();
						if (preGame.getSelectedFarm().getFarmAnimalsArray().get(animalInt).getHappiness() < 100) {
							itemsActionManager.setAnimalInt(animalInt);
							itemsActionManager.useAnimalFeed();
							int itemToBeRemoved = preGame.getSelectedFarm().getFarmItemsInventory().indexOf("Animal Treat");
							preGame.getSelectedFarm().getFarmItemsArray().remove(itemToBeRemoved);
							preGame.getSelectedFarm().getFarmItemsInventory().remove("Animal Treat");
							JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Animal has been given a treat");
						} else {
							JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Animal is at max happiness");
						}
					} else {
						JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You have no animal treats.");
					}
				} else {
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You're out of actions. Skip to next day or perform free action");
				}
				selectCropComboBox.setSelectedIndex(-1);
				selectAnimalBox.setSelectedIndex(-1);
				String daysRemaining = String.valueOf(preGame.getSelectedFarm().getNumOfActions());
				remainingActionsLabel.setText("Action Remaining: " + daysRemaining);
			}
		});
		useAnimalTreatButton.setFont(new Font("Arial", Font.PLAIN, 22));
		useAnimalTreatButton.setBounds(503, 390, 241, 69);
		frmFarmSimulatorFarm.getContentPane().add(useAnimalTreatButton);
		
		JButton useGrowthFertiliser = new JButton("Use Growth Fertiliser");
		useGrowthFertiliser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preGame.getSelectedFarm().getNumOfActions() > 0) {
					if (preGame.getSelectedFarm().getFarmItemsInventory().contains("Growth Fertiliser") == true) {
						int cropInt = selectCropComboBox.getSelectedIndex();
						if (preGame.getSelectedFarm().getFarmCropsArray().get(cropInt).getTimeUntilHarvest() > 0) {
							itemsActionManager.setCropInt(cropInt);
							itemsActionManager.useGrowthFertiliser();
							int itemToBeRemoved = preGame.getSelectedFarm().getFarmItemsInventory().indexOf("Growth Fertiliser");
							preGame.getSelectedFarm().getFarmItemsArray().remove(itemToBeRemoved);
							preGame.getSelectedFarm().getFarmItemsInventory().remove("Growth Fertiliser");
							JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Growth Fertiliser has been used");
						} else {
							JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Crop is already ready to harvest");
						}
					} else {
						JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You have no growth fertiliser.");
					}
				} else {
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You're out of actions. Skip to next day or perform free action");
				}
				selectCropComboBox.setSelectedIndex(-1);
				selectAnimalBox.setSelectedIndex(-1);
				String daysRemaining = String.valueOf(preGame.getSelectedFarm().getNumOfActions());
				remainingActionsLabel.setText("Action Remaining: " + daysRemaining);
			}
		});
		useGrowthFertiliser.setFont(new Font("Arial", Font.PLAIN, 22));
		useGrowthFertiliser.setBounds(169, 505, 241, 69);
		frmFarmSimulatorFarm.getContentPane().add(useGrowthFertiliser);
		
		JButton profitFertiliserButton = new JButton("Use Profit Fertiliser");
		profitFertiliserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preGame.getSelectedFarm().getNumOfActions() > 0) {
					if (preGame.getSelectedFarm().getFarmItemsInventory().contains("Profit Fertiliser") == true) {
						int cropInt = selectCropComboBox.getSelectedIndex();
						itemsActionManager.setCropInt(cropInt);
						itemsActionManager.useProfitFertiliser();
						int itemToBeRemoved = preGame.getSelectedFarm().getFarmItemsInventory().indexOf("Profit Fertiliser");
						preGame.getSelectedFarm().getFarmItemsArray().remove(itemToBeRemoved);
						preGame.getSelectedFarm().getFarmItemsInventory().remove("Profit Fertiliser");
						JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Profit Fertiliser has been used");
						}  else {
						JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You have no profit fertiliser.");
					}
				} else {
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You're out of actions. Skip to next day or perform free action");
				}
				selectCropComboBox.setSelectedIndex(-1);
				selectAnimalBox.setSelectedIndex(-1);
				String daysRemaining = String.valueOf(preGame.getSelectedFarm().getNumOfActions());
				remainingActionsLabel.setText("Action Remaining: " + daysRemaining);
			}
		});
		profitFertiliserButton.setFont(new Font("Arial", Font.PLAIN, 22));
		profitFertiliserButton.setBounds(503, 505, 241, 62);
		frmFarmSimulatorFarm.getContentPane().add(profitFertiliserButton);
		
		JButton useShovelButton = new JButton("Use Shovel");
		useShovelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preGame.getSelectedFarm().getNumOfActions() > 0) {
					if (preGame.getSelectedFarm().getFarmItemsInventory().contains("Shovel") == true) {
						int cropInt = selectCropComboBox.getSelectedIndex();
						if (preGame.getSelectedFarm().getFarmCropsArray().get(cropInt).getTimeUntilHarvest() > 0) {
							itemsActionManager.setCropInt(cropInt);
							itemsActionManager.useShovel();
							int itemToBeRemoved = preGame.getSelectedFarm().getFarmItemsInventory().indexOf("Shovel");
							preGame.getSelectedFarm().getFarmItemsArray().remove(itemToBeRemoved);
							preGame.getSelectedFarm().getFarmItemsInventory().remove("Shovel");
							JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Shovel has been used");
						} else {
							JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "Crop is already ready to harvest");
						}
					} else {
						JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You have no shovel.");
					}
				} else {
					JOptionPane.showMessageDialog(frmFarmSimulatorFarm, "You're out of actions. Skip to next day or perform free action");
				}
				selectCropComboBox.setSelectedIndex(-1);
				selectAnimalBox.setSelectedIndex(-1);
				double farmMoney = Double.valueOf(preGame.getSelectedFarm().getFarmMoney());
				farmMoneyLabel.setText("Current Farm Money: $" + String.format("%.02f", farmMoney));
				String daysRemaining = String.valueOf(preGame.getSelectedFarm().getNumOfActions());
				remainingActionsLabel.setText("Action Remaining: " + daysRemaining);
			}
		});
		useShovelButton.setFont(new Font("Arial", Font.PLAIN, 22));
		useShovelButton.setBounds(825, 505, 241, 62);
		frmFarmSimulatorFarm.getContentPane().add(useShovelButton);
		
		farmMoneyLabel = new JLabel("New label");
		farmMoneyLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		farmMoneyLabel.setBounds(31, 29, 323, 39);
		frmFarmSimulatorFarm.getContentPane().add(farmMoneyLabel);
		double farmMoney = Double.valueOf(preGame.getSelectedFarm().getFarmMoney());
		farmMoneyLabel.setText("Current Farm Money: $" + String.format("%.02f", farmMoney));
		
		remainingActionsLabel = new JLabel("New label");
		remainingActionsLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		remainingActionsLabel.setBounds(31, 60, 323, 48);
		frmFarmSimulatorFarm.getContentPane().add(remainingActionsLabel);
		String daysRemaining = String.valueOf(preGame.getSelectedFarm().getNumOfActions());
		remainingActionsLabel.setText("Action Remaining: " + daysRemaining);
	}
	
	/**
	 * This method closes the FarmScreen.
	 */
	public void closeWindow() {
		frmFarmSimulatorFarm.dispose();
	}
	
	/**
	 * This method gives control back to the game manager.
	 */
	public void finishedWindow() {
		gameManager.closeFarmScreen(this);
	}
}
