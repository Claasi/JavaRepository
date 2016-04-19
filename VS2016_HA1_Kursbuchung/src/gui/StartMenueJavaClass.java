package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartMenueJavaClass extends Application {
	
	private Stage primaryStage;

	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		
		createMainLayout();
	}
	
	private void createMainLayout() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("StartMenue.fxml"));
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add("/gui/main.css");
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Startfenster");
		primaryStage.show();
	}
	

	// Initialisiere Hauptfenster
	
	// Wechsle die Scene mit String des FXML-Dokuments
	
	
	public static void main(String[] args) {
		launch(args);
	}
	

	
}
