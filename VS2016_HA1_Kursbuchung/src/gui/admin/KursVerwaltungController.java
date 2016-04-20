package gui.admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class KursVerwaltungController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * 	@FXML
	public void buttonKundeAnlegenClicked() throws RemoteException{
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
				ok = myController.getAwkService().getKundenPflegen().privatkundeAnlegenR(vorname, nachname, strasse, hnr, plz, ort, geschlecht);
			} catch (AnwendungskernException e) {
				e.printStackTrace();
			}
			
		} else if(rb_geschaeft.isSelected() ){
			try {
				ok = myController.getAwkService().getKundenPflegen().geschaeftskundeAnlegenR(vorname, nachname, strasse, hnr, plz, ort, ustid);
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
	 */

}
