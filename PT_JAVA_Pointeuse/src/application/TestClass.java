package application;

import java.io.*;
import java.util.Date;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
            Check Check1=new Check(true,false,new Date(),14,15);
            Employee Employee1=new Employee("475","Mathéo","Dhondt");
            Employee1.addCheck(Check1);
            Department Department1=new Department("Informatique");
            Department1.addEmployee(Employee1);
            Enterprise enterprise1 = new Enterprise("PolyEntreprise");
            enterprise1.addDepartement(Department1);
            System.out.println(enterprise1.getName());

            try{
                System.out.println(enterprise1.getDepartmentByName("Informatique").getName());
                System.out.println(enterprise1.getDepartmentByName("Informatique").getEmployeeById("475").getFirstName());
                Serialization(enterprise1,"Entreprise1.dat");
                Enterprise enterprise2 =Deserialization("Entreprise1.dat");
                System.out.println(enterprise2.getDepartmentByName("Informatique").getName());
                System.out.println(enterprise2.getDepartmentByName("Informatique").getEmployeeById("475").getFirstName());
                enterprise1.DeleteDepartment(Department1);
                List<Department> ListDepartment= enterprise1.getListDepartment();
                System.out.println(ListDepartment.size());
                Department DepartmentDel= enterprise2.getDepartmentByName("Informatique");
                enterprise2.DeleteDepartment(DepartmentDel);
                System.out.println(enterprise2.getListDepartment().size());
                enterprise2.addDepartement(Department1);
                Check Check2=new Check(true,false,new Date(),15,06);
                enterprise2.getDepartmentByName("Informatique").getEmployeeById("475").addCheck(Check2);
                System.out.println(enterprise2.getDepartmentByName("Informatique").getEmployeeById("475").getListCheck().size());

            }
            catch(IOException e){

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
        try{
            enterpriseParam =(Enterprise) ois.readObject();
        }
        catch (ClassNotFoundException e){

        }
        ois.close();
        return enterpriseParam;
    }
}