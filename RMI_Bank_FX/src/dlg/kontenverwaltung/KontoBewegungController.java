package dlg.kontenverwaltung;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
import awk.kontenverwaltung.entity.KontoTO;
import awk.kontenverwaltung.entity.KontobewegungTO;
import awk.kundenverwaltung.entity.GeschaeftskundeTO;
import awk.kundenverwaltung.entity.KundeTO;
import awk.kundenverwaltung.entity.PrivatkundeTO;
import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.HauptmenueService;
import dlg.menue.ScreensController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;

public class KontoBewegungController implements Initializable, ControlledScreen {

	private ScreensController myController;
	@FXML private Button buttonKtoAuskunft;
	@FXML private Button buttonEinzahlen;
	@FXML private Button buttonAuszahlen;
	@FXML private Button buttonZurueck;
	@FXML private TextField tf_ktonr;
	@FXML private TextField tf_betrag;
	@FXML private Label lb_name;
	@FXML private Label lb_vorname;
	@FXML private Label lb_saldo;
	@FXML private TableView tv_ktobewegung;
	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		this.myController = screenPage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initGui();
	}
	
	@FXML
	public void buttonKtoAuskunftClicked(){
		String kto_string = tf_ktonr.getText();
		int ktonr = 0;
		KontoTO einKontoTO = null; 
		
		try{
			ktonr = Integer.parseInt(kto_string);
		} catch (NumberFormatException e){
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Bitte geben Sie eine korrekte Kundennummer ein!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
		
		if ( ktonr != 0){
			try {
				einKontoTO = HauptmenueService.getKontobewegungBuchen().kontoSuchen(ktonr);
			} catch (AnwendungskernException e) {
				e.printStackTrace();
				Dialog<String> dialog = new Dialog<>();
				dialog.setContentText("Keine Konten gefunden!");
				ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
				dialog.getDialogPane().getButtonTypes().add(okButtonType);
				boolean disabled = false;
				dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
				dialog.show();
			}
			
			if (einKontoTO != null){
				lb_name.setText(einKontoTO.getInhaberNachname());
				lb_vorname.setText(einKontoTO.getInhaberVorname());
				lb_saldo.setText(String.valueOf(einKontoTO.getSaldo()));
				showTableView(einKontoTO.getKontobewegungen());
				buttonEinzahlen.setDisable(false);
				buttonAuszahlen.setDisable(false);
			}
		}	
	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void showTableView(Collection<KontobewegungTO> kontobewegungen) {
		

		ObservableList<KontobewegungTO> tabledata 
				= FXCollections.observableArrayList(kontobewegungen);

		System.out.println("Anzahl Umsätze: "+tabledata.size());
	
		TableColumn<KontobewegungTO, String> typCol = new TableColumn<KontobewegungTO, String>("Typ");
		typCol.setMinWidth(100);
		typCol.setCellValueFactory(
			new PropertyValueFactory<KontobewegungTO, String>("typ"));
		
		TableColumn<KontobewegungTO, String> betragCol = new TableColumn<KontobewegungTO, String>("Betrag");
		betragCol.setMinWidth(100);
		betragCol.setCellValueFactory(
			new PropertyValueFactory<KontobewegungTO, String>("betrag"));

		tv_ktobewegung.setItems(tabledata);
		ArrayList<TableColumn> aList = new ArrayList<TableColumn>();
		aList.add(typCol);
		aList.add(betragCol);
		tv_ktobewegung.getColumns().setAll(aList);
	}
	
	@FXML
	public void buttonEinzahlenClicked(){
		
		int kontoNr = Integer.parseInt(tf_ktonr.getText()); // KTO-Nr muss funktionieren, da ja zuvor geprueft
		
		String betrag_string = tf_betrag.getText();
		double betrag = 0.0;
		
		try{
			betrag = Double.parseDouble(betrag_string);
		} catch (NumberFormatException e){
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Bitte geben Sie einen korrekte Betrag ein!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
		
		if (betrag != 0){
			try {
				HauptmenueService.getKontobewegungBuchen().einzahlen(kontoNr, betrag);
			} catch (AnwendungskernException e) {
				Dialog<String> dialog = new Dialog<>();
				dialog.setContentText("Bitte Einzahlung fehlgeschlagen!");
				ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
				dialog.getDialogPane().getButtonTypes().add(okButtonType);
				boolean disabled = false;
				dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
				dialog.show();
				e.printStackTrace();
			}
		}
		
	}
	
	@FXML
	public void buttonAuszahlenClicked(){
			
		int kontoNr = Integer.parseInt(tf_ktonr.getText()); // KTO-Nr muss funktionieren, da ja zuvor geprueft
			
		String betrag_string = tf_betrag.getText();
		double betrag = 0.0;
			
		try{
			betrag = Double.parseDouble(betrag_string);
		} catch (NumberFormatException e){
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Bitte geben Sie einen korrekte Betrag ein!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
			
		if (betrag != 0){
			try {
				HauptmenueService.getKontobewegungBuchen().abheben(kontoNr, betrag);
			} catch (AnwendungskernException e) {
				Dialog<String> dialog = new Dialog<>();
				dialog.setContentText("Bitte Auszahlung fehlgeschlagen!");
				ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
				dialog.getDialogPane().getButtonTypes().add(okButtonType);
				boolean disabled = false;
				dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
				dialog.show();
				e.printStackTrace();
			}
		}
	}
	
	@FXML
	public void buttonZurueckClicked(){
		this.initGui();
		myController.setScreen(Hauptmenue.KTOVW_SCREEN);
	}

	private void initGui() {
		tf_ktonr.setText("");
		tf_betrag.setText("");;
		lb_name.setText("");;
		lb_vorname.setText("");
		lb_saldo.setText("");
		buttonEinzahlen.setDisable(true);
		buttonAuszahlen.setDisable(true);
		
		ObservableList<KontobewegungTO> tabledata 
			= FXCollections.observableArrayList(new ArrayList());
		tv_ktobewegung.setItems(tabledata);
	}
}
