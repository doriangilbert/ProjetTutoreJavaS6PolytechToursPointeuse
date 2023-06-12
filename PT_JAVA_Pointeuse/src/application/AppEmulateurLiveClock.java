package application;

import java.time.LocalDateTime;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class AppEmulateurLiveClock implements Runnable {
	public void run() {
		do {
			Label labelDate = (Label) AppEmulateur.root.lookup("#labelDate");
			Platform.runLater(() -> labelDate
					.setText(LocalDateTime.now().getDayOfWeek() + " " + LocalDateTime.now().getDayOfMonth() + " "
							+ LocalDateTime.now().getMonth() + " " + LocalDateTime.now().getYear()));

			Label labelHour = (Label) AppEmulateur.root.lookup("#labelHour");
			Platform.runLater(() -> labelHour
					.setText(LocalDateTime.now().getHour() + ":" + LongMinute(LocalDateTime.now().getMinute())));

			Label labelRoundHour = (Label) AppEmulateur.root.lookup("#labelRoundHour");
			Platform.runLater(() -> labelRoundHour
					.setText(RoundHour(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute())));

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}

	public String LongMinute(int minute) {
		String longMinute = "";
		if (minute < 10) {
			longMinute = "0" + minute;
		} else {
			longMinute = "" + minute;
		}
		return longMinute;
	}

	public String RoundHour(int hour, int minute) {
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
