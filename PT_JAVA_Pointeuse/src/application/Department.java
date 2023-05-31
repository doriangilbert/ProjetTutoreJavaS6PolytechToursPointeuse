package application;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {
    private String name;
    private List<Employee> ListEmployees;
    public Department(String name){
        this.name=name;
        ListEmployees=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getListEmployees() {
        return ListEmployees;
    }

    public void addEmployee(Employee EmployeeParam){
        if (ListEmployees.stream().map(Employee::getId).noneMatch(EmployeeParam.getId()::equals)){
            ListEmployees.add(EmployeeParam);
        }
    }

    public Employee getEmployeeById(String Id) throws IOException {
        if (ListEmployees.stream().map(Employee::getId).anyMatch(Id::equals)){
            for (int i=0;i<ListEmployees.size();i++){
                if (ListEmployees.get(i).getId().equals(Id)){
                    return ListEmployees.get(i);
                }
            }
        }
        else {
            throw new IOException();
        }
        return null;
    }
    public void DeleteEmployee(Employee EmployeeParam){
        if (ListEmployees.stream().map(Employee::getId).anyMatch(EmployeeParam.getId()::equals)){
            ListEmployees.remove(EmployeeParam);
        }
    }

}
