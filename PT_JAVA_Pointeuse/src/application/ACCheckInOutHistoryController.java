package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class ACCheckInOutHistoryController {

	@FXML
	protected void handleButtonBackToHome(ActionEvent event) {
		try {
			AppCentrale.root = FXMLLoader.load(getClass().getResource("AppCentraleView.fxml"));

			Scene scene = new Scene(AppCentrale.root, 640, 400);

			AppCentrale.primaryStage.setScene(scene);
			AppCentrale.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
