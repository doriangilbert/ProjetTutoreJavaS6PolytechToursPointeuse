package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AppCentraleController {
	@FXML
	private Button buttonStaffManagement;
	@FXML
	private Button buttonCheckInOutHistory;
	@FXML
	private Button buttonParameters;

	@FXML
	protected void handleButtonStaffManagementAction(ActionEvent event) {
		System.out.println("Button StaffManagement");
	}
	
	@FXML
	protected void handleButtonCheckInOutHistoryAction(ActionEvent event) {
		System.out.println("Button CheckInOutHistory");
	}
	
	@FXML
	protected void handleButtonParametersAction(ActionEvent event) {
		System.out.println("Button Parameters");
	}
	
}
