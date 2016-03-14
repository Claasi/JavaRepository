package dlg.kundenverwaltung;

import java.net.URL;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.HauptmenueService;
import dlg.menue.ScreensController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;

public class KundeLoeschenController implements Initializable, ControlledScreen {

	ScreensController myController;
	@FXML private Button buttonKundeLoeschen;
	@FXML private TextField tf_kundennummer;
	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		myController = screenPage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	@FXML
	public void buttonAbbruchClicked(){
		myController.setScreen(Hauptmenue.KDVW_SCREEN);
	}
	
	@FXML
	public void buttonKundeLoeschenClicked(){
		
		int kundennummer = Integer.parseInt(tf_kundennummer.getText());
		boolean ok = false;
		try {
			ok = HauptmenueService.getKundenPflegen().kundenLoeschen(kundennummer);
		} catch (AnwendungskernException e) {
			e.printStackTrace();
		}
		
		if ( ok ) {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Kunde "+kundennummer+ " wurde erfolgreich gelöscht!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
			buttonAbbruchClicked();
		} else {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Kunde "+kundennummer+ " konnt nicht gelöscht werden!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
	}

}
