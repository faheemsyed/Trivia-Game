/*Developed by: Faheem Syed and Marianna Sullivan
 * 
 * The GameController class is the main part of the game.
 * A timer starts immediately once the GameScreen is shown.
 * QAs are updated using the changeLabels() method.
 * after timer reaches 0 endRound() is called to change the screen
 * to either the end of round screen or the exit screen.
 */


package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class GameController implements Initializable{
	@FXML
	private Label timeLabel, name, question, score;
	@FXML
	private RadioButton answer1, answer2, answer3, answer4;
	@FXML 
	private Button enter;
	private String[] holder = new String[5];
	
	
	/*
	 * The initialize method checks to see if its player1s 
	 * turn or player2.
	 * It then starts a timer, changes the name on the screen
	 * to the current players name and initializes 
	 * a "holder" String array. 
	 * holder receives the question (in [0]) and the 
	 * answer with fake answers (held in [1-4])
	 * then changeLabels() is called.
	*/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (TitleController.player1.isTurn()){
			time();
			name.setText(TitleController.player1.getName());
			holder = TitleController.content.getQA();
			changeLabels();
			}
		else{
			time();
			name.setText(TitleController.player2.getName());
			holder = TitleController.content.getQA();
			changeLabels();
			}
		}
	
	/*
	 * selectAnswer1, 2, 3, and 4 are all ActionEvents.
	 * It simply turns all other selected answers to false
	 * after an answer is selected.
	 * This is to prevent multiple selections.
	*/
	@FXML
	public void selectAnswer1(ActionEvent event) {
		answer1.setSelected(true);
		answer2.setSelected(false);
		answer3.setSelected(false);
		answer4.setSelected(false);
	}
	@FXML
	public void selectAnswer2(ActionEvent event) {
		answer2.setSelected(true);
		answer1.setSelected(false);
		answer3.setSelected(false);
		answer4.setSelected(false);
	}
	@FXML
	public void selectAnswer3(ActionEvent event) {
		answer3.setSelected(true);
		answer1.setSelected(false);
		answer2.setSelected(false);
		answer4.setSelected(false);
	}
	@FXML
	public void selectAnswer4(ActionEvent event) {
		answer4.setSelected(true);
		answer1.setSelected(false);
		answer2.setSelected(false);
		answer3.setSelected(false);
	}
	
	/*
	 * checkAnswer() is called once enter is pressed.
	 * The selected answer is checked:
	 * 		if the answer is correct
	 * 			updateScore() is called
	 * 			changeLabels() is called
	 *		if the answer is incorrect
	 *			correctAns is called
	 * 
	 */
	@FXML
	public void checkAnswer(ActionEvent event) {
		if (answer1.isSelected()){
			if (TitleController.content.checkAns(1)){
				updateScore();
				changeLabels();
			}
			else {
				correctAns(1);
				
			}
		}
		
		else if (answer2.isSelected()){
			if (TitleController.content.checkAns(2)){
				updateScore();
				changeLabels();
			}
			else {
				correctAns(2);
			}
		}
		
		else if (answer3.isSelected()){
			if (TitleController.content.checkAns(3)){
				updateScore();
				changeLabels();
			}
			else {
				correctAns(3);
			}
		}
		
		else if (answer4.isSelected()){
			if (TitleController.content.checkAns(4)){
				updateScore();
				changeLabels();
			}
			else {
				correctAns(4);
			}
		}
		
		else{
		}
	}
	
	/*
	 * correctAns(int selectedAns) receives the selected answer.
	 * The selected (incorrect) answers text is then set to red.
	 * The correct answers text is set to green.
	 * IMPORTANT:
	 * 		if sleep() isn't called the color changes will 
	 * 		not be noticeable.
	 * updateWrong(), sleep() and changeLabels() are called
	 * in that order.
	 */
	private void correctAns(int selectedAns){
		if (selectedAns == 1){
			answer1.setTextFill(Paint.valueOf("Red"));
		}
		else if (selectedAns == 2){
			answer2.setTextFill(Paint.valueOf("Red"));
		}
		else if (selectedAns == 3){
			answer3.setTextFill(Paint.valueOf("Red"));
		}
		else {
			answer4.setTextFill(Paint.valueOf("Red"));
		}
		
		
		int correctAns = TitleController.content.getAns();
		if (correctAns == 1){
			answer1.setTextFill(Paint.valueOf("Green"));
		}
		else if (correctAns == 2){
			answer2.setTextFill(Paint.valueOf("Green"));
		}
		else if (correctAns == 3){
			answer3.setTextFill(Paint.valueOf("Green"));
		}
		else{
			answer4.setTextFill(Paint.valueOf("Green"));
		}
		
		updateWrong();
		//sleep();
		changeLabels();
	}

	/*
	 * updateScore adds 1 point to the current player.
	 * The "score" label is then set to the updated score.
	 */
	public void updateScore(){
		if(TitleController.player1.isTurn()){
			TitleController.player1.addScore();
			score.setText(Integer.toString(TitleController.player1.getScore()));
		}
		else{
			TitleController.player2.addScore();
			score.setText(Integer.toString(TitleController.player1.getScore()));
		}
	}
	
	/*
	 * updateWrong() is called to add 1 to the current
	 * players wrong answers.
	*/
	public void updateWrong(){
		if(TitleController.player1.isTurn()){
			TitleController.player1.addWrong();
		}
		else{
			TitleController.player2.addWrong();
		}
	}
	
	/*
	 * The changeLabels() method sets the question
	 * and answers.
	 * TitleController.content.getQA() is called to get
	 * new questions and answers (which are held in "holder".)
	 * Each RadioButton (answer1, answer2, answer3
	 * and answer4) is set to false to remove the 
	 * selected answer from the previous question.
	 * All the RadioButtons text color is also set to
	 * black because correctAns() sets any incorrect selected
	 * to red and the correct answer to green.
	*/
	private void changeLabels(){
		TitleController.content.getQA();
		
		question.setText(holder[0]);
		answer1.setText(holder[1]);
		answer2.setText(holder[2]);
		answer3.setText(holder[3]);
		answer4.setText(holder[4]);
		
		answer1.setSelected(false);
		answer2.setSelected(false);
		answer3.setSelected(false);
		answer4.setSelected(false);
		
		answer1.setTextFill(Paint.valueOf("Black"));
		answer2.setTextFill(Paint.valueOf("Black"));
		answer3.setTextFill(Paint.valueOf("Black"));
		answer4.setTextFill(Paint.valueOf("Black"));
	}
	
	/*
	 * endRound() method checks if its player1s turn or
	 * player2s. 
	 * If it's player1s turn player1 turn is set to false,
	 * then the scene is switched to EndOfRoundScreen.
	 * If it's player2s turn the scene is switched 
	 * to ExitScreen.
	 * 
	 * Each if else statement has a try catch block that 
	 * throws an IOException if the fxml file isn't found.
	*/
	private void endRound(){
		if (TitleController.player1.isTurn()){
			TitleController.player1.setTurn();
			try{
				Parent root = FXMLLoader.load(getClass().getResource("/application/EndOfRoundScreen.fxml"));
				Scene scene = new Scene(root);									   
				Stage stage = (Stage) enter.getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			}
			catch (IOException ioe){
		        System.out.println (ioe.toString());
		        System.out.println("Could not find file /application/EndOfRoundScreen.fxml");
			}
		}
		else{
			try{
				Parent root = FXMLLoader.load(getClass().getResource("/application/ExitScreen.fxml"));
				Scene scene = new Scene(root);
				Stage stage = (Stage) enter.getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			}
			catch (IOException ioe){
		        System.out.println (ioe.toString());
		        System.out.println("Could not find file /application/ExitScreen.fxml");
			}
		}
	}
	
	/*
	 * The time() method starts a new Timer.
	 * A variable "i" of type int is created (initialized to 30)
	 * After each second passes i is subtracted.
	 * if i is greater than or equal to 1
	 * it changes timeLabel (on the Game Screen) to i.
	 * if i is less than 1 timeLabel is set to 0 and
	 * the timer is stopped. 
	 * Then endRound() is called.
	*/
	public void time(){
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
				int i = 30;
				@Override
				public void run(){
					Platform.runLater(new Runnable() {
					@Override
					public void run(){
						if (i >= 1){
							timeLabel.setText(Integer.toString(i));
							i--;
						}
						else{
							timeLabel.setText("0");
							timer.purge();
							timer.cancel();
							endRound();
						}
						}
					});
				 }
			}, 1000, 1000);
				
	}
}
