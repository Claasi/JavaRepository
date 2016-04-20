package gui.admin;

import java.io.IOException;

import gui.StartMenueJavaClass;
import javafx.fxml.FXML;

public class KursVwAdminMenueController {
	
	private StartMenueJavaClass startMenue;

	@FXML
	private void goToKursVerwaltung() throws IOException{
		startMenue.showKursVerwaltung();
	}
	
	@FXML
	private void goToKursBelegung() throws IOException{
		startMenue.showKursBelegung();
	}
	
	@FXML
	private void goToAdminMenue() throws IOException{
		startMenue.showAdminMenue();
	}

}
