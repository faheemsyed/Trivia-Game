/*Developed by: Faheem Syed and Marianna Sullivan
 * 
 * The RulesController class shows the RulesScreen
 * All the RulesScren does is show how to play the game
 * It has one Button variable named button which calls
 * play() when it's clicked
 *  
 */

package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RulesController{
	
	@FXML
	private Button button;
	
	/*The play( ) method changes the scene from RulesScreen
	 * to NameScreen which uses the NameController class.
	 * It throws an IOExeption if the file isn't found
	 */
 	@FXML
	public void play(ActionEvent event){
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/application/NameScreen.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage) button.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
			} 
		catch (IOException ioe) {
	        System.out.println (ioe.toString());
	        System.out.println("Could not find file /application/NameScreen.fxml");
			}
	}
}
