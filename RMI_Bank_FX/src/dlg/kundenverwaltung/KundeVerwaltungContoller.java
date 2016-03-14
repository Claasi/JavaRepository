package dlg.kundenverwaltung;

import java.net.URL;
import java.util.ResourceBundle;

import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class KundeVerwaltungContoller implements Initializable, ControlledScreen {
	
	@FXML private Button buttonKundeAnlegen;
	@FXML private Button buttonKundeListeAnzeigen;
	@FXML private Button buttonKundeLoeschen;
	@FXML private Button buttonKundeSuchen;
	@FXML private Button buttonZurueck;
	
	private ScreensController myController;
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
//		myController.setOnCloseRequest(e -> {
//			System.out.println("Ciao");
//			// System.exit(0);});
	}
	
	
	@FXML
	public void zurueckZumHauptmenue(){
		myController.setScreen(Hauptmenue.MAIN_SCREEN);
	}

	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}
	
	@FXML
	public void goToMenuKundeAnlegen() {
		myController.setScreen(Hauptmenue.KDANLEGEN_SCREEN);
	}
	
	@FXML
	public void goToKundenlisteAnzeigen(){
		//((Note)(event.getSource())).getScene().getWindow().hide();
		myController.print();
		myController.setScreen(Hauptmenue.KDLISTEAUSGABE_SCREEN);
	}
	@FXML
	public void goToKundenLoeschenAnzeigen(){
		myController.setScreen(Hauptmenue.KDLOESCHEN_SCREEN);
	}	
	
	@FXML
	public void buttonKundeSuchenClicked(){
		myController.setScreen(Hauptmenue.KDSUCHEN_SCREEN);
	}
}
