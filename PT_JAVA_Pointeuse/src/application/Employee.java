package application;



import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Employee implements Serializable {
    private transient StringProperty id;
    private transient StringProperty FirstName;
    private transient StringProperty LastName;
    private List<Check> ListCheck;

    private void InitProperties(){
        this.id = new SimpleStringProperty();
        this.FirstName=new SimpleStringProperty();
        this.LastName=new SimpleStringProperty();
        ListCheck=new ArrayList<>();
    }
    public Employee(){
        this.id = new SimpleStringProperty();
        this.FirstName=new SimpleStringProperty();
        this.LastName=new SimpleStringProperty();
        ListCheck=new ArrayList<>();
    }
    public Employee(String id, String FirstName,String LastName){
        this.id = new SimpleStringProperty(id);
        this.FirstName=new SimpleStringProperty(FirstName);
        this.LastName=new SimpleStringProperty(LastName);
        ListCheck=new ArrayList<>();
    }

    public String getId() {
        return id.get();
    }
    public String getFirstName() {
        return FirstName.get();
    }
    public String getLastName() {
        return LastName.get();
    }
    public List<Check> getListCheck() {
        return ListCheck;
    }
    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }
    public void setFirstName(String firstName) {
        FirstName = new SimpleStringProperty(firstName);
    }
    public void setLastName(String lastName) {
        LastName = new SimpleStringProperty(lastName);
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

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(id.getValueSafe());
        s.writeUTF(FirstName.getValueSafe());
        s.writeUTF(LastName.getValueSafe());
        s.writeObject(ListCheck);
    }
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        InitProperties();
        s.defaultReadObject();
        id.set(s.readUTF());
        FirstName.set(s.readUTF());
        LastName.set(s.readUTF());

        // set values in the same order as writeObject()
    }
}
