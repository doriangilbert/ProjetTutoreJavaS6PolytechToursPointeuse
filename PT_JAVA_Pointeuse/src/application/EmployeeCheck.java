package application;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeCheck {
	private transient ObjectProperty<LocalDate> date;
	private transient ObjectProperty<LocalTime> time;
	private transient StringProperty id;
	private transient StringProperty FirstName;
	private transient StringProperty LastName;
	private transient StringProperty type;

	private void InitProperties() 
	{
		this.date = new SimpleObjectProperty<>();
		this.time = new SimpleObjectProperty<>();
		this.id = new SimpleStringProperty();
		this.FirstName = new SimpleStringProperty();
		this.LastName = new SimpleStringProperty();
		this.type = new SimpleStringProperty();
	}
	
	public EmployeeCheck() 
	{
		InitProperties();
	}

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

	public LocalDate getDate() 
	{
		return date.get();
	}

	public void setDate(LocalDate date) 
	{
		this.date = new SimpleObjectProperty<>(date);
	}

	public LocalTime getTime() 
	{
		return time.get();
	}

	public void setTime(LocalTime time) 
	{
		this.time = new SimpleObjectProperty<>(time);
	}

	public String getId() 
	{
		return id.get();
	}

	public void setId(String id) 
	{
		this.id = new SimpleStringProperty(id);
	}

	public String getFirstName() 
	{
		return FirstName.get();
	}

	public void setFirstName(String FirstName) 
	{
		this.FirstName = new SimpleStringProperty(FirstName);
	}

	public String getLastName() 
	{
		return LastName.get();
	}

	public void setLastName(String LastName) 
	{
		this.LastName = new SimpleStringProperty(LastName);
	}

	public String getType() 
	{
		return type.get();
	}

	public void setType(String type) 
	{
		this.type = new SimpleStringProperty(type);
	}

}
