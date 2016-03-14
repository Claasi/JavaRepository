package dlg.kontenverwaltung;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;

public class KontoAnlegenController implements Initializable, ControlledScreen {

	private ScreensController myController;
	@FXML private Button buttonKontoAnlegen;
	@FXML private Button buttonZureck;
	@FXML private TextField tf_kundenNummer;
	@FXML private Label label_ktoNr;
	
	
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		this.initGui();
	}
	
	private void initGui(){
		label_ktoNr.setText("");
		tf_kundenNummer.setText("");
	}
	
	@FXML
	public void buttonAnlegenClicked(){ 
		int ktonr = 0;
		int kdnr = 0;
		String kdnr_str = tf_kundenNummer.getText();
		boolean weiter = false;
		try {
			kdnr = Integer.valueOf(kdnr_str);
			weiter = true;
		} catch (NumberFormatException e){
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Bitte geben Sie eine korrekte Kundennummer ein!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
		
		if ( weiter ){
			try {
				ktonr = HauptmenueService.getKontenPflegen().kontoAnlegen(Integer.valueOf(kdnr_str));
			} catch (AnwendungskernException e) {
				e.printStackTrace();
			}
			
			if (ktonr == 0){
				Dialog<String> dialog = new Dialog<>();
				dialog.setContentText("Konto konnte nicht erfolgeich angelegt werden!");
				ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
				dialog.getDialogPane().getButtonTypes().add(okButtonType);
				boolean disabled = false;
				dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
				dialog.show();
			} else {
				label_ktoNr.setText(String.valueOf(ktonr));
			}
		}
		
	}
	
	@FXML
	public void buttonZureckClicked(){
		this.initGui();
		myController.setScreen(Hauptmenue.KTOVW_SCREEN);	}
}
