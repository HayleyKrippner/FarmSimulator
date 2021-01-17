package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This class implements all the methods for the GameRulesScreen in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class GameRulesScreen {

	/**
	 * Frame for farm simulator GameRulesScreen.
	 */
	private JFrame frmFarmSimulatorRules;
	/**
	 * The GameManager in farm simulator
	 */
	private GameManager gameManager;
	/**
	 * The GameRules in farm simulator
	 */
	private GameRules gameRules;

	/**
	 * Create the application.
	 * @param gameManager The GameManager in farm simulator.
	 * @param gameRules The GameRules in farm simulator.
	 */
	public GameRulesScreen(GameManager gameManager, GameRules gameRules) {
		this.gameManager = gameManager;
		this.gameRules = gameManager.getGameRules();
		initialize();
		frmFarmSimulatorRules.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFarmSimulatorRules = new JFrame();
		frmFarmSimulatorRules.setTitle("Farm Simulator Rules");
		frmFarmSimulatorRules.setBounds(100, 100, 1280, 800);
		frmFarmSimulatorRules.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFarmSimulatorRules.getContentPane().setLayout(null);
		
		JLabel gameRulesLabel = new JLabel(gameRules.getGameRulesTitle());
		gameRulesLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		gameRulesLabel.setBounds(425, 6, 425, 64);
		frmFarmSimulatorRules.getContentPane().add(gameRulesLabel);
		
		JTextArea gameRulesTextArea = new JTextArea();
		gameRulesTextArea.setBackground(SystemColor.window);
		gameRulesTextArea.setFont(new Font("Arial", Font.PLAIN, 28));
		gameRulesTextArea.setEditable(false);
		gameRulesTextArea.setText(gameRules.getGameRules());
		gameRulesTextArea.setBounds(40, 93, 1199, 502);
		frmFarmSimulatorRules.getContentPane().add(gameRulesTextArea);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 24));
		btnNewButton.setBounds(961, 675, 278, 70);
		frmFarmSimulatorRules.getContentPane().add(btnNewButton);
	}
	/**
	 * This method closes the GameRulesScreen.
	 */
	public void closeWindow() {
		frmFarmSimulatorRules.dispose();
	}

	/**
	 * This method gives control back to the game manager.
	 */
	public void finishedWindow() {
		gameManager.closeGameRulesScreen(this);
	}
}
