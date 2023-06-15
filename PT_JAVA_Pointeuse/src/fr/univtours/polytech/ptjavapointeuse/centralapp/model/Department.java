package fr.univtours.polytech.ptjavapointeuse.centralapp.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * the Department class containing the list of Employees working on a certain field!
 */
public class Department implements Serializable
{
	private transient StringProperty name;
	private List<Employee> ListEmployees;

	/**
	 * Method to have "default" attributes for a new class.
	 */
	private void InitProperties()
	{
		this.name = new SimpleStringProperty();
		ListEmployees = new ArrayList<>();
	}

	/**
	 * Default constructor, use the previous method to create an object with default attributes.
	 */
	public Department()
	{
		InitProperties();
	}

	/**
	 * Comfort builder, create an object Department initialized with a name.
	 * 
	 * @param 	name	The name of the future Department.
	 */
	public Department(String name)
	{
		this.name = new SimpleStringProperty(name);
		//** We still have an empty list of employees **//
		ListEmployees = new ArrayList<>();
	}

	/**
	 * Getter of the attribute "name".
	 * 
	 * @return	The name of the Department.
	 */
	public String getName()
	{
		return name.get();
	}

	/**
	 * Setter of the attribute "name".
	 * 
	 * @param	name	The name that will replace the current name of the Department.
	 */
	public void setName(String name)
	{
		this.name = new SimpleStringProperty(name);
	}

	/**
	 * Getter of the attribute "ListEmployees".
	 * 
	 * @return	The list of employees in the Department.
	 */
	public List<Employee> getListEmployees()
	{
		return ListEmployees;
	}

	/**
	 * Adding an employee (if not existing already) inside the enterprise.
	 * 
	 * @param	EmployeeParam	The Employee we try to add to the enterprise.
	 */
	public void addEmployee(Employee EmployeeParam)
	{
		//** If an employee like that doesn't exist **//
		if (ListEmployees.stream().map(Employee::getId).noneMatch(EmployeeParam.getId()::equals))
		{
			//** We add him **//
			ListEmployees.add(EmployeeParam);
		}
	}

	/**
	 * To find an Employee by his ID only.
	 * 
	 * @param	Id	The ID of an employee.
	 * @return		The object Employee that possess the ID = Id.
	 * @throws IOException
	 */
	public Employee getEmployeeById(String Id) throws IOException
	{
		//** We try to know if the employee is here **//
		if (ListEmployees.stream().map(Employee::getId).anyMatch(Id::equals))
		{
			//** If it's a "yes", we want to retrieve him by going through the whole list **//
			for (int i = 0; i < ListEmployees.size(); i++)
			{
				//** We found him **//
				if (ListEmployees.get(i).getId().equals(Id))
				{
					//** We get him **//
					return ListEmployees.get(i);
				}
			}
		}
		
		//** If the employee is nowhere to be found, not in the enterprise (or already fired) **//
		return null;
	}

	/**
	 * Remove an object Employee from the list of employees.
	 * 
	 * @param	EmployeeParam	The object Employee that we want to "fire" from the enterprise.
	 */
	public void DeleteEmployee(Employee EmployeeParam)
	{
		//** If the employee is here **//
		if (ListEmployees.stream().map(Employee::getId).anyMatch(EmployeeParam.getId()::equals))
		{
			//** We remove him **//
			ListEmployees.remove(EmployeeParam);
		}
	}

	/**
	 * 
	 * @param 	s	
	 * @throws 	IOException
	 */
	private void writeObject(ObjectOutputStream s) throws IOException
	{
		s.defaultWriteObject();
		s.writeUTF(name.getValueSafe());
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
		this.name.set(s.readUTF());
		// set values in the same order as writeObject()
	}

}
