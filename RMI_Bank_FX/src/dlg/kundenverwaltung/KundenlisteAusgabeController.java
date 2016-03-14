package dlg.kundenverwaltung;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class KundenlisteAusgabeController implements Initializable, ControlledScreen {
	
	@FXML private Button buttonZurueck;
	@FXML private TableView<KundeTO> tv_kundenliste;
//	@FXML private Scene scene;
	
	private ScreensController myController;

	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		myController = screenPage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initKundenliste();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initKundenliste(){
		
		Collection<KundeTO> kundenliste = new ArrayList<KundeTO>();
		
		try {
			kundenliste = HauptmenueService.getKundenlisteErstellen()
					.kundenListeAusgeben();
		} catch (AnwendungskernException e) {
			e.printStackTrace();
		}
		
		ObservableList<KundeTO> tabledata 
					= FXCollections.observableArrayList(kundenliste);
		
		System.out.println("Anzahl ObservableListe: "+tabledata.size());
		
		TableColumn<KundeTO, String> kdNrCol = new TableColumn<KundeTO, String>("KdNr");
		kdNrCol.setMinWidth(100);
		kdNrCol.setCellValueFactory(
				new PropertyValueFactory<KundeTO, String>("kundennummer"));
		
		TableColumn<KundeTO, String> vornameCol = new TableColumn<KundeTO, String>("Vorname");
		vornameCol.setMinWidth(100);
		vornameCol.setCellValueFactory(
				new PropertyValueFactory<KundeTO, String>("vorname"));
		
		TableColumn<KundeTO, String> nachnameCol = new TableColumn<KundeTO, String>("Nachname");
		nachnameCol.setMinWidth(100);
		nachnameCol.setCellValueFactory(
				new PropertyValueFactory<KundeTO, String>("nachname"));
		
		TableColumn<KundeTO, String> strCol = new TableColumn<KundeTO, String>("Strasse");
		strCol.setMinWidth(100);
		strCol.setCellValueFactory(
				new PropertyValueFactory<KundeTO, String>("str"));
		
		TableColumn<KundeTO, String> plzCol = new TableColumn<KundeTO, String>("PLZ");
		plzCol.setMinWidth(100);
		plzCol.setCellValueFactory(
				new PropertyValueFactory<KundeTO, String>("plz"));

		TableColumn<KundeTO, String> ortCol = new TableColumn<KundeTO, String>("Ort");
		ortCol.setMinWidth(100);
		ortCol.setCellValueFactory(
				new PropertyValueFactory<KundeTO, String>("ort"));
		
		TableColumn<PrivatkundeTO, String> geschlechtCol = new TableColumn<PrivatkundeTO, String>("Geschlecht");
		TableColumn<GeschaeftskundeTO, String> ustidCol = new TableColumn<GeschaeftskundeTO, String>("UstId");
		TableColumn typeCol = new TableColumn("Kunde-Typ");
		typeCol.getColumns().addAll(geschlechtCol, ustidCol);
		
		ustidCol.setMinWidth(100);
		ustidCol.setCellValueFactory(
				new PropertyValueFactory<GeschaeftskundeTO, String>("UstId"));
		
		geschlechtCol.setMinWidth(100);
		geschlechtCol.setCellValueFactory(
				new PropertyValueFactory<PrivatkundeTO, String>("geschlecht"));
		
		
		tv_kundenliste.setItems(tabledata);
		tv_kundenliste.getColumns().addAll(kdNrCol, vornameCol, nachnameCol, 
				strCol, plzCol, ortCol, typeCol);
		

	}

	@FXML
	public void buttonZurueckClicked(){
		myController.setScreen(Hauptmenue.KDVW_SCREEN);
	}
	
}
