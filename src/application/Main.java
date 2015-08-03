/*Developed by: Faheem Syed and Marianna Sullivan
 * 
 * This is a basic trivia game created for CSC 330 (Object-Oriented Software Design).
 * 2 players will have 30 seconds to answer as many questions as possible,
 * as we will see in the rules screen
 * 
 * We used the JavaFX scene builder application to create fxml files
 * along with JavaFX to make the design process easier and to make the 
 * application look better. (swing GUIs look like they're from the 90s)
 * 
 * The Main class extends Application, sets the stage, scene and title.
 * The stage is then passed to the TitleController class.
 * The Controller classes (6 of them) process all the code behind the fxml files.
 * Each fxml file has a its own controller
 * TitleController passes the stage to rulesController
 * rulesController -> NameController where each player enters their name
 * NameController -> GameController -> RulesController -> GameController
 * GameController -> ExitScreen
*/


package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application{
	
	
	//Sets the stage and scene
	//The scene is then switched to the TitleScreen
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/TitleScreen.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("The best trivia game ever!!!!  :)");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
