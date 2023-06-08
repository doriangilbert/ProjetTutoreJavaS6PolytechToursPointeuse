package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AppCentraleController {
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	@FXML
	private Button button3;

	@FXML
	protected void handleButton1Action(ActionEvent event) {
		System.out.println("Button 1");
	}
	
	@FXML
	protected void handleButton2Action(ActionEvent event) {
		System.out.println("Button 2");
	}
	
	@FXML
	protected void handleButton3Action(ActionEvent event) {
		System.out.println("Button 3");
	}
	
}
