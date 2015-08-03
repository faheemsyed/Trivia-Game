/*Developed by: Faheem Syed and Marianna Sullivan
 * 
 * The TitleController class processes the code from the TitleScreen.fxml
 * It  declares a player1 and player 2 both of type Player (see Player class)
 * as well as a content variable of type Content (see Content class)
 * A playButton of type Button is also declared using FXML
 * When the playButton is pressed (on the TitelScreen) it calls the play function
 */

package controller;

import java.io.IOException;

import application.Content;
import application.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class TitleController{
	public static Player player1;
	public static Player player2;
	public static Content content;
	@FXML
	private Button playButton;
	
	/* When playButton is clicked it initializes content, player1 and player2
	 * The scene then switches from TitleScreen to RulesScreen 
	 * passing the stage to the RulesController class
	 * 
	 * An IOExeption is thrown if the file is not found
	 */
	@FXML
	public void play(ActionEvent event){
		content = new Content();
		player1 = new Player();
		player2 = new Player();
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/application/RulesScreen.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage) playButton.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		}
		catch (IOException ioe){
	        System.out.println (ioe.toString());
	        System.out.println("Could not find file /application/RuleScreen.fxml");
		}
	}
}