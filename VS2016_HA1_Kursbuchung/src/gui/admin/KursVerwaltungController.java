package gui.admin;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
import awk.DatenhaltungsException;
import awk.kursverwaltung.entity.KursTO;
import awk.kursverwaltung.factory.IKursverwaltungLocalFactory;
import awk.kursverwaltung.factory.impl.KursverwaltungLocalFactory;
import awk.kursverwaltung.usecase.IKursAnlegen;
import awk.kursverwaltung.usecase.IKurseLaden;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class KursVerwaltungController implements Initializable{
	
	private IKursverwaltungLocalFactory kursFactoryLocal = new KursverwaltungLocalFactory();
	private IKursAnlegen kursAnlegenLocal = kursFactoryLocal.useCaseKursAnlegen();
	private IKurseLaden kurseLadenLocal = kursFactoryLocal.useCaseKurseLaden();

	@FXML private TableView<KursTO> tableView_kursTOListe;
	@FXML private Button buttonKursAnlegen;
	@FXML private TextField tf_kursName;
	@FXML private TextField tf_maxAnzTeilnehmer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		initGUI();
	}
	
	private void initGUI(){
		ladeKursListe();
		tf_kursName.setText("");
		tf_maxAnzTeilnehmer.setText("");
	}
	
	
	@FXML
	public void buttonKundeAnlegenClicked() throws AnwendungskernException, DatenhaltungsException{

		String kursName = tf_kursName.getText();
		int anzahlTeilnehmer;
		
		String maxAnzTeilnehmerStr = tf_maxAnzTeilnehmer.getText();
		
		anzahlTeilnehmer = Integer.valueOf(maxAnzTeilnehmerStr);
		kursAnlegenLocal.kursAnlegen(kursName, anzahlTeilnehmer);
		
//		boolean weiter = false;
		
		try {
//			anzahlTeilnehmer = Integer.valueOf(maxAnzTeilnehmerStr);
//			weiter = kursAnlegenLocal.kursAnlegen(kursName, anzahlTeilnehmer);
		}catch (NumberFormatException e){
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Bitte geben Sie eine korrekte Kundennummer ein!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
		
		// IF-Statement
		
		initGUI();
	}
	
	@SuppressWarnings("unchecked")
	@FXML
	private void ladeKursListe(){
		
		Collection<KursTO> kursTOListe = new ArrayList<KursTO>();
		
		try {
			kursTOListe = kurseLadenLocal.kursListeAusgeben();
		} catch (AnwendungskernException e) {
			System.out.println("Fehler beim Initialisieren");
			e.printStackTrace();
		}
		
		ObservableList<KursTO> tabledata = FXCollections.observableArrayList(kursTOListe);
		
		TableColumn<KursTO, String> spalteKursNr = new TableColumn<KursTO, String>("Nr");
		spalteKursNr.setCellValueFactory(new PropertyValueFactory<KursTO, String>("kursNr"));
		spalteKursNr.setMinWidth(85);
		
		TableColumn<KursTO, String> spalteKursName = new TableColumn<KursTO, String>("Kurs");
		spalteKursName.setCellValueFactory(new PropertyValueFactory<KursTO, String>("kursName"));
		spalteKursName.setMinWidth(365);
		
		TableColumn<KursTO, String> spalteAnzTeilnehmer = new TableColumn<KursTO, String>("max. Anzahl");
		spalteAnzTeilnehmer.setCellValueFactory(new PropertyValueFactory<KursTO, String>("anzahlTeilnehmer"));
		spalteAnzTeilnehmer.setMinWidth(130);
		
		tableView_kursTOListe.setItems(tabledata);
		tableView_kursTOListe.getColumns().clear();
		tableView_kursTOListe.getColumns().addAll(spalteKursNr, spalteKursName, spalteAnzTeilnehmer);
	}
	

}
