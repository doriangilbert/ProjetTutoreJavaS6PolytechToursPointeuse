package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Check implements Serializable {
	public transient BooleanProperty IsACheckIn;
	public transient BooleanProperty IsAnError;
	public transient ObjectProperty<Date> date;
	public transient IntegerProperty hour;
	public transient IntegerProperty minutes;

	private void InitProperties() {
		this.IsACheckIn = new SimpleBooleanProperty();
		this.IsAnError = new SimpleBooleanProperty();
		this.date = new SimpleObjectProperty<>();
		this.hour = new SimpleIntegerProperty();
		this.minutes = new SimpleIntegerProperty();
	}

	public Check() {
		InitProperties();
	}

	public Check(boolean IsACheckIn, boolean IsAnError, Date date, int hour, int minutes) {
		this.IsACheckIn = new SimpleBooleanProperty(IsACheckIn);
		this.IsAnError = new SimpleBooleanProperty(IsAnError);
		this.date = new SimpleObjectProperty<>(date);
		this.hour = new SimpleIntegerProperty(hour);
		this.minutes = new SimpleIntegerProperty(minutes);
	}

	public boolean getisACheckIn() {
		return IsACheckIn.get();
	}

	public boolean getisAnError() {
		return IsAnError.get();
	}

	public Date getDate() {
		return date.get();
	}

	public int getHour() {
		return hour.get();
	}

	public int getMinutes() {
		return minutes.get();
	}

	public void setIsACheckIn(boolean IsACheckIn) {
		this.IsACheckIn = new SimpleBooleanProperty(IsACheckIn);
	}

	public void setIsAnError(boolean IsAnError) {
		this.IsAnError = new SimpleBooleanProperty(IsAnError);
	}

	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();
		s.writeBoolean(IsACheckIn.getValue());
		s.writeBoolean(IsAnError.getValue());
		s.writeObject(date.getValue());
		s.writeInt(hour.getValue());
		s.writeInt(minutes.getValue());
	}

	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		InitProperties();
		s.defaultReadObject();
		IsACheckIn.set(s.readBoolean());
		IsAnError.set(s.readBoolean());
		date.set((Date) s.readObject());
		hour.set(s.readInt());
		minutes.set(s.readInt());
		// set values in the same order as writeObject()
	}
}
