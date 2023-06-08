package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AppEmulateurController {
	/*@FXML
	private TextField textFieldCheckInOut = (TextField) AppEmulateur.root.lookup("#textFieldCheckInOut");*/
	
	@FXML
	private Button buttonCheckInOut;

	@FXML
	protected void handleButtonCheckInOutAction(ActionEvent event) {
		/*String message = textFieldCheckInOut.getText();
		System.out.println("AppEmulateur : Message Sent : " + message);
		new TCPClientMessage().send(message);
		//textFieldCheckInOut.clear();*/
	}
	
}
