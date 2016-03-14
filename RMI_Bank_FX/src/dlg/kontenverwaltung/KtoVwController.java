package dlg.kontenverwaltung;

import java.net.URL;
import java.util.ResourceBundle;

import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class KtoVwController implements Initializable, ControlledScreen {

	private ScreensController myController;
	
	@FXML private Button buttonKontoAnlegen;
	@FXML private Button buttonKontobewegung;
	@FXML private Button buttonZurueck;
	
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb){

	}
	
	@FXML
	public void buttonKontoAnlegenClicked(){
		myController.setScreen(Hauptmenue.KTOANLEGEN_SCREEN);
	}

	@FXML
	public void buttonKontoBewegungClicked(){
		myController.setScreen(Hauptmenue.KTOBEWEGUNG_SCREEN);
	}

	@FXML
	public void buttonZurueckClicked() {
		myController.setScreen(Hauptmenue.MAIN_SCREEN);
	}
}
