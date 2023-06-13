package application;

import java.time.LocalDateTime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller of the ClockEmulator class!
 * Calculates some elements that will be displayed on a window.
 * Here, we only need it to send messages between the Emulator and the Central Application.
 */
public class ClockEmulatorController
{
	@FXML
	private TextField textFieldCheckInOut;

	/**
	 * Function to send an ID, the current date and a rounded version of the current time via a TCP Message.
	 * It makes a copy of the ID entered and the other 2 elements, then send it to the Central Application.
	 * After that, it refreshes the text area where we put the ID to enter a new one.
	 * 
	 * @param	event	The type of event that occurred. In this case, a "left-mouse click" on a button that activates this function.
	 */
	@FXML
	protected void handleButtonCheckInOutAction(ActionEvent event)
	{
		textFieldCheckInOut = (TextField) ClockEmulator.root.lookup("#textFieldCheckInOut");
		String message = textFieldCheckInOut.getText();
		message = LocalDateTime.now().getDayOfMonth() + "/"
				+ LocalDateTime.now().getMonthValue() + "/"
				+ LocalDateTime.now().getYear() + ","
				+ ClockEmulatorLive.RoundHour(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()) + ","
				+ message;
		System.out.println("ClockEmulator : Message Sent : " + message);
		new TCPClientMessage().send(message);
		textFieldCheckInOut.clear();
	}
}
