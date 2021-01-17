package main;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * This class implements the methods for the EndGameScreen in the farm simulator.
 * @author Hayley Krippner
 * @author Michelle Muchemwa
 * @version 22 May 2020.
 */
public class EndGameScreen {

	/**
	 * Frame for farm simulator EndGameScreen.
	 */
	private JFrame frmFarmSimulatorEnd;
	/**
	 * The PreGame in the farm simulator.
	 */
	private PreGame preGame;
	/**
	 * The GameManager in the farm simulator.
	 */
	private GameManager gameManager;


	/**
	 * Create the application.
	 * @param gameManager The gameManager in farm simulator.
	 * @param preGame The preGame in farm simulator.
	 */
	public EndGameScreen(GameManager gameManager, PreGame preGame) {
		this.gameManager = gameManager;
		this.preGame = gameManager.getPreGame();
		initialize();
		frmFarmSimulatorEnd.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFarmSimulatorEnd = new JFrame();
		frmFarmSimulatorEnd.setTitle("Farm Simulator End Game");
		frmFarmSimulatorEnd.setBounds(100, 100, 1280, 802);
		frmFarmSimulatorEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFarmSimulatorEnd.getContentPane().setLayout(null);
		
		JTextArea gameSummaryTextArea = new JTextArea();
		gameSummaryTextArea.setBackground(SystemColor.window);
		gameSummaryTextArea.setEditable(false);
		gameSummaryTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
		gameSummaryTextArea.setBounds(443, 245, 439, 247);
		frmFarmSimulatorEnd.getContentPane().add(gameSummaryTextArea);
		gameSummaryTextArea.setText(preGame.getSelectedFarm().toStringEndGameStats());
		
		JButton endGameButton = new JButton("End Game");
		endGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		endGameButton.setFont(new Font("Arial", Font.PLAIN, 20));
		endGameButton.setBounds(1027, 689, 216, 57);
		frmFarmSimulatorEnd.getContentPane().add(endGameButton);
		
		JLabel lblNewLabel = new JLabel("Game Summary");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(549, 182, 201, 38);
		frmFarmSimulatorEnd.getContentPane().add(lblNewLabel);
	}
	
	/**
	 * This method closes the EndGameScreen.
	 */
	public void closeWindow() {
		frmFarmSimulatorEnd.dispose();
	}
	
	/**
	 * This method gives control back to the game manager.
	 */
	public void finishedWindow() {
		gameManager.closeEndGameScreen(this);
	}
}
