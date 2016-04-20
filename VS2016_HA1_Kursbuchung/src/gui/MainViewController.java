package gui;

import java.io.IOException;

import javafx.fxml.FXML;

public class MainViewController {
	
	private StartMenueJavaClass mainLayout;
	
	@FXML
	private void goHome() throws IOException{
		mainLayout.createMainContent();
	}

}
