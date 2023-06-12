package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class AppCentraleController {

	@FXML
	protected void handleButtonStaffManagementAction(ActionEvent event) {
		try {
			AppCentrale.root = FXMLLoader.load(getClass().getResource("ACStaffManagementView.fxml"));

			Scene scene = new Scene(AppCentrale.root, 640, 400);

			AppCentrale.primaryStage.setScene(scene);
			AppCentrale.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	protected void handleButtonCheckInOutHistoryAction(ActionEvent event) {
		try {
			AppCentrale.root = FXMLLoader.load(getClass().getResource("ACCheckInOutHistoryView.fxml"));

			Scene scene = new Scene(AppCentrale.root, 640, 400);

			AppCentrale.primaryStage.setScene(scene);
			AppCentrale.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	protected void handleButtonParametersAction(ActionEvent event) {
		try {
			AppCentrale.root = FXMLLoader.load(getClass().getResource("ACParametersView.fxml"));

			Scene scene = new Scene(AppCentrale.root, 640, 400);

			AppCentrale.primaryStage.setScene(scene);
			AppCentrale.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
