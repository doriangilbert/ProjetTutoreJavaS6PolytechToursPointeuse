package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class ACManageEmployeeController {
	
	@FXML
	protected void handleButtonConfirm(ActionEvent event) {
		System.out.println("Confirm button pressed");
	}
	
	@FXML
	protected void handleButtonBack(ActionEvent event) {
		try {
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACStaffManagementView.fxml"));

			Scene scene = new Scene(CentralApplication.root, 640, 400);

			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
