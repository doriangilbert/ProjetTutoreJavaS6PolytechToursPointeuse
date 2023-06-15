package application;

import java.time.LocalDateTime;

import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 * Thread for the ClockEmulator class! Every 10 seconds, calculates/refreshes
 * the current time, date and the approximate time (to the nearest quarter
 * hour).
 */
public class ClockEmulatorLive implements Runnable
{
	
	/**
	 * To find and send the current date, time and the approximation of the time.
	 * This function refreshes these elements every 1 second.
	 */
	public void run() {
		do {
			if (ClockEmulator.isOnMainPage) {
				// ** To have the current date **//
				Label labelDate = (Label) ClockEmulator.root.lookup("#labelDate");
				Platform.runLater(() -> labelDate
						.setText(LocalDateTime.now().getDayOfWeek() + " " + LocalDateTime.now().getDayOfMonth() + " "
								+ LocalDateTime.now().getMonth() + " " + LocalDateTime.now().getYear()));

				// ** To have the current time **//
				Label labelHour = (Label) ClockEmulator.root.lookup("#labelHour");
				Platform.runLater(() -> labelHour
						.setText(LocalDateTime.now().getHour() + ":" + LongMinute(LocalDateTime.now().getMinute())));

				// ** To have the approximate time **//
				Label labelRoundHour = (Label) ClockEmulator.root.lookup("#labelRoundHour");
				Platform.runLater(() -> labelRoundHour
						.setText(RoundHour(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute())));

			}
			try {
				// ** Sleep for 1 second **/
				Thread.sleep(1000);
			}

			// ** If there is an error with the thread **//
			catch (InterruptedException error) {
				error.printStackTrace();
			}
		} while (true);
	}

	/**
	 * If the number of minute is inferior to 10, add a 0 before the number to keep
	 * the same format: HH:MM instead of HH:M when minute < 10.
	 * 
	 * @param minute The number of minutes.
	 * @return If minute < 10, return a String with a 0 accompanied by the number of
	 *         minutes after Else, return minute
	 */
	public static String LongMinute(int minute) {
		String longMinute = "";
		if (minute < 10) {
			longMinute = "0" + minute;
		} else {
			longMinute = "" + minute;
		}
		return longMinute;
	}

	/**
	 * Approximates the current time to the nearest quarter of an hour.
	 * 
	 * @param hour   The current number of hour (spent during this day).
	 * @param minute The current number of minutes (spent during this hour).
	 * @return A String with the approximate time in a format HH:MM.
	 */
	public static String RoundHour(int hour, int minute) {
		String longHour = "";
		if (minute < 8) {
			longHour = hour + ":00";
		}

		else if (minute >= 8 && minute < 23) {
			longHour = hour + ":15";
		}

		else if (minute >= 23 && minute < 38) {
			longHour = hour + ":30";
		}

		else if (minute >= 38 && minute < 53) {
			longHour = hour + ":45";
		}

		else {
			longHour = (hour + 1) + ":00";
		}
		return longHour;
	}
}
