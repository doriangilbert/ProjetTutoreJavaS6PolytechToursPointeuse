package application;

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
	 * Function to send an ID via a TCP Message.
	 * It makes a copy of the ID entered, then send it to the Central Application.
	 * After that, it refreshes the text area where we put the ID to enter a new one.
	 * 
	 * @param	event	The type of event that occurred. In this case, a "left-mouse click" on a button that activates this function.
	 */
	@FXML
	protected void handleButtonCheckInOutAction(ActionEvent event)
	{
		textFieldCheckInOut = (TextField) ClockEmulator.root.lookup("#textFieldCheckInOut");
		String message = textFieldCheckInOut.getText();
		System.out.println("ClockEmulator : Message Sent : " + message);
		new TCPClientMessage().send(message);
		textFieldCheckInOut.clear();
	}
}
