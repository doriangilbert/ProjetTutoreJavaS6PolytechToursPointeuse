package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AppEmulateurController {
	@FXML
	private TextField textFieldCheckInOut;

	@FXML
	protected void handleButtonCheckInOutAction(ActionEvent event) {
		textFieldCheckInOut = (TextField) AppEmulateur.root.lookup("#textFieldCheckInOut");
		String message = textFieldCheckInOut.getText();
		System.out.println("AppEmulateur : Message Sent : " + message);
		new TCPClientMessage().send(message);
		textFieldCheckInOut.clear();
	}
}
