package fr.univtours.polytech.ptjavapointeuse.emulatorapp.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * View of the ClockEmulator class!
 * Display every elements on a window.
 */
public class ClockEmulator extends Application
{
	public static Stage primaryStage;
	public static Parent root;
	
	public static boolean isOnMainPage = true;

	/**
	 * Display the screen for the Check in/out emulator,
	 * and other informations such as the Time, the Date and the Time rounded to the nearest quarter hour.
	 * There's also a text area where you put the ID of an employee, then a button to Check in or Check out.
	 * 
	 * @param	primaryStage	To set the screen of the emulator.
	 */
	@Override
	public void start(Stage primaryStage)
	{
		ClockEmulator.primaryStage = primaryStage;
		
		try
		{
			//** The settings of the window displayed **//
			root = FXMLLoader.load(getClass().getResource("/fr/univtours/polytech/ptjavapointeuse/emulatorapp/view/EmulatorApplicationView.fxml"));

			Scene scene = new Scene(root, 640, 400);
			ClockEmulator.primaryStage.setTitle("PT_JAVA_Pointeuse : Application Pointeuse");	       
			ClockEmulator.primaryStage.setScene(scene);
			ClockEmulator.primaryStage.show();

			//** To refresh the time/date indicated of the emulator **//
			new Thread(new ClockEmulatorLive()).start();
		}
		
		//** If there is any problem occurring during the start of the application **/
		catch (Exception error)
		{
			error.printStackTrace();
		}
	}

	/**
	 * Launches the application, the function start (above).
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		launch(args);
	}
}