package application;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller of the ClockEmulator class! Calculates some elements that will be
 * displayed on a window. Here, we only need it to send messages between the
 * Emulator and the Central Application.
 */
public class ClockEmulatorController {
	@FXML
	private TextField textFieldCheckInOut;

	/**
	 * Function to send an ID and a timestamp (number of seconds that have passed
	 * since January 1 1970 00:00) corresponding to the current date and a rounded
	 * version of the current time via a TCP Message. It makes a copy of the ID
	 * entered and the timestamp, then send it to the Central Application. After
	 * that, it refreshes the text area where we put the ID to enter a new one.
	 * 
	 * @param event The type of event that occurred. In this case, a "left-mouse
	 *              click" on a button that activates this function.
	 */
	@FXML
	protected void handleButtonCheckInOutAction(ActionEvent event) {
		textFieldCheckInOut = (TextField) ClockEmulator.root.lookup("#textFieldCheckInOut");
		String employeeId = textFieldCheckInOut.getText();
		String roundTime = ClockEmulatorLive.RoundHour(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());
		String[] parsedRoundTime = roundTime.split(":");
		LocalDateTime toSendLocalDateTime = LocalDateTime.of(LocalDateTime.now().getYear(),
				LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth(),
				Integer.parseInt(parsedRoundTime[0]), Integer.parseInt(parsedRoundTime[1]));
		long timeStamp = toSendLocalDateTime.atZone(ZoneId.systemDefault()).toEpochSecond();
		String message = timeStamp + "," + employeeId;
		System.out.println("ClockEmulator : Message Sent : " + message);
		new TCPClientMessage().send(message);
		textFieldCheckInOut.clear();
	}
}
