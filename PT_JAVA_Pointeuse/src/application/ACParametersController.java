package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 * Class for the Parameters page display!
 */
public class ACParametersController {

	@FXML
	private TextField textFieldEmulatorAppIpAddress;
	
	@FXML
	private TextField textFieldEmulatorAppPort;
	
	@FXML
	private void initialize()
	{
		textFieldEmulatorAppIpAddress.setText(TCPServerBuilder.address);
		textFieldEmulatorAppIpAddress.setEditable(false);
		textFieldEmulatorAppPort.setText(Integer.toString(TCPServerBuilder.port));
		textFieldEmulatorAppPort.setEditable(false);
	}
	
	/**
	 * Define the function of a button to go to the Main page.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonBackToHome(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the Main page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("CentralApplicationView.fxml"));

			Scene scene = new Scene(CentralApplication.root, 640, 400);

			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();
		}
		
		catch (Exception error)
		{
			error.printStackTrace();
		}
	}
}
