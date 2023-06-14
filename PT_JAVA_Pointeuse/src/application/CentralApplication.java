package application;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * View of the CentralApplication class!
 * Display every elements on a window.
 */
public class CentralApplication extends Application
{

	public static Stage primaryStage;
	public static Parent root;

	public static int IdCounter=1;
	public static Enterprise Enterprise1=new Enterprise();
	
	/**
	 * Display the screen for the Central application,
	 * In the FXML file (CentralApplicationView.fxml) , linked to this file,
	 * you will find other objects such as buttons and titles
	 * to navigate through all the pages of the application.
	 * 
	 * @param	primaryStage	To set the screen of the emulator.
	 */
	@Override
	public void start(Stage primaryStage)
	{
		CentralApplication.primaryStage = primaryStage;

		try
		{
			//** The settings of the window displayed **//
			root = FXMLLoader.load(getClass().getResource("CentralApplicationView.fxml"));

			Scene scene = new Scene(root, 640, 400);
			CentralApplication.primaryStage.setTitle("PT_JAVA_Pointeuse : Application Centrale");
			CentralApplication.primaryStage.setScene(scene);
			CentralApplication.primaryStage.show();

			//** The file for the serialization **//
			File Fichier = new File("Enterprise1.dat");
			
			//** We verify if the file exists **//
			if (Fichier.exists())
			{
				//** And we display all the informations from this file **//
				CentralApplication.Enterprise1 = CentralApplicationSerialization.Deserialization("Enterprise1.dat");
				System.out.println(Enterprise1.getName());
			}
			
			//** We create threads to save every possible modifications every 5 seconds **//
			//new Thread(new CentralApplicationSerialization()).start();
			//** We also make a thread to read the content of in coming Check (via TCP message) **//
			new Thread(new TCPServerMessage()).start();
		}
		
		//** If there is any problem occurring during the start of the application **//
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
