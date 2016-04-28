package gui;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class StartMenueController {
	
	private StartMenueJavaClass startMenue;

	@FXML
	private void goToAdminMenue() throws IOException{
		startMenue.showAdminMenue();
	}
	
	@FXML
	private void goToUserMenue() throws IOException{
		startMenue.showUserMenue();
	}

	@FXML
	private Label greetingLabel;

	
	@FXML
	private void showGreeting(ActionEvent e){
		greetingLabel.setText("WUNDERBAR!");
		System.out.println("Hi!");
	}
	
	@FXML
	private void closeApplication(ActionEvent e){
            	System.out.println("Programm wird geschlossen!"); 
            	Platform.exit();
	}


}
