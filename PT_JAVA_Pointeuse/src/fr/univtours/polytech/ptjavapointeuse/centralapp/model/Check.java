package fr.univtours.polytech.ptjavapointeuse.centralapp.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * the Check class containing information about a check in or a check out!
 */
public class Check implements Serializable
{
	public transient BooleanProperty IsACheckIn;
	public transient BooleanProperty IsAnError;
	public transient ObjectProperty<LocalDateTime> date;
	
	/**
	 * Method to have "default" attributes for a new class.
	 */
	private void InitProperties()
	{
		this.IsACheckIn = new SimpleBooleanProperty();
		this.IsAnError = new SimpleBooleanProperty();
		this.date = new SimpleObjectProperty<>();
	}

	/**
	 * Default constructor, use the previous method to create an object with default attributes.
	 */
	public Check()
	{
		InitProperties();
	}

	/**
	 * Comfort builder, create an object initialized with all chosen arguments.
	 * 
	 * @param IsACheckIn	Boolean to know if the check's type is "in" or "out".
	 * @param IsAnError		Boolean to know if the employee checked at the good time or if he is late/early.
	 * @param date			The date when the check was made.
	 */
	public Check(boolean IsACheckIn, boolean IsAnError, LocalDateTime date)
	{
		InitProperties();
		this.IsACheckIn = new SimpleBooleanProperty(IsACheckIn);
		this.IsAnError = new SimpleBooleanProperty(IsAnError);
		this.date = new SimpleObjectProperty<>(date);
	}

	/**
	 * Getter of the attribute "IsACheckIn".
	 * 
	 * @return	The type of the check (in or out).
	 */
	public boolean getisACheckIn()
	{
		return IsACheckIn.get();
	}

	/**
	 * Getter of the attribute "IsAnError".
	 * 
	 * @return	If the employee was on time or not.
	 */
	public boolean getisAnError()
	{
		return IsAnError.get();
	}

	/**
	 * Getter of the attribute "date".
	 * 
	 * @return	The date when the check was created.
	 */
	public LocalDateTime getDate()
	{
		return date.get();
	}

	/**
	 * Setter for the attribute "IsACheckIn".
	 * 
	 * @param IsACheckIn	The type of the check (in or out).	
	 */
	public void setIsACheckIn(boolean IsACheckIn)
	{
		this.IsACheckIn = new SimpleBooleanProperty(IsACheckIn);
	}

	/**
	 * Setter for the attribute "IsAnError".
	 * 
	 * @param IsAnError		If the employee was on time or not.
	 */
	public void setIsAnError(boolean IsAnError)
	{
		this.IsAnError = new SimpleBooleanProperty(IsAnError);
	}

	/**
	 * 
	 * @param s
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream s) throws IOException
	{
		s.defaultWriteObject();
		s.writeBoolean(IsACheckIn.getValue());
		s.writeBoolean(IsAnError.getValue());
		s.writeObject(date.getValue());

	}

	/**
	 * 
	 * @param s
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException
	{
		InitProperties();
		s.defaultReadObject();
		IsACheckIn.set(s.readBoolean());
		IsAnError.set(s.readBoolean());
		date.set((LocalDateTime) s.readObject());
		// set values in the same order as writeObject()
	}
}
