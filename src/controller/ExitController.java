/*Developed by: Faheem Syed and Marianna Sullivan
 * 
 * ExitController declares the winner
 * along with the final stats comparable side by side.
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

public class ExitController implements Initializable{
	@FXML
	private Label winner, player1Label, player2Label, score1, score2, wrong1, wrong2, total1, total2, percent1, percent2;
	@FXML
	private Button playBtn, exitBtn;
	
	/*
	 * initialize method sets the name, score, wrong answers, 
	 * total questions answered and percentage correct of each player.
	 * The Label "winner" is then changed to the name of the player who won
	 * or if its a tie.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		player1Label.setText(TitleController.player1.getName());
		score1.setText("Score/Correct Answers: " + TitleController.player1.getScore());
		wrong1.setText("Wrong Answers: " + TitleController.player1.getWrong());
		total1.setText("Total questions answered: " + TitleController.player1.getTotal());
		percent1.setText("Percentage correct: " + TitleController.player1.getPercent());
		
		player2Label.setText(TitleController.player2.getName());	
		score2.setText("Score/Correct Answers: " + TitleController.player2.getScore());
		wrong2.setText("Wrong Answers: " + TitleController.player2.getWrong());
		total2.setText("Total questions answered: " + TitleController.player2.getTotal());
		percent2.setText("Percentage correct: " + TitleController.player2.getPercent());
		
		if(TitleController.player1.getScore() > TitleController.player2.getScore()){
			winner.setText(TitleController.player1.getName() + " wins!");
		}
		else if(TitleController.player1.getScore() < TitleController.player2.getScore()){
			winner.setText(TitleController.player2.getName() + " wins!");
		}
		else {
			winner.setText("Its a tie!!");
		}
	}
	
	/*
	 * If the playBtn is clicked play() sents the scene back to TitleScreen
	 * and starts everything over.
	 */
	@FXML
	public void play(){
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/application/TitleScreen.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage) playBtn.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		}
		catch (IOException ioe){
	        System.out.println (ioe.toString());
	        System.out.println("Could not find file /application/ExitScreen.fxml");
		}
	}
	
	/*
	 * If the exitBtn is clicked exit() closes the stage ending the game.
	 */
	@FXML
	public void exit(){
		Stage stage = (Stage) exitBtn.getScene().getWindow();
		stage.close();
	}
	
	
}
