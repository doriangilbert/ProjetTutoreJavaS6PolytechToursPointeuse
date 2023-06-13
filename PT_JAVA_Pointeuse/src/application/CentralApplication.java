package application;

import static java.lang.Thread.sleep;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

	public static Enterprise Enterprise1;
	
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
			File Fichier = new File("Entreprise1.dat");
			Enterprise1 = new Enterprise();
			
			//** We verify if the file exists **//
			if (Fichier.exists())
			{
				//** And we display all the informations from this file **//
				Enterprise1 = Deserialization("Entreprise1.dat");
				System.out.println(Enterprise1.getName());
			}
			
			//** We create threads to save every possible modifications every 5 seconds **//
			new Thread(new CentralApplicationSerialization()).start();
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

	/**
	 * Write all information of an enterprise (on the application) in a file
	 * 
	 * @param 	NomFichier	The directory of the file to put all the information into.
	 * @throws 	IOException
	 * @throws 	InterruptedException
	 */
	public static void Serialization(String NomFichier) throws IOException, InterruptedException
	{
		while (true)
		{
			//** To write a text inside a file **//
			FileOutputStream fos = new FileOutputStream(NomFichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Enterprise1);
			oos.close();
			//** We do that every 5 seconds (to save any possible modifications) **//
			sleep(5000);
		}
	}

	/**
	 * Take out all information of an enterprise from a file
	 * 
	 * @param	NomFichier	The directory of the file to take all the information from.
	 * @return				The information of a certain enterprise stocked in the file.
	 * @throws	IOException	
	 */
	public static Enterprise Deserialization(String NomFichier) throws IOException
	{
		//** To read the text in a file **//
		FileInputStream fis = new FileInputStream(NomFichier);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Enterprise enterpriseParam = new Enterprise();
		try
		{
			enterpriseParam = (Enterprise) ois.readObject();
		}
		
		catch (ClassNotFoundException error)
		{

		}
		ois.close();
		return enterpriseParam;
	}
}
