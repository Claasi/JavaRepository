package dlg.menue;

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class Hauptmenue extends Application {

    private Stage mainStage;
	
	public static final String MAIN_SCREEN = "main";
	public static final String MAIN_SCREEN_FXML = "dlg/menue/Hauptmenue.fxml";
	public static final String KDVW_SCREEN = "KdVerwaltungController";
	public static final String KDVW_SCREEN_FXML = "dlg/kundenverwaltung/KdVerwaltung.fxml";
	public static final String KDANLEGEN_SCREEN = "KundeAnlegenController";
	public static final String KDANLEGEN_SCREEN_FXML = "dlg/kundenverwaltung/KundeAnlegen.fxml";
	public static final String KDLISTEAUSGABE_SCREEN = "KundenlisteAusgabeController";
	public static final String KDLISTEAUSGABE_SCREEN_FXML = "dlg/kundenverwaltung/KundenlisteAusgabe.fxml";
	public static final String KDLOESCHEN_SCREEN = "KundeLoeschenController";
	public static final String KDLOESCHEN_SCREEN_FXML = "dlg/kundenverwaltung/KundeLoeschen.fxml";
	public static final String KDSUCHEN_SCREEN = "KundeSuchenController";
	public static final String KDSUCHEN_SCREEN_FXML = "dlg/kundenverwaltung/KundeSuchen.fxml";
	public static final String KTOVW_SCREEN = "KtoVwController";
	public static final String KTOVW_SCREEN_FXML = "dlg/kontenverwaltung/KtoVerwaltung.fxml";
	public static final String KTOANLEGEN_SCREEN = "KontoAnlegenController";
	public static final String KTOANLEGEN_SCREEN_FXML = "dlg/kontenverwaltung/KontoAnlegen.fxml";
	public static final String KTOBEWEGUNG_SCREEN = "KontoBewegungController";
	public static final String KTOBEWEGUNG_SCREEN_FXML = "dlg/kontenverwaltung/KontoBewegung.fxml";
	
	@Override
	public void start(Stage primaryStage) {
		
		this.mainStage = primaryStage;
		
		ScreensController mainContainer = new ScreensController();
		mainContainer.loadScreen(Hauptmenue.MAIN_SCREEN, Hauptmenue.MAIN_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.KDVW_SCREEN, Hauptmenue.KDVW_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.KDANLEGEN_SCREEN, Hauptmenue.KDANLEGEN_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.KDLISTEAUSGABE_SCREEN, Hauptmenue.KDLISTEAUSGABE_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.KDLOESCHEN_SCREEN, Hauptmenue.KDLOESCHEN_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.KDSUCHEN_SCREEN, Hauptmenue.KDSUCHEN_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.KTOVW_SCREEN, Hauptmenue.KTOVW_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.KTOANLEGEN_SCREEN, Hauptmenue.KTOANLEGEN_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.KTOBEWEGUNG_SCREEN, Hauptmenue.KTOBEWEGUNG_SCREEN_FXML);
		
		mainContainer.print();
		
		mainContainer.setScreen(Hauptmenue.MAIN_SCREEN);
		Group root = new Group();
		root.getChildren().addAll(mainContainer);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(confirmCloseEventHandler);
		primaryStage.show();
		
	}
	
    private EventHandler<WindowEvent> confirmCloseEventHandler = event -> {
    	//Quelle: http://stackoverflow.com/questions/29710492/javafx-internal-close-request
        Alert closeConfirmation = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Are you sure you want to exit?"
        );
        Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(
                ButtonType.OK
        );
        exitButton.setText("Exit");
        closeConfirmation.setHeaderText("Confirm Exit");
        closeConfirmation.initModality(Modality.APPLICATION_MODAL);
        closeConfirmation.initOwner(mainStage);

        // normally, you would just use the default alert positioning,
        // but for this simple sample the main stage is small,
        // so explicitly position the alert so that the main window can still be seen.
        closeConfirmation.setX(mainStage.getX() + 150);
        closeConfirmation.setY(mainStage.getY() - 300 + mainStage.getHeight());

        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
        if (!ButtonType.OK.equals(closeResponse.get())) {
            event.consume();
        }
    };
	
	public static void main(String[] args) {
		launch(args);
	}
}
