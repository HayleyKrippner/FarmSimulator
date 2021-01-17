package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This class implements the methods for the MainScreen in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class MainScreen {

	/**
	 * Frame for farm simulator MainScreen.
	 */
	private JFrame frmFarmSimulatorMain;
	/**
	 * The GameManager in farm simulator.
	 */
	private GameManager gameManager;
	/**
	 * The PreGame in farm simulator.
	 */
	private PreGame preGame;

	/**
	 * Create the application
	 * @param gameManager The GameManager in farm simulator.
	 * @param preGame The PreGame in farm simulator.
	 */
	public MainScreen(GameManager gameManager, PreGame preGame) {
		this.gameManager = gameManager;
		this.preGame = gameManager.getPreGame();
		initialize();
		frmFarmSimulatorMain.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFarmSimulatorMain = new JFrame();
		frmFarmSimulatorMain.setTitle("Farm Simulator Main Screen");
		frmFarmSimulatorMain.setBounds(100, 100, 1280, 800);
		frmFarmSimulatorMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFarmSimulatorMain.getContentPane().setLayout(null);
		
		JTextArea farmDetailsTextArea = new JTextArea();
		farmDetailsTextArea.setBackground(SystemColor.window);
		farmDetailsTextArea.setFont(new Font("Arial", Font.PLAIN, 28));
		farmDetailsTextArea.setEditable(false);
		farmDetailsTextArea.setBounds(19, 17, 1215, 430);
		frmFarmSimulatorMain.getContentPane().add(farmDetailsTextArea);
		farmDetailsTextArea.setText(preGame.getSelectedFarm().toString());
		
		JButton visitFarmButton = new JButton("Visit Farm");
		visitFarmButton.setFont(new Font("Arial", Font.PLAIN, 20));
		visitFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindowToFarm();
			}
		});
		visitFarmButton.setBounds(123, 658, 216, 56);
		frmFarmSimulatorMain.getContentPane().add(visitFarmButton);
		
		JButton visitGeneralStoreButton = new JButton("Visit General Store");
		visitGeneralStoreButton.setFont(new Font("Arial", Font.PLAIN, 20));
		visitGeneralStoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindowToGeneralStore();
			}
		});
		visitGeneralStoreButton.setBounds(525, 658, 216, 56);
		frmFarmSimulatorMain.getContentPane().add(visitGeneralStoreButton);
		
		JButton nextDayButton = new JButton("Next Day");
		nextDayButton.setFont(new Font("Arial", Font.PLAIN, 20));
		nextDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preGame.getSelectedFarm().getCurrentDay() == preGame.getSelectedFarm().getGameDuration()) {
					preGame.getSelectedFarm().calculateTotalProfit();
					preGame.getSelectedFarm().calculateFinalScore();
					finishedWindow();
				} else {
					preGame.getSelectedFarm().nextDay();
					farmDetailsTextArea.setText(preGame.getSelectedFarm().toString());
				}
			}
		});
		nextDayButton.setBounds(952, 658, 216, 56);
		frmFarmSimulatorMain.getContentPane().add(nextDayButton);
	}
	/**
	 * This method closes the MainScreen.
	 */
	public void closeWindowToGeneralStore() {
		frmFarmSimulatorMain.dispose();
	}
	/**
	 * This method gives control back to the game manager.
	 */
	public void finishedWindowToGeneralStore() {
		gameManager.closeMainScreenToGeneralStore(this);
	}
	/**
	 * This method closes the MainScreen.
	 */
	public void closeWindowFarm() {
		frmFarmSimulatorMain.dispose();
	}
	/**
	 * This method gives control back to the game manager.
	 */
	public void finishedWindowToFarm() {
		gameManager.closeMainScreenToFarm(this);
	}
	/**
	 * This method closes the MainScreen.
	 */
	public void closeWindow() {
		frmFarmSimulatorMain.dispose();
	}
	/**
	 * This method gives control back to the game manager.
	 */
	public void finishedWindow() {
		gameManager.closeMainScreen(this);
	}

}
