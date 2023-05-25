package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppCentrale extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			/*BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());*/
			
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Scene scene = new Scene(grid, 400, 400);
			primaryStage.setScene(scene);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("PT_JAVA_Pointeuse : Application Centrale");
			primaryStage.show();
			
			String message = new TCPServerMessage().recevoir();
			
			Text scenetitle = new Text(message);
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
			grid.add(scenetitle, 0, 0, 2, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
