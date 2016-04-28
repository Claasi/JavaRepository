package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartMenueJavaClass extends Application {
	
	public static Stage primaryStage;
	private static BorderPane mainLayout;
	
	public static final String MainLayout_FXML = "MainView.fxml";
	public static final String MainContent_FXML = "StartMenue.fxml";
	public static final String KURSVW_ADMIN_SCREEN_FXML = "admin/KursVwAdminMenue.fxml";
	public static final String KURSVERWALTUNG_SCREEN_FXML = "admin/KursVerwaltung.fxml";
	public static final String KURSBELEGUNG_SCREEN_FXML = "admin/KursBelegung.fxml";
	public static final String KURSVW_USER_SCREEN_FXML = "user/KursAnmeldung.fxml";
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
//		this.primaryStage = primaryStage;
		StartMenueJavaClass.primaryStage = primaryStage;
		
		createMainLayout();
		createMainContent();
	}
	
	// Initialisiere HauptScene / MainLayout
	private void createMainLayout() throws IOException{
		FXMLLoader layoutLoader = new FXMLLoader();
		layoutLoader.setLocation(StartMenueJavaClass.class.getResource(MainLayout_FXML));
		mainLayout = layoutLoader.load();
		Scene scene = new Scene(mainLayout);
		scene.getStylesheets().add("/gui/main.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	// Füge dem vorhandenen MainLayout weiteren Inhalt hinzu
	public static void createMainContent() throws IOException{
		FXMLLoader contentLoader = new FXMLLoader();
		contentLoader.setLocation(StartMenueJavaClass.class.getResource(MainContent_FXML));
		BorderPane startContent = contentLoader.load();
		mainLayout.setCenter(startContent);
		primaryStage.setTitle("Kursbuchungs-System");
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	// Wechsle Inhalt des HauptScene / MainLayout
	public static void showAdminMenue() throws IOException{
		FXMLLoader loddar = new FXMLLoader();
		loddar.setLocation(StartMenueJavaClass.class.getResource(KURSVW_ADMIN_SCREEN_FXML));
		BorderPane bP = loddar.load();
		mainLayout.setCenter(bP);
		primaryStage.setTitle("Admin-Menü");
	}
	
	
	public static void showUserMenue() throws IOException{
		FXMLLoader loddar = new FXMLLoader();
		loddar.setLocation(StartMenueJavaClass.class.getResource(KURSVW_USER_SCREEN_FXML));
		BorderPane bP = loddar.load();
		mainLayout.setCenter(bP);
		primaryStage.setTitle("Benutzer - Kursanmeldung");
	}
	

	public static void showKursVerwaltung() throws IOException{
		FXMLLoader loddar = new FXMLLoader();
		loddar.setLocation(StartMenueJavaClass.class.getResource(KURSVERWALTUNG_SCREEN_FXML));
		BorderPane bP = loddar.load();
		mainLayout.setCenter(bP);
		primaryStage.setTitle("Admin-Menü");
	}

	
	public static void showKursBelegung() throws IOException{
		FXMLLoader loddar = new FXMLLoader();
		loddar.setLocation(StartMenueJavaClass.class.getResource(KURSBELEGUNG_SCREEN_FXML));
		BorderPane bP = loddar.load();
		mainLayout.setCenter(bP);
		primaryStage.setTitle("Admin-Menü");
	}

	

	
}
