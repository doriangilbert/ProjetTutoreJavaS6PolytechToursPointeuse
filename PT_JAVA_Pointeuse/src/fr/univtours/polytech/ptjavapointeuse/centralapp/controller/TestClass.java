package fr.univtours.polytech.ptjavapointeuse.centralapp.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

import fr.univtours.polytech.ptjavapointeuse.centralapp.model.Check;
import fr.univtours.polytech.ptjavapointeuse.centralapp.model.Department;
import fr.univtours.polytech.ptjavapointeuse.centralapp.model.Employee;
import fr.univtours.polytech.ptjavapointeuse.centralapp.model.Enterprise;

/**
 * The F0 function of the project.
 * Creates a virtual enterprise with virtual departments/employees.
 */
public class TestClass
{
	/**
	 * This method create a virtual enterprise to make it easy for the user to test the applications.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Check Check1 = new Check(true, false, LocalDateTime.now());
		Employee Employee1 = new Employee("Mathéo", "Dhondt");
		Employee Employee2 = new Employee("Dorian", "Gilbert");
		//Employee1.addCheck(Check1);
		Employee1.addCheck(new Check(true, false, LocalDateTime.of(2023,6,13,8,55)));
		Employee1.addCheck(new Check(false, false, LocalDateTime.of(2023,6,13,17,05)));
		Employee2.addCheck(new Check(true, false, LocalDateTime.of(2023,6,15,7,55)));
		Employee2.addCheck(new Check(false, false, LocalDateTime.of(2023,6,15,16,05)));
		Employee1.addCheck(new Check(true, false, LocalDateTime.of(2023,6,15,9,55)));
		//Employee1.addCheck(new Check(false, false, LocalDateTime.of(2023,6,15,18,05)));
		Department Department1 = new Department("Informatique");
		Department Department2 = new Department("Mecanique");
		Department1.addEmployee(Employee1);
		Department2.addEmployee(Employee2);
		Enterprise enterprise1 = new Enterprise("PolyEntreprise");
		enterprise1.addDepartement(Department1);
		enterprise1.addDepartement(Department2);
		System.out.println(enterprise1.getName());

		try
		{
			System.out.println(enterprise1.getDepartmentByName("Informatique").getName());
			System.out.println(enterprise1.getDepartmentByName("Informatique").getEmployeeById("1").getFirstName());
			Serialization(enterprise1,"Enterprise1.dat");
			Enterprise enterprise2 = Deserialization("Enterprise1.dat");
			System.out.println(enterprise2.getDepartmentByName("Informatique").getName());
			System.out.println(enterprise2.getDepartmentByName("Informatique").getEmployeeById("1").getFirstName());
			System.out.println(
					enterprise2.getDepartmentByName("Informatique").getEmployeeById("1").getListCheck().size());
			System.out.println(
					enterprise2.getDepartmentByName("Informatique").getEmployeeById("1").getEndWorkDayTime(DayOfWeek.MONDAY));
			System.out.println(
					enterprise2.getDepartmentByName("Informatique").getListEmployees().size());
		}
		
		catch (IOException error)
		{
			System.out.println("error");
		}

	}

	/**
	 * Function to serialize all the information to a file.
	 * 
	 * @param enterpriseParam	The enterprise we want to serialize.
	 * @param NomFichier		The file where we want to stock all the information of the enterprise.
	 * @throws IOException
	 */
	public static void Serialization(Enterprise enterpriseParam, String NomFichier) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(NomFichier);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(enterpriseParam);
		oos.close();
	}

	/**
	 * Function to deserialize all the information from a file to create on object from it.
	 * 
	 * @param NomFichier	The file where we want to take all the information of the enterprise.
	 * @return				An object Enterprise with all the informations from the file.
	 * @throws IOException
	 */
	public static Enterprise Deserialization(String NomFichier) throws IOException
	{
		FileInputStream fis = new FileInputStream(NomFichier);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Enterprise enterpriseParam = new Enterprise();
		try
		{
			enterpriseParam = (Enterprise) ois.readObject();
		}
		
		catch (ClassNotFoundException error)
		{
			System.out.println("error deserialization");
		}
		ois.close();
		return enterpriseParam;
	}
}