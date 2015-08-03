/*Developed by: Faheem Syed and Marianna Sullivan
 * EndOfRoundController simply displays player1s stats.
 * There are only 2 methods, initialize and play.
 * 2 Labels, playerTurnLabel and scoreLabel, and 1
 * button playBtn.
 */

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class EndOfRoundController implements Initializable{
	@FXML
	private Label playerTurnLabel, scoreLabel;
	@FXML
	private Button playBtn;
	
	/*
	 * initialize sets the name and score of player1.
	 * playBtn is set to display player2s name.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		playerTurnLabel.setText("End of " + TitleController.player1.getName() + "s turn!");
		scoreLabel.setText("Score: " + TitleController.player1.getScore());
		playBtn.setText(TitleController.player2.getName() + "s turn");
	}
	
	
	/*
	 * After playBtn is clicked the scene is switched back to the GameScreen.
	 */
	@FXML
	public void play(){
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/application/GameScreen.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage) playBtn.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		}
		catch (IOException ioe){
	        System.out.println (ioe.toString());
	        System.out.println("Could not find file /application/EndOfRoundScreen.fxml");
		}
	}
	
}
