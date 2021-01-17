package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class implements the methods for the PreGameScreen in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class PreGameScreen {

	/**
	 * Frame for farm simulator PreGameScreen.
	 */
	private JFrame frmFarmSimulatorSetup;
	/**
	 * The PreGame in farm simulator.
	 */
	private PreGame preGame;
	/**
	 * The GameManager in farm simulator.
	 */
	private GameManager gameManager;
	/**
	 * ComboBox for getting farmer age.
	 */
	private JComboBox<String> farmerAgeComboBox;
	/**
	 * ComboBox for getting game duration.
	 */
	private JComboBox<String> gameDurationComboBox;
	/**
	 * ComboBox for getting farm type.
	 */
	private JComboBox<String> farmTypeComboBox;

	/**
	 * Create the application
	 * @param gameManager The GameManager in farm simulator.
	 * @param preGame The PreGame in farm simulator.
	 */
	public PreGameScreen(GameManager gameManager, PreGame preGame) {
		this.gameManager = gameManager;
		this.preGame = gameManager.getPreGame();
		initialize();
		frmFarmSimulatorSetup.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFarmSimulatorSetup = new JFrame();
		frmFarmSimulatorSetup.setTitle("Farm Simulator Setup");
		frmFarmSimulatorSetup.setBounds(100, 100, 1280, 800);
		frmFarmSimulatorSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFarmSimulatorSetup.getContentPane().setLayout(null);
		
		JLabel greetUserLabel = new JLabel("");
		greetUserLabel.setFont(new Font("Arial", Font.BOLD, 40));
		greetUserLabel.setBounds(369, 6, 558, 55);
		frmFarmSimulatorSetup.getContentPane().add(greetUserLabel);
		greetUserLabel.setText(preGame.greetUser());
		
		JLabel askFarmerNameLabel = new JLabel("");
		askFarmerNameLabel.setFont(new Font("Arial", Font.PLAIN, 28));
		askFarmerNameLabel.setBounds(17, 99, 311, 42);
		frmFarmSimulatorSetup.getContentPane().add(askFarmerNameLabel);
		askFarmerNameLabel.setText(preGame.askFarmerName());
		
		JLabel askFarmNameLabel = new JLabel("");
		askFarmNameLabel.setFont(new Font("Arial", Font.PLAIN, 28));
		askFarmNameLabel.setBounds(17, 153, 558, 42);
		frmFarmSimulatorSetup.getContentPane().add(askFarmNameLabel);
		askFarmNameLabel.setText(preGame.askFarmName());
		
		JLabel askFarmerAgeLabel = new JLabel("");
		askFarmerAgeLabel.setFont(new Font("Arial", Font.PLAIN, 28));
		askFarmerAgeLabel.setBounds(17, 207, 407, 42);
		frmFarmSimulatorSetup.getContentPane().add(askFarmerAgeLabel);
		askFarmerAgeLabel.setText(preGame.askFarmerAge());
		
		JLabel askGameDurationLabel = new JLabel("");
		askGameDurationLabel.setFont(new Font("Arial", Font.PLAIN, 28));
		askGameDurationLabel.setBounds(17, 261, 558, 42);
		frmFarmSimulatorSetup.getContentPane().add(askGameDurationLabel);
		askGameDurationLabel.setText(preGame.askGameDuration());
		
		JLabel askFarmTypeLabel = new JLabel("");
		askFarmTypeLabel.setFont(new Font("Arial", Font.PLAIN, 28));
		askFarmTypeLabel.setBounds(17, 315, 311, 42);
		frmFarmSimulatorSetup.getContentPane().add(askFarmTypeLabel);
		askFarmTypeLabel.setText(preGame.askFarmType());
		
		JTextArea farmTypeTextArea = new JTextArea();
		farmTypeTextArea.setBackground(SystemColor.window);
		farmTypeTextArea.setEditable(false);
		farmTypeTextArea.setFont(new Font("Arial", Font.PLAIN, 28));
		farmTypeTextArea.setBounds(17, 369, 719, 288);
		frmFarmSimulatorSetup.getContentPane().add(farmTypeTextArea);
		farmTypeTextArea.setText(preGame.getFarmTypeInfo());
		
		JTextField farmerNameTextField = new JTextField();
		farmerNameTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		farmerNameTextField.setBounds(1092, 99, 169, 42);
		frmFarmSimulatorSetup.getContentPane().add(farmerNameTextField);
		farmerNameTextField.setColumns(10);
		
		JTextField farmNameTextField = new JTextField();
		farmNameTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		farmNameTextField.setBounds(1092, 153, 169, 42);
		frmFarmSimulatorSetup.getContentPane().add(farmNameTextField);
		farmNameTextField.setColumns(10);
		
		farmerAgeComboBox = new JComboBox(preGame.getFarmerAgeArray());
		farmerAgeComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		farmerAgeComboBox.setMaximumRowCount(10);
		farmerAgeComboBox.setBounds(1092, 207, 169, 42);
		frmFarmSimulatorSetup.getContentPane().add(farmerAgeComboBox);
		farmerAgeComboBox.setSelectedIndex(-1);
		
		gameDurationComboBox = new JComboBox(preGame.getGameDurationArray());
		gameDurationComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		gameDurationComboBox.setBounds(1092, 261, 169, 42);
		frmFarmSimulatorSetup.getContentPane().add(gameDurationComboBox);
		gameDurationComboBox.setSelectedIndex(-1);
		
		farmTypeComboBox = new JComboBox(preGame.getFarmTypeArray());
		farmTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		farmTypeComboBox.setBounds(1092, 315, 169, 42);
		frmFarmSimulatorSetup.getContentPane().add(farmTypeComboBox);
		farmTypeComboBox.setSelectedIndex(-1);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean isValidFarmerName = false;
				Boolean isValidFarmName = false;
				String farmerName = farmerNameTextField.getText();
				if (farmerName.matches("[a-zA-Z ]+") && farmerName.length() >= 3 && farmerName.length() <= 15) {
					isValidFarmerName = true;
				} else {
					JOptionPane.showMessageDialog(frmFarmSimulatorSetup, "Farmer name must only contain between 3 and 15 letters");
				}
				String farmName = farmNameTextField.getText();
				if (farmName.matches("[a-zA-Z ]+") && farmName.length() >= 3 && farmName.length() <= 15) {
					isValidFarmName = true;;
				} else {
					JOptionPane.showMessageDialog(frmFarmSimulatorSetup, "Farm name must only contain between 3 and 15 letters");
				}
				int gameDuration = Integer.parseInt((String) gameDurationComboBox.getSelectedItem());
				preGame.setGameDuration(gameDuration);
				int farmerAge = Integer.parseInt((String) farmerAgeComboBox.getSelectedItem());
				preGame.setFarmerAge(farmerAge);
				int farmType = Integer.parseInt((String) farmTypeComboBox.getSelectedItem());
				preGame.setFarmType(farmType);
				if (isValidFarmerName == true && isValidFarmName == true) {
					preGame.setFarmName(farmName);
					preGame.setFarmerName(farmerName);
					preGame.createFarmer();
					preGame.createFarm();
					finishedWindow();
				}
			}
		});
		nextButton.setFont(new Font("Arial", Font.PLAIN, 24));
		nextButton.setBounds(994, 690, 267, 65);
		frmFarmSimulatorSetup.getContentPane().add(nextButton);
	}
	/**
	 * This method closes PreGameScreen.
	 */
	public void closeWindow() {
		frmFarmSimulatorSetup.dispose();
	}
	/**
	 * This method gives control back to GameManager.
	 */
	public void finishedWindow() {
		gameManager.closePreGameScreen(this);
	}
}
