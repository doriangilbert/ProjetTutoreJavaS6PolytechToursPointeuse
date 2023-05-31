package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable {
    private String id;
    private String FirstName;
    private String LastName;
    private List<Check> ListCheck;

    public Employee(String id, String FirstName,String LastName){
        this.id = id;
        this.FirstName=FirstName;
        this.LastName=LastName;
        ListCheck=new ArrayList<>();
    }

    public String getId() {
        return id;
    }
    public String getFirstName() {
        return FirstName;
    }
    public String getLastName() {
        return LastName;
    }
    public List<Check> getListCheck() {
        return ListCheck;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public void addCheck(Check CheckParam){
        if (ListCheck.stream().map(Check::getDate).noneMatch(CheckParam.getDate()::equals)) {
            ListCheck.add(CheckParam);
        }
    }
    public void deleteCheck(Check CheckParam){
        if (ListCheck.stream().map(Check::getDate).anyMatch(CheckParam.getDate()::equals)) {
            ListCheck.remove(CheckParam);
        }
    }
}
