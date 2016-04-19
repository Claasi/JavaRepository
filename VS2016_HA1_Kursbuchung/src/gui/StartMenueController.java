package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class StartMenueController implements Initializable {
	
	StartMenueJavaClass test;

	@FXML
	private Label greetingLabel;
	private Button buttonAdministrator;
	private Button buttonTeilnehmer;
	private Button buttonCloseApplication;
	
	private Button buttonBackToMainMenue;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void showGreeting(ActionEvent e){
		greetingLabel.setText("WUNDERBAR!");
		System.out.println("Hi!");
	}
	
	public void closeApplication(ActionEvent e){
            	System.out.println("Programm wird geschlossen!"); 
            	Platform.exit();
	}
	
	


}
