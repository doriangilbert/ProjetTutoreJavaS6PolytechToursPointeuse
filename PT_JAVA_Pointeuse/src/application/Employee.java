package application;

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

public class Employee implements Serializable
{
	private transient StringProperty id;
	private transient StringProperty FirstName;
	private transient StringProperty LastName;
	private List<Check> ListCheck;
	private HashMap<DayOfWeek,LocalTime> StartWork;
	private HashMap<DayOfWeek,LocalTime> EndWork;
	

	private void InitProperties()
	{
		this.id = new SimpleStringProperty();
		this.FirstName = new SimpleStringProperty();
		this.LastName = new SimpleStringProperty();
		ListCheck = new ArrayList<>();
		StartWork= new HashMap<>();
		EndWork= new HashMap<>();
		for (DayOfWeek DOW : DayOfWeek.values())
		{
			StartWork.put(DOW, LocalTime.of(8, 0));
			EndWork.put(DOW, LocalTime.of(16, 0));
		}
		
	}

	public Employee()
	{
		InitProperties();
	}

	public Employee(String id, String FirstName, String LastName)
	{
		InitProperties();
		this.id = new SimpleStringProperty(id);
		this.FirstName = new SimpleStringProperty(FirstName);
		this.LastName = new SimpleStringProperty(LastName);
		ListCheck = new ArrayList<>();
	}

	public String getId()
	{
		return id.get();
	}

	public String getFirstName()
	{
		return FirstName.get();
	}

	public String getLastName()
	{
		return LastName.get();
	}

	public List<Check> getListCheck()
	{
		return ListCheck;
	}
	
	public LocalTime getStartWorkDayTime(DayOfWeek dow)
	{
		return StartWork.get(dow);
	}
	
	public void setStartWorkDayTime(DayOfWeek dow,LocalTime lt)
	{
		StartWork.replace(dow, lt);
	}
	
	public LocalTime getEndWorkDayTime(DayOfWeek dow)
	{
		return EndWork.get(dow);
	}
	
	public void setEndWorkDayTime(DayOfWeek dow,LocalTime lt)
	{
		EndWork.replace(dow, lt);
	}
	
	public void setId(String id)
	{
		this.id = new SimpleStringProperty(id);
	}

	public void setFirstName(String firstName)
	{
		FirstName = new SimpleStringProperty(firstName);
	}

	public void setLastName(String lastName)
	{
		LastName = new SimpleStringProperty(lastName);
	}

	public void addCheck(Check CheckParam)
	{
		ListCheck.add(CheckParam);
	}

	public void deleteCheck(Check CheckParam)
	{
		if (ListCheck.stream().map(Check::getDate).anyMatch(CheckParam.getDate()::equals))
		{
			ListCheck.remove(CheckParam);
		}
	}

	private void writeObject(ObjectOutputStream s) throws IOException
	{
		s.defaultWriteObject();
		s.writeUTF(id.getValueSafe());
		s.writeUTF(FirstName.getValueSafe());
		s.writeUTF(LastName.getValueSafe());
	}

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
