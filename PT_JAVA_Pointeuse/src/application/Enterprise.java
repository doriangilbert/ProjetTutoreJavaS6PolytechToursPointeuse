package application;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Enterprise implements Serializable {

    private String name;

    private List<Department> ListDepartment;

    public Enterprise(){
        this.name=null;
        ListDepartment=new ArrayList<>();

    }

    public Enterprise(String name){
        this.name=name;
        ListDepartment=new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getListDepartment() {
        return ListDepartment;
    }

    public void addDepartement(Department DepartmentParam){
        if (ListDepartment.stream().map(Department::getName).noneMatch(DepartmentParam.getName()::equals)){
            ListDepartment.add(DepartmentParam);
        }
    }

    public Department getDepartmentByName(String Name) throws IOException {
        if (ListDepartment.stream().map(Department::getName).anyMatch(Name::equals)){
            for (int i=0;i<ListDepartment.size();i++){
                if (ListDepartment.get(i).getName().equals(Name)){
                    return ListDepartment.get(i);
                }
            }
        }
        else {
            throw new IOException();
        }
        return null;
    }
    public void DeleteDepartment(Department DepartmentParam){
        if (ListDepartment.stream().map(Department::getName).anyMatch(DepartmentParam.getName()::equals)){
            ListDepartment.remove(DepartmentParam);
        }
    }
}
