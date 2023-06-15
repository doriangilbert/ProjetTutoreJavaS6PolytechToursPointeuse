package fr.univtours.polytech.ptjavapointeuse.centralapp.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * the Employee class containing information about an employee!
 */
public class Employee implements Serializable
{
	public static int IdCounter=1;
	private transient StringProperty id;
	private transient StringProperty FirstName;
	private transient StringProperty LastName;
	private List<Check> ListCheck;
	private HashMap<DayOfWeek,LocalTime> StartWork;
	private HashMap<DayOfWeek,LocalTime> EndWork;
	
	/**
	 * Method to have "default" attributes for a new class.
	 */
	private void InitProperties()
	{
		this.id = new SimpleStringProperty();
		this.FirstName = new SimpleStringProperty();
		this.LastName = new SimpleStringProperty();
		ListCheck = new ArrayList<>();
		StartWork= new HashMap<>();
		EndWork= new HashMap<>();
		//** Default value: the employee works from 8 to 16 everyday **//
		for (DayOfWeek DOW : DayOfWeek.values())
		{
			StartWork.put(DOW, LocalTime.of(8, 0));
			EndWork.put(DOW, LocalTime.of(16, 0));
		}	
	}

	/**
	 * Default constructor, use the previous method to create an object with default attributes.
	 * Each time an employee is created, we increase the number for the ID.
	 */
	public Employee()
	{
		InitProperties();
		IdCounter++;
	}

	/**
	 * Comfort builder, create an object Employee initialized with a first name and a surname.
	 * 
	 * @param 	FirstName	The first name of the future Employee.
	 * @param 	LastName	The surname of the future Employee.
	 */
	public Employee(String FirstName, String LastName)
	{
		InitProperties();
		this.id.set(String.valueOf(IdCounter));
		this.FirstName = new SimpleStringProperty(FirstName);
		this.LastName = new SimpleStringProperty(LastName);
		ListCheck = new ArrayList<>();
		IdCounter++;
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
	 * Getter of the attribute "FirstName".
	 * 
	 * @return	The first name of the employee.
	 */
	public String getFirstName()
	{
		return FirstName.get();
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
	 * Getter of the attribute "ListCheck".
	 * 
	 * @return	The checks' list of the employee.
	 */
	public List<Check> getListCheck()
	{
		return ListCheck;
	}
	
	/**
	 * Getter of the attribute "StartWork".
	 * We want to know when (HH:MM) the worker is supposed to start on a specific day.
	 * 
	 * @param dow	The day of the week 
	 * @return		The time when he is supposed to start working.
	 */
	public LocalTime getStartWorkDayTime(DayOfWeek dow)
	{
		return StartWork.get(dow);
	}
	
	/**
	 * Setter for the attribute "StartWork".
	 * We want to change the time when the worker is supposed to start on the chosen day.
	 * 
	 * @param 	dow	The new time when he is supposed to start.
	 * @param 	lt	The chosen day where we want to change the time to start working.
	 */
	public void setStartWorkDayTime(DayOfWeek dow,LocalTime lt)
	{
		StartWork.replace(dow, lt);
	}
	
	/**
	 * Getter of the attribute "EndWork".
	 * We want to know when (HH:MM) the worker is supposed to stop on a specific day.
	 * 
	 * @param dow	The day of the week 
	 * @return		The time when he is supposed to stop working.
	 */
	public LocalTime getEndWorkDayTime(DayOfWeek dow)
	{
		return EndWork.get(dow);
	}
	
	/**
	 * Setter for the attribute "EndWork".
	 * We want to change the time when the worker is supposed to stop on the chosen day.
	 * 
	 * @param 	dow	The new time when he is supposed to stop.
	 * @param 	lt	The chosen day where we want to change the time to stop working.
	 */
	public void setEndWorkDayTime(DayOfWeek dow,LocalTime lt)
	{
		EndWork.replace(dow, lt);
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
	 * Setter for the attribute "FirstName".
	 * 
	 * @param firstName the first name to set
	 */
	public void setFirstName(String firstName)
	{
		FirstName = new SimpleStringProperty(firstName);
	}

	/**
	 * Setter for the attribute "LastName".
	 * 
	 * @param lastName the last name to set
	 */
	public void setLastName(String lastName)
	{
		LastName = new SimpleStringProperty(lastName);
	}

	/**
	 * Add a check to an employee that started or stopped working (check in/out).
	 * 
	 * @param CheckParam	The check we want to add to the ListCheck of the employee.
	 */
	public void addCheck(Check CheckParam)
	{
		ListCheck.add(CheckParam);
	}

	/**
	 * To delete a check from the list of an employee
	 * 
	 * @param CheckParam	The check we want to remove.
	 */
	public void deleteCheck(Check CheckParam)
	{
		//** We verify if the check exists for this employee **//
		if (ListCheck.stream().map(Check::getDate).anyMatch(CheckParam.getDate()::equals))
		{
			//** Before removing it **//
			ListCheck.remove(CheckParam);
		}
	}

	/**
	 * 
	 * @param s
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream s) throws IOException
	{
		s.defaultWriteObject();
		s.writeUTF(id.getValueSafe());
		s.writeUTF(FirstName.getValueSafe());
		s.writeUTF(LastName.getValueSafe());
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
		id.set(s.readUTF());
		FirstName.set(s.readUTF());
		LastName.set(s.readUTF());

		// set values in the same order as writeObject()
	}
}
