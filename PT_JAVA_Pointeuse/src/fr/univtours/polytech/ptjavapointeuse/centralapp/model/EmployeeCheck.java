package fr.univtours.polytech.ptjavapointeuse.centralapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class to regroup all information for the check in/out history page!
 */
public class EmployeeCheck
{
	private transient ObjectProperty<LocalDate> date;
	private transient ObjectProperty<LocalTime> time;
	private transient StringProperty id;
	private transient StringProperty FirstName;
	private transient StringProperty LastName;
	private transient StringProperty type;

	/**
	 * Method to have "default" attributes for a new class.
	 */
	private void InitProperties() 
	{
		this.date = new SimpleObjectProperty<>();
		this.time = new SimpleObjectProperty<>();
		this.id = new SimpleStringProperty();
		this.FirstName = new SimpleStringProperty();
		this.LastName = new SimpleStringProperty();
		this.type = new SimpleStringProperty();
	}
	
	/**
	 * Default constructor, use the previous method to create an object with default attributes.
	 */
	public EmployeeCheck() 
	{
		InitProperties();
	}

	/**
	 * Comfort builder, create an object initialized with all chosen arguments.
	 * 
	 * @param date			The day when the check was made.
	 * @param time			The approximate time when the check was made.
	 * @param id			The employee's identification.
	 * @param FirstName		The employee's first name.
	 * @param LastName		The employee's last name.
	 * @param type			The type of the check (in or out).
	 */
	public EmployeeCheck(LocalDate date, LocalTime time, String id, String FirstName, String LastName, String type) 
	{
		InitProperties();
		this.date = new SimpleObjectProperty<>(date);
		this.time = new SimpleObjectProperty<>(time);
		this.id = new SimpleStringProperty(id);
		this.FirstName = new SimpleStringProperty(FirstName);
		this.LastName = new SimpleStringProperty(LastName);
		this.type = new SimpleStringProperty(type);
	}

	/**
	 * Getter of the attribute "date".
	 * 
	 * @return	The date when the check was made.
	 */
	public LocalDate getDate() 
	{
		return date.get();
	}

	/**
	 * Setter for the attribute "date".
	 * 
	 * @param type 	The date when the check was made.
	 */
	public void setDate(LocalDate date) 
	{
		this.date = new SimpleObjectProperty<>(date);
	}

	/**
	 * Getter of the attribute "time".
	 * 
	 * @return	The approximate time when the check was made.
	 */
	public LocalTime getTime() 
	{
		return time.get();
	}

	/**
	 * Setter for the attribute "time".
	 * 
	 * @param type 	The time when the check was made.
	 */
	public void setTime(LocalTime time) 
	{
		this.time = new SimpleObjectProperty<>(time);
	}

	/**
	 * Getter of the attribute "id".
	 * 
	 * @return	The ID of the employee.
	 */
	public String getId() 
	{
		return id.get();
	}

	/**
	 * Setter for the attribute "id".
	 * 
	 * @param id the id to set
	 */
	public void setId(String id) 
	{
		this.id = new SimpleStringProperty(id);
	}

	/**
	 * Getter of the attribute "FirstName".
	 * 
	 * @return	The first name of the employee.
	 */
	public String getFirstName() 
	{
		return FirstName.get();
	}

	/**
	 * Setter for the attribute "FirstName".
	 * 
	 * @param firstName the first name to set
	 */
	public void setFirstName(String FirstName) 
	{
		this.FirstName = new SimpleStringProperty(FirstName);
	}

	/**
	 * Getter of the attribute "LastName".
	 * 
	 * @return	The last name of the employee.
	 */
	public String getLastName() 
	{
		return LastName.get();
	}

	/**
	 * Setter for the attribute "LastName".
	 * 
	 * @param lastName the last name to set
	 */
	public void setLastName(String LastName) 
	{
		this.LastName = new SimpleStringProperty(LastName);
	}

	/**
	 * Getter of the attribute "type".
	 * 
	 * @return	The type of the check (in or out).
	 */
	public String getType() 
	{
		return type.get();
	}

	/**
	 * Setter for the attribute "type".
	 * 
	 * @param type 	The type of the check (in or out).
	 */
	public void setType(String type) 
	{
		this.type = new SimpleStringProperty(type);
	}

}
