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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class KundeAnlegenController implements Initializable, ControlledScreen {

	@FXML private Button buttonKundeAnlegen;
	@FXML private Button buttonAbbruch;
	@FXML private RadioButton rb_privat;
	@FXML private RadioButton rb_geschaeft;
	@FXML private ComboBox<String> cb_geschlecht;
	@FXML private TextField tf_nachname;
	@FXML private TextField tf_vorname;
	@FXML private TextField tf_strasse;
	@FXML private TextField tf_hnr;
	@FXML private TextField tf_plz;
	@FXML private TextField tf_ort;
	@FXML private TextField tf_ustid;
	@FXML private Label label_ustid;
	
	ScreensController myController;
	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		myController = screenPage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initGui();
	}
	
	private void initGui(){
		cb_geschlecht.getItems().setAll("M","W");
		rb_privat.setSelected(false);
		rb_geschaeft.setSelected(false);
		tf_nachname.setText("");
		tf_vorname.setText("");
		tf_strasse.setText("");
		tf_hnr.setText("");
		tf_plz.setText("");
		tf_ort.setText("");
		tf_ustid.setText("");
	}
	
	
	@FXML
	public void buttonKundeAnlegenClicked(){
		String geschlecht = cb_geschlecht.getValue();
		String nachname = tf_nachname.getText();
		String vorname = tf_vorname.getText();
		String strasse = tf_strasse.getText();
		String hnr = tf_hnr.getText();
		String plz = tf_plz.getText();
		String ort = tf_ort.getText();
		String ustid = tf_ustid.getText();
		
		
		boolean ok= false;
		if (rb_privat.isSelected()) {
		
			try {
				ok = HauptmenueService.getKundenPflegen().privatkundeAnlegen(vorname, nachname, strasse, hnr, plz, ort, geschlecht);
			} catch (AnwendungskernException e) {
				e.printStackTrace();
			}
			
		} else if(rb_geschaeft.isSelected() ){
			try {
				ok = HauptmenueService.getKundenPflegen().geschaeftskundeAnlegen(vorname, nachname, strasse, hnr, plz, ort, ustid);
			} catch (AnwendungskernException e) {
				e.printStackTrace();
			}
		}
		else{
			
		}
		
		if (ok) {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Kunde wurde angelegt!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
			
			this.buttonAbbuchKlicked();
		}
		else {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Fehler beim Anlegen des Kunden!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
		
	}
	
	@FXML
	public void buttonAbbuchKlicked(){
		initGui();
		myController.setScreen(Hauptmenue.KDVW_SCREEN);
	}
	
	@FXML
	public void rb_privat_clicked(){
		rb_geschaeft.setSelected(false);
		label_ustid.setVisible(false);
		tf_ustid.setVisible(false);
	}
	
	@FXML
	public void rb_geschaeft_clicked(){
		rb_privat.setSelected(false);
		label_ustid.setVisible(true);
		tf_ustid.setVisible(true);
	}
	
}
