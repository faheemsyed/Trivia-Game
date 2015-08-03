/*Developed by: Faheem Syed and Marianna Sullivan
 * 
 * The NameController class allows each player to
 * enter their name.
 * Player names are added to player1 and player2
 * (declared in TitleController.)
 * The enterName method is called once enter is pressed.
 */

package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NameController{
	@FXML
	private Button enter;
	@FXML
	private Label player;
	@FXML
	private TextField playerName;
	@FXML
	private Label empty;
	
	
	
	/* 
	 * The enterName method simply takes the text from
	 * playerName TextField and adds it to player1 and player2.
	 * After player2 enter his or her name enterName method
	 * switches scene to GameScreen.
	*/
	@FXML
	public void enterName(ActionEvent event) throws IOException{
		//player1
		if (player.getText() .equals("Player 1")){
			if (playerName.getText() != null && ! playerName.getText().trim().isEmpty()){
				TitleController.player1.setName(playerName.getText());
				player.setText("Player 2");
				empty.setVisible(false);
				playerName.setText(null);
				}
			else {
				empty.setVisible(true);
				}
			}
		
		//player2
		else {
			if (playerName.getText() != null && ! playerName.getText().trim().isEmpty()){
				TitleController.player2.setName(playerName.getText());
				empty.setVisible(false);
				playerName.setText(null);
				
				Parent root = FXMLLoader.load(getClass().getResource("/application/GameScreen.fxml"));
				Scene scene = new Scene(root);
				Stage stage = (Stage) enter.getScene().getWindow();
				stage.setScene(scene);
				stage.show();
				}
			else {
				empty.setVisible(true);
				}
		}
	}
}
