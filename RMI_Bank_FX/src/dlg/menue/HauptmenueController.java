package dlg.menue;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HauptmenueController implements Initializable, ControlledScreen {

	@FXML Button buttonKdVerwaltung;
	@FXML Button buttonKontenVerwaltung;
	@FXML Button buttonBeenden;
	
	private ScreensController myController;
	private HauptmenueService awkService;
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		awkService = new HauptmenueService();
	}

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}
	
	@FXML
	public void beenden(){
		
		System.out.println("Beenden");
		System.exit(0);
	}
	
	@FXML
	public void starteKundenVW(){
		System.out.println("Starte KundenVerwaltung");
		myController.setScreen(Hauptmenue.KDVW_SCREEN);
	}
	
	@FXML
	public void starteKontenVW(){
		System.out.println("Starte KontenVerwaltung");
		this.myController.setScreen(Hauptmenue.KTOVW_SCREEN);
	}

	public HauptmenueService getHauptmenueService(){
		return awkService;
	}

	
}
