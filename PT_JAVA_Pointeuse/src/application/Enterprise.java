package application;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * the Enterprise class containing the list of Departments inside it!
 */
public class Enterprise implements Serializable
{
	private String name;
	private List<Department> ListDepartment;

	/**
	 * Default constructor, define the attributes with default values (empty list and a "null" name).
	 */
	public Enterprise()
	{
		this.name = null;
		ListDepartment = new ArrayList<>();
	}

	/**
	 * Comfort builder, create an object Enterprise initialized with a name.
	 * 
	 * @param 	name	The name of the future Enterprise.
	 */
	public Enterprise(String name)
	{
		this.name = name;
		ListDepartment = new ArrayList<>();
	}

	/**
	 * Getter of the attribute "name".
	 * 
	 * @return	The name of the Enterprise.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Setter of the attribute "name".
	 * 
	 * @param	name	The name that will replace the current name of the Enterprise.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Getter of the attribute "ListDepartment".
	 * 
	 * @return	The list of departments in the Enterprise.
	 */
	public List<Department> getListDepartment()
	{
		return ListDepartment;
	}

	/**
	 * Adding a department (if not existing already) into the enterprise.
	 * 
	 * @param 	DepartmentParam	The Department we try to add to the enterprise.
	 */
	public void addDepartement(Department DepartmentParam)
	{
		//** If a department like that doesn't exist **//
		if (ListDepartment.stream().map(Department::getName).noneMatch(DepartmentParam.getName()::equals))
		{
			//** We add it **//
			ListDepartment.add(DepartmentParam);
		}
	}

	/**
	 * To find a Department by its name only.
	 * 
	 * @param 	Name	The name of a department.
	 * @return			The object Department that possess the this.name = name.
	 * @throws 	IOException
	 */
	public Department getDepartmentByName(String Name) throws IOException
	{
		//** We try to know if the department is here **//
		if (ListDepartment.stream().map(Department::getName).anyMatch(Name::equals))
		{
			//** If it's a "yes", we want to retrieve it by going through the whole list **//
			for (int i = 0; i < ListDepartment.size(); i++)
			{
				//** We found it **//
				if (ListDepartment.get(i).getName().equals(Name))
				{
					//** We get it **//
					return ListDepartment.get(i);
				}
			}
		}
		
		//** If the department is nowhere to be found, doesn't exist **//
		else
		{
			throw new IOException();
		}
		return null;
	}

	/**
	 * Remove an object Department from the list of department.
	 * 
	 * @param 	DepartmentParam	The object Department that we want to remove from the enterprise.
	 */
	public void DeleteDepartment(Department DepartmentParam)
	{
		//** If the department exists **//
		if (ListDepartment.stream().map(Department::getName).anyMatch(DepartmentParam.getName()::equals))
		{
			//** We remove it **//
			ListDepartment.remove(DepartmentParam);
		}
	}
}
