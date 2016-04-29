package gui.admin;

import java.net.URL;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.kursverwaltung.entity.KursTO;
import awk.kursverwaltung.factory.IKursverwaltungLocalFactory;
import awk.kursverwaltung.factory.impl.KursverwaltungLocalFactory;
import awk.kursverwaltung.usecase.IKursSuchen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;

public class KursBelegungController implements Initializable {
	
	private IKursverwaltungLocalFactory kursFactoryLocal = new KursverwaltungLocalFactory();
	private IKursSuchen sucheKursLocal = kursFactoryLocal.useCaseKursSuchen();

	@FXML private Button buttonSucheKurs;
	@FXML private TextField tf_kursNr;
	@FXML private TextField tf_kursName;
	@FXML private TextField tf_auslastung;
	@FXML private TextField tf_maxAnzTeilnehmer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initGUI();
	}
	
	private void initGUI(){
		tf_kursNr.setText("");
		tf_kursName.setText("");
		tf_kursName.setVisible(false);
		tf_auslastung.setText("");
		tf_auslastung.setVisible(false);
		tf_maxAnzTeilnehmer.setText("");
		tf_maxAnzTeilnehmer.setVisible(false);
	}
	
	@FXML
	public void buttonSucheKursClicked() throws AnwendungskernException, DatenhaltungsException{

		String kursNr = tf_kursNr.getText();
		int kursNummer;
		kursNummer = Integer.valueOf(kursNr);
		
		boolean weiter = false;
		try {

			sucheKursLocal.sucheKursByNummer(kursNummer);
			weiter = true;
//			tf_kursName.setVisible(true);
//			tf_auslastung.setVisible(true);
//			tf_maxAnzTeilnehmer.setVisible(true);
			activateTextFields();
			
		}catch (NumberFormatException e){
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Bitte geben Sie eine korrekte Kursnummer ein!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
		
		if (weiter){
			for(KursTO einK : sucheKursLocal.sucheKursByNummer(kursNummer)){
				tf_kursName.setText(einK.getKursName());
				int anzahlTeilnehmer = Integer.valueOf(einK.getAnzahlTeilnehmer());
				tf_maxAnzTeilnehmer.setText(String.valueOf(anzahlTeilnehmer));
//				int auslastung = Integer.valueOf(einK.getAuslastung());
//				tf_maxAnzTeilnehmer.setText(String.valueOf(auslastung));
			}
		} else {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Kursinformationen konnten nicht geladen werden!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
		
	}
	
//	@SuppressWarnings("unchecked")
//	@FXML
//	private void ladeKursListe(){
//		
//		Collection<KursTO> kursTOListe = new ArrayList<KursTO>();
//		
//		try {
//			kursTOListe = kurseLadenLocal.kursListeAusgeben();
//		} catch (AnwendungskernException e) {
//			System.out.println("Fehler beim Initialisieren");
//			e.printStackTrace();
//		}
//		
//		ObservableList<KursTO> tabledata = FXCollections.observableArrayList(kursTOListe);
//		
//		TableColumn<KursTO, String> spalteKursNr = new TableColumn<KursTO, String>("Nr");
//		spalteKursNr.setCellValueFactory(new PropertyValueFactory<KursTO, String>("kursNr"));
//		spalteKursNr.setMinWidth(85);
//		
//		TableColumn<KursTO, String> spalteKursName = new TableColumn<KursTO, String>("Kurs");
//		spalteKursName.setCellValueFactory(new PropertyValueFactory<KursTO, String>("kursName"));
//		spalteKursName.setMinWidth(365);
//		
//		TableColumn<KursTO, String> spalteAnzTeilnehmer = new TableColumn<KursTO, String>("max. Anzahl");
//		spalteAnzTeilnehmer.setCellValueFactory(new PropertyValueFactory<KursTO, String>("anzahlTeilnehmer"));
//		spalteAnzTeilnehmer.setMinWidth(130);
//		
//		tableView_kursTOListe.setItems(tabledata);
//		tableView_kursTOListe.getColumns().clear();
//		tableView_kursTOListe.getColumns().addAll(spalteKursNr, spalteKursName, spalteAnzTeilnehmer);
//	}

//	@Override
//	public void handle(ActionEvent event) {
//		if(event.getSource()==tf_maxAnzTeilnehmer && tf_maxAnzTeilnehmer != null){
//			buttonKursAnlegen.setDisable(false);
//			tf_kursName.setVisible(true);
//			tf_auslastung.setVisible(true);
//			tf_maxAnzTeilnehmer.setVisible(true);
//		}
//	}
	@FXML
	private void activateTextFields(){
			tf_kursName.setVisible(true);
			tf_auslastung.setVisible(true);
			tf_maxAnzTeilnehmer.setVisible(true);
	}

}
