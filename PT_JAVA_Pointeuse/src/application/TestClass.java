package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class TestClass {
	public static void main(String[] args) {
		Check Check1 = new Check(true, false, LocalDateTime.now());
		Employee Employee1 = new Employee("475", "Mathéo", "Dhondt");
		Employee1.addCheck(Check1);
		Department Department1 = new Department("Informatique");
		Department1.addEmployee(Employee1);
		Enterprise enterprise1 = new Enterprise("PolyEntreprise");
		enterprise1.addDepartement(Department1);
		System.out.println(enterprise1.getName());

		try {
			System.out.println(enterprise1.getDepartmentByName("Informatique").getName());
			System.out.println(enterprise1.getDepartmentByName("Informatique").getEmployeeById("475").getFirstName());
			Enterprise enterprise2 = Deserialization("Enterprise1.dat");
			System.out.println(enterprise2.getDepartmentByName("Informatique").getName());
			System.out.println(enterprise2.getDepartmentByName("Informatique").getEmployeeById("475").getFirstName());
			System.out.println(
					enterprise2.getDepartmentByName("Informatique").getEmployeeById("475").getListCheck().size());
			System.out.println(
					enterprise2.getDepartmentByName("Informatique").getEmployeeById("475").getEndWorkDayTime(DayOfWeek.MONDAY));
		} catch (IOException e) {
			System.out.println("erreur");
		}

	}

	public static void Serialization(Enterprise enterpriseParam, String NomFichier) throws IOException {
		FileOutputStream fos = new FileOutputStream(NomFichier);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(enterpriseParam);
		oos.close();
	}

	public static Enterprise Deserialization(String NomFichier) throws IOException {
		FileInputStream fis = new FileInputStream(NomFichier);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Enterprise enterpriseParam = new Enterprise();
		try {
			enterpriseParam = (Enterprise) ois.readObject();
		} catch (ClassNotFoundException e) {

		}
		ois.close();
		return enterpriseParam;
	}
}