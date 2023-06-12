package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppEmulateur extends Application {
	public static Stage primaryStage;
	public static Parent root;

	@Override
	public void start(Stage primaryStage) {
		AppEmulateur.primaryStage = primaryStage;
		try {
			root = FXMLLoader.load(getClass().getResource("AppEmulateurView.fxml"));

			Scene scene = new Scene(root, 640, 400);

			AppEmulateur.primaryStage.setTitle("PT_JAVA_Pointeuse : Application Emulateur");
			AppEmulateur.primaryStage.setScene(scene);
			AppEmulateur.primaryStage.show();

			new Thread(new AppEmulateurLiveClock()).start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}