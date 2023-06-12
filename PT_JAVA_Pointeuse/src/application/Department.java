package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Department implements Serializable {
	private transient StringProperty name;
	private List<Employee> ListEmployees;

	private void InitProperties() {
		this.name = new SimpleStringProperty();
		ListEmployees = new ArrayList<>();
	}

	public Department() {
		InitProperties();
	}

	public Department(String name) {
		this.name = new SimpleStringProperty(name);
		ListEmployees = new ArrayList<>();
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

	public List<Employee> getListEmployees() {
		return ListEmployees;
	}

	public void addEmployee(Employee EmployeeParam) {
		if (ListEmployees.stream().map(Employee::getId).noneMatch(EmployeeParam.getId()::equals)) {
			ListEmployees.add(EmployeeParam);
		}
	}

	public Employee getEmployeeById(String Id) throws IOException {
		if (ListEmployees.stream().map(Employee::getId).anyMatch(Id::equals)) {
			for (int i = 0; i < ListEmployees.size(); i++) {
				if (ListEmployees.get(i).getId().equals(Id)) {
					return ListEmployees.get(i);
				}
			}
		} else {
			throw new IOException();
		}
		return null;
	}

	public void DeleteEmployee(Employee EmployeeParam) {
		if (ListEmployees.stream().map(Employee::getId).anyMatch(EmployeeParam.getId()::equals)) {
			ListEmployees.remove(EmployeeParam);
		}
	}

	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();
		s.writeUTF(name.getValueSafe());
		s.writeObject(ListEmployees);
	}

	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		InitProperties();
		s.defaultReadObject();
		this.name.set(s.readUTF());
		// set values in the same order as writeObject()
	}

}
