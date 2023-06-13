package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class CentralApplicationController {

	@FXML
	protected void handleButtonStaffManagementAction(ActionEvent event) {
		try {
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACStaffManagementView.fxml"));

			Scene scene = new Scene(CentralApplication.root, 640, 400);

			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	protected void handleButtonCheckInOutHistoryAction(ActionEvent event) {
		try {
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACCheckInOutHistoryView.fxml"));

			Scene scene = new Scene(CentralApplication.root, 640, 400);

			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	protected void handleButtonParametersAction(ActionEvent event) {
		try {
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACParametersView.fxml"));

			Scene scene = new Scene(CentralApplication.root, 640, 400);

			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
