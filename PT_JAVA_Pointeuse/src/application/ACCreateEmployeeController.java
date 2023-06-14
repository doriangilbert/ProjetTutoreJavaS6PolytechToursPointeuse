package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Class for the Check in/out history page display!
 */
public class ACCreateEmployeeController
{
	
	@FXML
	protected void handleButtonConfirm(ActionEvent event)
	{
		System.out.println("Confirm button pressed");
	}
	
	/**
	 * Define a button to go to the staff management page.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonBack(ActionEvent event)
	{
		try
		{
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACStaffManagementView.fxml"));

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
