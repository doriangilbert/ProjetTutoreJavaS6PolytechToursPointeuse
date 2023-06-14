package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Controller of the CentralApplication class!
 * This class initialize 3 buttons to go through all the pages.
 */
public class CentralApplicationController
{

	/**
	 * Define a button to go to the Staff management page.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonStaffManagementAction(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the staff management page **//
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

	/**
	 * Define a button to go to the Check in/out history page.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonCheckInOutHistoryAction(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the check history page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACCheckInOutHistoryView.fxml"));

			Scene scene = new Scene(CentralApplication.root, 640, 400);

			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();
		}
		
		catch (Exception error)
		{
			error.printStackTrace();
		}
	}

	/**
	 * Define a button to go to the Parameters page.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonParametersAction(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the parameters page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACParametersView.fxml"));

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
