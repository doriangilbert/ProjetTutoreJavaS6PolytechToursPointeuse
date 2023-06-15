package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 * Class for the connection's parameters page display!
 */
public class AEParametersController
{
	
	@FXML
	private TextField textFieldCentralAppIpAddress;
	
	@FXML
	private TextField textFieldCentralAppPort;
	
	@FXML
	private void initialize()
	{
		textFieldCentralAppIpAddress.setText(TCPClientBuilder.address);
		textFieldCentralAppIpAddress.setEditable(false);
		textFieldCentralAppPort.setText(Integer.toString(TCPClientBuilder.port));
		textFieldCentralAppPort.setEditable(false);
	}
	
	/**
	 * Define the function of a button to go to the Main page.
	 * 
	 * @param 	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonBackToHome(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the Main page **//
			ClockEmulator.root = FXMLLoader.load(getClass().getResource("EmulatorApplicationView.fxml"));

			Scene scene = new Scene(ClockEmulator.root, 640, 400);

			ClockEmulator.primaryStage.setScene(scene);
			ClockEmulator.primaryStage.show();

			ClockEmulator.isOnMainPage = true;
		}
		
		catch (Exception error)
		{
			error.printStackTrace();
		}
	}
}
