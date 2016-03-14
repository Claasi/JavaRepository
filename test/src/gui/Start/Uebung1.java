package gui.Start;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Uebung1 extends Application {

	@Override
	public void start(Stage stage) {
		
		// Layout erzeugen und Strukturelemente einsetzen
        BorderPane pane = new BorderPane();
        
		// Info-Element (TOP):
		Label informationsLabel = new Label("Neuer Kontakt");
		HBox topInfoLabel = new HBox(informationsLabel);
		topInfoLabel.setAlignment(Pos.CENTER);
        // Ordne Strukturelemente an:
		topInfoLabel.setPadding(new Insets(5)); // Abstand nach oben und unten vom Label
        pane.setTop(topInfoLabel);
		
        
        // Erzeuge Label für den Center-Bereich
		Label vorname = new Label("Vorname");
		Label nachName = new Label("Nachname");
		Label telefon = new Label("Telefon");
		Label eMail = new Label("e-Mail");
		
		// Erzeuge TextFelder für den Center-Bereich
		TextField tf_vorname = new TextField();
		TextField tf_nachName = new TextField();
		TextField tf_telefon = new TextField();
		TextField tf_eMail = new TextField();
		
		//Erzeuge Strukturelemente für den Center-Bereich
		HBox vornameBox = new HBox(vorname, tf_vorname); 
		vornameBox.setSpacing(5); // Abstand zwischen den Elementen Label und TextField
		vornameBox.setPadding(new Insets(2.5));// Abstand nach oben und unten von der HBox
		
		HBox nachnameBox = new HBox(nachName, tf_nachName); nachnameBox.setSpacing(5); nachnameBox.setPadding(new Insets(2.5)); 
		HBox telefonBox = new HBox(telefon, tf_telefon); telefonBox.setSpacing(5); telefonBox.setPadding(new Insets(2.5)); 
		HBox eMailBox = new HBox(eMail, tf_eMail); eMailBox.setSpacing(5); eMailBox.setPadding(new Insets(2.5)); 
		// HBoxen einer VBox anh�ngen/zuf�gen
        VBox labelTfCenter = new VBox(vornameBox, nachnameBox, telefonBox, eMailBox);
        // Ordne Strukturelemente dem Center zu:
        pane.setCenter(labelTfCenter);
        

        // Buttons (BOT):
        Button bAdd = new Button("Hinzufuegen");
        Button bPrint = new Button("Ausdruck");
        Button bClose = new Button("Schliessen");
        // Horizontale Box bestehend aus Button OK und Cancel
        HBox buttonBoxes = new HBox(bAdd, bPrint, bClose);
        // Position der Elemente mit setAlignment bestimmen
        buttonBoxes.setAlignment(Pos.BASELINE_CENTER);
        // Innenabstand bestimmen
        buttonBoxes.setPadding(new Insets(2.5));
        // Zwischenraum zwischen Elementen
        buttonBoxes.setSpacing(10);
        // Anordnung im Gesamt-Layout
        pane.setBottom(buttonBoxes);
        
        
        // Button Events:
        
        // Neue Schreibweise
        bAdd.setOnAction(e -> {
        	System.out.println("Text: " + tf_vorname.getText());
        });
        
        // "Alte" Schreibweise
        bPrint.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Kontakt wird gedruckt!");
            }
        });
        
        bClose.setOnAction((ActionEvent e) -> {
        	System.out.println("Programm wird geschlossen!"); 
        	Platform.exit();
        });
        
        
        // Innenabstand bestimmen, d.h. vom Fensterrand oben zum obersten Strukturelement, vom Fensterrand unten zum untersten Strukturelement 
        pane.setPadding(new Insets(10));
        
        
        // Erzeuge Scene bzw. Fensterinhalt (Layout(BorderPANE), Breite, Höhe)
        Scene scene = new Scene(pane, 300, 225);

        
		// Konfiguration vom Fenster:
		stage.setTitle("Kontakte");
        stage.setScene(scene);
        stage.show();
        
        // StackPane = Layoutelement: Erlaubt �bereinanderstapeln von Komponenten
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
