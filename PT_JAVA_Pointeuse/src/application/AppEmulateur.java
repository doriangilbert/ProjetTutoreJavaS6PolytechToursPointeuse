package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.time.LocalDateTime;

public class AppEmulateur extends Application
{
	public static Stage primaryStage;
	public static Parent root;
	
	@Override
	public void start(Stage primaryStage)
	{
		AppEmulateur.primaryStage = primaryStage;
		try
		{
			/*
			 * BorderPane root = new BorderPane(); Scene scene = new Scene(root, 400, 400);
			 * scene.getStylesheets().add(getClass().getResource("application.css").
			 * toExternalForm());
			 */
			
//			//creation of a window for the TimeClock
//			GridPane grid = new GridPane();
//			grid.setAlignment(Pos.CENTER);
//			grid.setHgap(10);
//			grid.setVgap(10);
//			grid.setPadding(new Insets(25, 25, 25, 25));
//
//			Scene scene = new Scene(grid, 600, 300);
//			primaryStage.setScene(scene);
//
//			primaryStage.setScene(scene);
//			primaryStage.setResizable(false);
//			primaryStage.setTitle("PT_JAVA_Pointeuse : Application Emulateur");
//			primaryStage.show();
//			
//
//			// Button for check in and check out
//			Button button = new Button("Check in/out");
//			DropShadow shadow = new DropShadow();
//			
//			/******************Display informations******************/
//			// TextArea to put the Date
//			final Label date = new Label(LocalDateTime.now().getDayOfWeek()
//					+ " " + LocalDateTime.now().getDayOfMonth()
//					+ " " + LocalDateTime.now().getMonth()
//					+ " " + LocalDateTime.now().getYear());
//	        GridPane.setConstraints(date, 1, 1);
//	        date.setFont(new Font("Arial", 18));
//	        date.setTextFill(Color.web("black"));
//	        
//	        // TextArea to put the Hour
// 			final Label hour = new Label(LocalDateTime.now().getHour()
// 					+ ":" + LongMinute(LocalDateTime.now().getMinute()));
// 	        GridPane.setConstraints(hour, 1, 1);
// 	        hour.setFont(new Font("Arial", 30));
// 	        
// 	        
// 	        // TextArea to put the Approximation of the Hour
// 			final Label roundHour = new Label(RoundHour(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()));
// 	        GridPane.setConstraints(roundHour, 1, 1);
// 	        roundHour.setFont(new Font("Arial", 30));
//
// 	        /******************Shadow effect button******************/
//			// Adding the shadow when the mouse cursor is on
//			button.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>()
//			{
//				@Override
//				public void handle(MouseEvent e)
//				{
//					button.setEffect(shadow);
//				}
//			});
//
//			// Removing the shadow when the mouse cursor is off
//			button.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>()
//			{
//				@Override
//				public void handle(MouseEvent e)
//				{
//					button.setEffect(null);
//				}
//			});
//			/******************Shadow effect button******************/
//
//			//root.getChildren().addAll(button1);
//
//			TextField userTextField = new TextField();
//			grid.add(userTextField, 1, 1);
//			
//			HBox hbBtn = new HBox(10);
//			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//			hbBtn.getChildren().setAll(button, date, hour, roundHour);
//			grid.add(hbBtn, 1, 4);
//			final Text actiontarget = new Text();
//			grid.add(actiontarget, 1, 6);
//
//			button.setOnAction(new EventHandler<ActionEvent>() {
//				@Override
//				public void handle(ActionEvent e) {
//					actiontarget.setFill(Color.FIREBRICK);
//					actiontarget.setText("Check sent !");
//					String message = userTextField.getText();
//					System.out.println("AppEmulateur : Message Sent : " + message);
//					new TCPClientMessage().send(message);
//					start(primaryStage);
//				}
//			});
//
//				/*
//				 * TextField userTextField = new TextField(); grid.add(userTextField, 1, 1);
//				 * Button btn = new Button("Check in/out"); HBox hbBtn = new HBox(10);
//				 * hbBtn.setAlignment(Pos.BOTTOM_RIGHT); hbBtn.getChildren().add(btn);
//				 * grid.add(hbBtn, 1, 4); final Text actiontarget = new Text();
//				 * grid.add(actiontarget, 1, 6);
//				 * 
//				 */
			
			root = FXMLLoader.load(getClass().getResource("AppEmulateurView.fxml"));
		    
	        Scene scene = new Scene(root, 640, 400);
	    
	        AppEmulateur.primaryStage.setTitle("PT_JAVA_Pointeuse : Application Emulateur");
	        AppEmulateur.primaryStage.setScene(scene);
	        AppEmulateur.primaryStage.show();
	        
	        Label labelDate = (Label) root.lookup("#labelDate");
	        labelDate.setText(LocalDateTime.now().getDayOfWeek() + " " + LocalDateTime.now().getDayOfMonth() + " " + LocalDateTime.now().getMonth() + " " + LocalDateTime.now().getYear());
	        
	        Label labelHour = (Label) root.lookup("#labelHour");
	        labelHour.setText(LocalDateTime.now().getHour() + ":" + LongMinute(LocalDateTime.now().getMinute()));
	        
	        Label labelRoundHour = (Label) root.lookup("#labelRoundHour");
	        labelRoundHour.setText(RoundHour(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()));
	        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
	
	public String LongMinute(int minute)
	{
		String longMinute = "";
		if (minute < 10)
		{
			longMinute = "0" + minute;
		}
		else
		{
			longMinute = "" + minute;
		}
		return longMinute;
	}
	
	public String RoundHour(int hour, int minute)
	{
		String longHour = "";
		if (minute < 8)
		{
			 longHour = hour + ":00";
		}
		
		else if (minute >= 8 && minute < 23)
		{
			 longHour = hour + ":15";
		}
		
		else if (minute >= 23 && minute < 38)
		{
			 longHour = hour + ":30";
		}
		
		else if (minute >= 38 && minute < 53)
		{
			 longHour = hour + ":45";
		}
		
		else
		{
			 longHour = (hour + 1) + ":00";
		}
		return longHour;
	}
}