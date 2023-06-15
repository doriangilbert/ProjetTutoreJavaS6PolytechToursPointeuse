package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class to regroup all information for the staff management page!
 */
public class EmployeeDept
{
	private transient StringProperty id;
	private transient StringProperty FirstName;
	private transient StringProperty LastName;
	private transient StringProperty Department;
	
	/**
	 * Method to have "default" attributes for a new class.
	 */
	private void InitProperties()
	{
		this.id = new SimpleStringProperty();
		this.FirstName = new SimpleStringProperty();
		this.LastName = new SimpleStringProperty();
		this.Department = new SimpleStringProperty();
	}

	/**
	 * Default constructor, use the previous method to create an object with default attributes.
	 */
	public EmployeeDept()
	{
		InitProperties();
	}

	/**
	 * Comfort builder, create an object initialized with all chosen arguments.
	 * 
	 * @param id			The employee's identification.
	 * @param FirstName		The employee's first name.
	 * @param LastName		The employee's last name.
	 * @param Department	The department where the employee will work.
	 */
	public EmployeeDept(String id, String FirstName, String LastName, String Department)
	{
		InitProperties();
		this.id = new SimpleStringProperty(id);
		this.FirstName = new SimpleStringProperty(FirstName);
		this.LastName = new SimpleStringProperty(LastName);
		this.Department = new SimpleStringProperty(Department);
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
	public void setFirstName(String firstName)
	{
		FirstName = new SimpleStringProperty(firstName);
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
	public void setLastName(String lastName)
	{
		LastName = new SimpleStringProperty(lastName);
	}
	
	/**
	 * Getter of the attribute "Department".
	 * 
	 * @return	The department where the employee works.
	 */
	public String getDepartment() {
		return Department.get();
	}
	
	/**
	 * Setter for the attribute "Department".
	 * 
	 * @param department the department to set
	 */
	public void setDepartment(String department)
	{
		Department = new SimpleStringProperty(department);
	}	
}
