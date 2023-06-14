package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Class for the Check in/out history page display!
 */
public class ACCheckInOutHistoryController
{

	/**
	 * Define a button to go to the today's check history page.
	 * 
	 * @param	event	the type of event (a left mouse click on a button).
	 */
	@FXML
	protected void handleButtonTodayChecks(ActionEvent event)
	{
		try
		{
			//** We load the FXML file to display the window with the shape of the today's check history page **//
			CentralApplication.root = FXMLLoader.load(getClass().getResource("ACTodayCheckInOutHistoryView.fxml"));

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
	 * Define a button to go to the Main page.
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
