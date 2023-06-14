package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class AEParametersController {
	@FXML
	protected void handleButtonBackToHome(ActionEvent event) {
		try {
			// ** We load the FXML file to display the window with the shape of the Main page **//
			ClockEmulator.root = FXMLLoader.load(getClass().getResource("EmulatorApplicationView.fxml"));

			Scene scene = new Scene(ClockEmulator.root, 640, 400);

			ClockEmulator.primaryStage.setScene(scene);
			ClockEmulator.primaryStage.show();

			ClockEmulator.isOnMainPage = true;
		} catch (Exception error) {
			error.printStackTrace();
		}
	}
}
