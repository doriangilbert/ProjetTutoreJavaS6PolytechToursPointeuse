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

public class AppCentrale extends Application {

	public static Stage primaryStage;
	public static Parent root;

	public static Enterprise Enterprise1;

	@Override
	public void start(Stage primaryStage) {

		AppCentrale.primaryStage = primaryStage;

		try {
			root = FXMLLoader.load(getClass().getResource("AppCentraleView.fxml"));

			Scene scene = new Scene(root, 640, 400);

			AppCentrale.primaryStage.setTitle("PT_JAVA_Pointeuse : Application Centrale");
			AppCentrale.primaryStage.setScene(scene);
			AppCentrale.primaryStage.show();

			File Fichier = new File("Entreprise1.dat");
			Enterprise1 = new Enterprise();
			if (Fichier.exists()) {
				Enterprise1 = Deserialization("Entreprise1.dat");
				System.out.println(Enterprise1.getName());
			}
			new Thread(new AppCentraleSerialization()).start();
			new Thread(new TCPServerMessage()).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void Serialization(String NomFichier) throws IOException, InterruptedException {
		while (true) {
			FileOutputStream fos = new FileOutputStream(NomFichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Enterprise1);
			oos.close();
			sleep(5000);
		}
	}

	public static Enterprise Deserialization(String NomFichier) throws IOException {
		FileInputStream fis = new FileInputStream(NomFichier);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Enterprise enterpriseParam = new Enterprise();
		try {
			enterpriseParam = (Enterprise) ois.readObject();
		} catch (ClassNotFoundException e) {

		}
		ois.close();
		return enterpriseParam;
	}
}
