package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class ACStaffManagementController {

	@FXML
	protected void handleButtonCreateEmployee(ActionEvent event) {
		try {
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACCreateEmployeeView.fxml"));

			Scene scene = new Scene(CentralApplication.root, 640, 400);

			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	protected void handleButtonBackToHome(ActionEvent event) {
		try {
			CentralApplication.root = FXMLLoader.load(getClass().getResource("CentralApplicationView.fxml"));

			Scene scene = new Scene(CentralApplication.root, 640, 400);

			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}