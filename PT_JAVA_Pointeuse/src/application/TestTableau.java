package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestTableau extends Application {
	// public static Stage primaryStage;
	private ListView<String> listview1;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		/*
		 * BorderPane borderPaneRoot =
		 * FXMLLoader.load(getClass().getResource("ACStaffManagementView.fxml")); Scene
		 * scene = new Scene(borderPaneRoot, 600, 400); primaryStage.setScene(scene);
		 * primaryStage.show();
		 */

		BorderPane borderPaneRoot = new BorderPane();
		Scene scene = new Scene(borderPaneRoot, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Fruits");
		HBox hBox1 = new HBox();
		hBox1.setPadding(new Insets(10));
		hBox1.setSpacing(10);
		Label labelNom = new Label("Fruit:");
		labelNom.setPadding(new Insets(5));
		TextField textFieldNom = new TextField();
		Button buttonAdd = new Button("Ajouter");
		hBox1.getChildren().addAll(labelNom, textFieldNom, buttonAdd);
		VBox vBox1 = new VBox();
		vBox1.setPadding(new Insets(10));
		listview1 = new ListView<>();
		listview1.getItems().add("some new element");
		listview1.getItems().add("Oranges");
		listview1.getItems().add("Bananes");
		vBox1.getChildren().add(listview1);
		borderPaneRoot.setTop(hBox1);
		borderPaneRoot.setCenter(vBox1);
		// Scene scene = new Scene(borderPaneRoot, 600, 400);

		primaryStage.show();
		// System.out.println(listview1);*/

	}
}
