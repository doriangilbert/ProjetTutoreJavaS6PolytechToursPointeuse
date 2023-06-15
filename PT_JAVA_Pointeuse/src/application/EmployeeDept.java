package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeDept {
	private transient StringProperty id;
	private transient StringProperty FirstName;
	private transient StringProperty LastName;
	private transient StringProperty Department;
	
	private void InitProperties()
	{
		this.id = new SimpleStringProperty();
		this.FirstName = new SimpleStringProperty();
		this.LastName = new SimpleStringProperty();
		this.Department = new SimpleStringProperty();
	}

	public EmployeeDept()
	{
		InitProperties();
	}

	public EmployeeDept(String id, String FirstName, String LastName, String Department)
	{
		InitProperties();
		this.id = new SimpleStringProperty(id);
		this.FirstName = new SimpleStringProperty(FirstName);
		this.LastName = new SimpleStringProperty(LastName);
		this.Department = new SimpleStringProperty(Department);
	}
	
	/**
	 * @return the id
	 */
	public String getId()
	{
		return id.get();
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = new SimpleStringProperty(id);
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return FirstName.get();
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName)
	{
		FirstName = new SimpleStringProperty(firstName);
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return LastName.get();
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName)
	{
		LastName = new SimpleStringProperty(lastName);
	}
	
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return Department.get();
	}
	
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department)
	{
		Department = new SimpleStringProperty(department);
	}	
}
