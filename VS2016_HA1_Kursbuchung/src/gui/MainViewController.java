package gui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainViewController {
	
	private StartMenueJavaClass mainLayout;
	
	@FXML private Button homeButton;
	
	@FXML
	private void goHome() throws IOException{
		mainLayout.createMainContent();
	}

}
